package filipeliujavamodule.test;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import junit.framework.Assert;

import org.ini4j.Ini;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import us.kbase.common.service.ServerException;
import assemblyutil.AssemblyUtilClient;
import assemblyutil.FastaAssemblyFile;
import assemblyutil.SaveAssemblyParams;
import filipeliujavamodule.FilipeliuJavaModuleServer;
import us.kbase.auth.AuthConfig;
import us.kbase.auth.AuthToken;
import us.kbase.auth.ConfigurableAuthService;
import us.kbase.common.service.JsonServerSyslog;
import us.kbase.common.service.RpcContext;
import us.kbase.common.service.UObject;
import us.kbase.workspace.CreateWorkspaceParams;
import us.kbase.workspace.ProvenanceAction;
import us.kbase.workspace.WorkspaceClient;
import us.kbase.workspace.WorkspaceIdentity;

public class FilipeliuJavaModuleServerTest {
    private static AuthToken token = null;
    private static Map<String, String> config = null;
    private static WorkspaceClient wsClient = null;
    private static String wsName = null;
    private static FilipeliuJavaModuleServer impl = null;
    private static Path scratch;
    private static URL callbackURL;
    
    @BeforeClass
    public static void init() throws Exception {
        // Config loading
        String configFilePath = System.getenv("KB_DEPLOYMENT_CONFIG");
        File deploy = new File(configFilePath);
        Ini ini = new Ini(deploy);
        config = ini.get("filipeliu_java_module");
        // Token validation
        String authUrl = config.get("auth-service-url");
        String authUrlInsecure = config.get("auth-service-url-allow-insecure");
        ConfigurableAuthService authService = new ConfigurableAuthService(
                new AuthConfig().withKBaseAuthServerURL(new URL(authUrl))
                .withAllowInsecureURLs("true".equals(authUrlInsecure)));
        token = authService.validateToken(System.getenv("KB_AUTH_TOKEN"));
        // Reading URLs from config
        wsClient = new WorkspaceClient(new URL(config.get("workspace-url")), token);
        wsClient.setIsInsecureHttpConnectionAllowed(true); // do we need this?
        callbackURL = new URL(System.getenv("SDK_CALLBACK_URL"));
        scratch = Paths.get(config.get("scratch"));
        // These lines are necessary because we don't want to start linux syslog bridge service
        JsonServerSyslog.setStaticUseSyslog(false);
        JsonServerSyslog.setStaticMlogFile(new File(config.get("scratch"), "test.log")
            .getAbsolutePath());
        impl = new FilipeliuJavaModuleServer();
    }
    
    private static String getWsName() throws Exception {
        if (wsName == null) {
            long suffix = System.currentTimeMillis();
            wsName = "test_FilipeliuJavaModule_" + suffix;
            wsClient.createWorkspace(new CreateWorkspaceParams().withWorkspace(wsName));
        }
        return wsName;
    }
    
    private static RpcContext getContext() {
        return new RpcContext().withProvenance(Arrays.asList(new ProvenanceAction()
            .withService("filipeliu_java_module").withMethod("please_never_use_it_in_production")
            .withMethodParams(new ArrayList<UObject>())));
    }
    
    @AfterClass
    public static void cleanup() {
        if (wsName != null) {
            try {
                wsClient.deleteWorkspace(new WorkspaceIdentity().withWorkspace(wsName));
                System.out.println("Test workspace was deleted");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    private String loadFASTA(
            final Path filename,
            final String objectName,
            final String filecontents)
            throws Exception {
        Files.write(filename, filecontents.getBytes(StandardCharsets.UTF_8));
        final AssemblyUtilClient assyUtil = new AssemblyUtilClient(callbackURL, token);
        /* since the callback server is plain http need this line.
         * CBS is on the same machine as the docker container
         */
        assyUtil.setIsInsecureHttpConnectionAllowed(true);
        return assyUtil.saveAssemblyFromFasta(new SaveAssemblyParams()
                .withAssemblyName(objectName)
                .withWorkspaceName(getWsName())
                .withFile(new FastaAssemblyFile().withPath(filename.toString())));
        
    }
    
    @Test
    public void test_runFilipeliuJavaModule_ok() throws Exception {
        // First load a test FASTA file as an KBase Assembly
        final String fastaContent = ">seq1 something something asdf\n" +
                                    "agcttttcat\n" +
                                    ">seq2\n" +
                                    "agctt\n" +
                                    ">seq3\n" +
                                    "agcttttcatgg";
        
        final String ref = loadFASTA(scratch.resolve("test1.fasta"), "TestAssembly", fastaContent);
        
        // second, call the implementation
        Map<String, UObject> params = new HashMap<>();
        params.put("workspace_name", new UObject(getWsName()));
        params.put("assembly_input_ref", new UObject(ref));
        params.put("min_length", new UObject(10L));
        impl.runFilipeliuJavaModule(params, token, getContext());

    }
    
    @Test
    public void test_runFilipeliuJavaModule_err1() throws Exception {
        try {
            Map<String, UObject> params = new HashMap<>();
            params.put("workspace_name", new UObject(getWsName()));
            params.put("assembly_input_ref", new UObject("fake/fake/1"));
            impl.runFilipeliuJavaModule(params, token, getContext());
            Assert.fail("Error is expected above");
        } catch (IllegalArgumentException ex) {
            Assert.assertEquals("Parameter min_length is not set in input arguments",
                    ex.getMessage());
        }
    }
    
    @Test
    public void test_runFilipeliuJavaModule_err2() throws Exception {
        try {
            Map<String, UObject> params = new HashMap<>();
            params.put("workspace_name", new UObject(getWsName()));
            params.put("assembly_input_ref", new UObject("fake/fake/1"));
            params.put("min_length", new UObject(-10L));
            impl.runFilipeliuJavaModule(params, token, getContext());
            Assert.fail("Error is expected above");
        } catch (IllegalArgumentException ex) {
            Assert.assertEquals("min_length parameter cannot be negative (-10)", ex.getMessage());
        }
    }
    
    @Test
    public void test_runFilipeliuJavaModule_err3() throws Exception {
        try {
            Map<String, UObject> params = new HashMap<>();
            params.put("workspace_name", new UObject(getWsName()));
            params.put("assembly_input_ref", new UObject("fake"));
            params.put("min_length", new UObject(10L));
            impl.runFilipeliuJavaModule(params, token, getContext());
            Assert.fail("Error is expected above");
        } catch (ServerException ex) {
            Assert.assertEquals("Error on ObjectSpecification #1: Illegal number of separators " +
                    "/ in object reference fake", ex.getMessage());
        }
    }
}
