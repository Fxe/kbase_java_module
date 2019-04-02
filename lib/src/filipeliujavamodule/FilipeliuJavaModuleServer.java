package filipeliujavamodule;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import us.kbase.auth.AuthToken;
import us.kbase.common.service.JsonServerMethod;
import us.kbase.common.service.JsonServerServlet;
import us.kbase.common.service.JsonServerSyslog;
import us.kbase.common.service.RpcContext;
import us.kbase.common.service.UObject;

//BEGIN_HEADER
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.net.MalformedURLException;

import assemblyutil.AssemblyUtilClient;
import assemblyutil.FastaAssemblyFile;
import assemblyutil.GetAssemblyParams;
import assemblyutil.SaveAssemblyParams;
import kbasereport.CreateParams;
import kbasereport.KBaseReportClient;
import kbasereport.SimpleReport;
import kbasereport.ReportInfo;
import kbasereport.WorkspaceObject;
import filipeliujavamodule.ReportResults;
//END_HEADER

/**
 * <p>Original spec-file module name: filipeliu_java_module</p>
 * <pre>
 * A KBase module: filipeliu_java_module
 * This sample module contains one small method that filters contigs.
 * </pre>
 */
public class FilipeliuJavaModuleServer extends JsonServerServlet {
    private static final long serialVersionUID = 1L;
    private static final String version = "0.0.1";
    private static final String gitUrl = "";
    private static final String gitCommitHash = "";

    //BEGIN_CLASS_HEADER
    private final URL callbackURL;
    private final Path scratch;
    //END_CLASS_HEADER

    public FilipeliuJavaModuleServer() throws Exception {
        super("filipeliu_java_module");
        //BEGIN_CONSTRUCTOR
        final String sdkURL = System.getenv("SDK_CALLBACK_URL");
        try {
            callbackURL = new URL(sdkURL);
            System.out.println("Got SDK_CALLBACK_URL " + callbackURL);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Invalid SDK callback url: " + sdkURL, e);
        }
        scratch = Paths.get(super.config.get("scratch"));
        //END_CONSTRUCTOR
    }

    /**
     * <p>Original spec-file function name: run_filipeliu_java_module</p>
     * <pre>
     * This example function accepts any number of parameters and returns results in a KBaseReport
     * </pre>
     * @param   params   instance of mapping from String to unspecified object
     * @return   parameter "output" of type {@link filipeliujavamodule.ReportResults ReportResults}
     */
    @JsonServerMethod(rpc = "filipeliu_java_module.run_filipeliu_java_module", async=true)
    public ReportResults runFilipeliuJavaModule(Map<String,UObject> params, AuthToken authPart, RpcContext jsonRpcContext) throws Exception {
        ReportResults returnVal = null;
        //BEGIN run_filipeliu_java_module
        
        // Print statements to stdout/stderr are captured and available as the App log
        System.out.println("Starting filter contigs. Parameters:");
        System.out.println(params);
        
        /* Step 1 - Parse/examine the parameters and catch any errors
         * It is important to check that parameters exist and are defined, and that nice error
         * messages are returned to users.  Parameter values go through basic validation when
         * defined in a Narrative App, but advanced users or other SDK developers can call
         * this function directly, so validation is still important.
         */
        final String workspaceName = params.get("workspace_name").asInstance();
        if (workspaceName == null || workspaceName.isEmpty()) {
            throw new IllegalArgumentException(
                "Parameter workspace_name is not set in input arguments");
        }
        final String assyRef = params.get("assembly_input_ref").asInstance();
        if (assyRef == null || assyRef.isEmpty()) {
            throw new IllegalArgumentException(
                    "Parameter assembly_input_ref is not set in input arguments");
        }
        if (!params.containsKey("min_length")) {
            throw new IllegalArgumentException(
            "Parameter min_length is not set in input arguments");
        }
        final long minLength = params.get("min_length").asInstance();
        if (minLength < 0) {
            throw new IllegalArgumentException("min_length parameter cannot be negative (" +
                    minLength + ")");
        }
        
        /* Step 2 - Download the input data as a Fasta file
         * We can use the AssemblyUtils module to download a FASTA file from our Assembly data
         * object. The return object gives us the path to the file that was created.
         */
        System.out.println("Downloading assembly data as FASTA file.");
        final AssemblyUtilClient assyUtil = new AssemblyUtilClient(callbackURL, authPart);
        /* Normally this is bad practice, but the callback server (which runs on the same machine
         * as the docker container running the method) is http only
         * TODO Should allow the clients to not require a token, even for auth required methods,
         * since the callback server ignores the incoming token. No need to transmit the token
         * here.
         */
        assyUtil.setIsInsecureHttpConnectionAllowed(true);

        /* Step 3 - Actually perform the filter operation, saving the good contigs to a new
         * fasta file.
         */
        final Path out = scratch.resolve("filtered.fasta");
        long total = 11;
        long remaining = 22;

        final String resultText = String.format("Filtered assembly to %s contigs out of %s %s",
                remaining, total, out);
        System.out.println(resultText);
        
        // Step 4 - Save the new Assembly back to the system
        
        final String newAssyRef = "";
        
        // Step 5 - Build a Report and return
        
        final KBaseReportClient kbr = new KBaseReportClient(callbackURL, authPart);
        // see note above about bad practice
        kbr.setIsInsecureHttpConnectionAllowed(true);
        final ReportInfo report = kbr.create(new CreateParams().withWorkspaceName(workspaceName)
                .withReport(new SimpleReport().withTextMessage(resultText)));
        // Step 6: contruct the output to send back
        
        returnVal = new ReportResults()
                .withReportName(report.getName())
                .withReportRef(report.getRef());

        System.out.println("returning:\n" + returnVal);
        //END run_filipeliu_java_module
        return returnVal;
    }
    @JsonServerMethod(rpc = "filipeliu_java_module.status")
    public Map<String, Object> status() {
        Map<String, Object> returnVal = null;
        //BEGIN_STATUS
        returnVal = new LinkedHashMap<String, Object>();
        returnVal.put("state", "OK");
        returnVal.put("message", "");
        returnVal.put("version", version);
        returnVal.put("git_url", gitUrl);
        returnVal.put("git_commit_hash", gitCommitHash);
        //END_STATUS
        return returnVal;
    }

    public static void main(String[] args) throws Exception {
        if (args.length == 1) {
            new FilipeliuJavaModuleServer().startupServer(Integer.parseInt(args[0]));
        } else if (args.length == 3) {
            JsonServerSyslog.setStaticUseSyslog(false);
            JsonServerSyslog.setStaticMlogFile(args[1] + ".log");
            new FilipeliuJavaModuleServer().processRpcCall(new File(args[0]), new File(args[1]), args[2]);
        } else {
            System.out.println("Usage: <program> <server_port>");
            System.out.println("   or: <program> <context_json_file> <output_json_file> <token>");
            return;
        }
    }
}
