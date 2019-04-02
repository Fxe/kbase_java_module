
package kbasereport;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * <p>Original spec-file type: CreateParams</p>
 * <pre>
 * * Parameters for the create() method
 * *
 * * Pass in *either* workspace_name or workspace_id -- only one is needed.
 * * Note that workspace_id is preferred over workspace_name because workspace_id immutable.
 * *
 * * Required arguments:
 * *     SimpleReport report - See the structure above
 * *     string workspace_name - Workspace name of the running app. Required
 * *         if workspace_id is absent
 * *     int workspace_id - Workspace ID of the running app. Required if
 * *         workspace_name is absent
 * </pre>
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("com.googlecode.jsonschema2pojo")
@JsonPropertyOrder({
    "report",
    "workspace_name",
    "workspace_id"
})
public class CreateParams {

    /**
     * <p>Original spec-file type: SimpleReport</p>
     * <pre>
     * * A simple report for use in create()
     * * Optional arguments:
     * *     string text_message - Readable plain-text report message
     * *     string direct_html - Simple HTML text that will be rendered within the report widget
     * *     list<string> warnings - A list of plain-text warning messages
     * *     list<WorkspaceObject> objects_created - List of result workspace objects that this app
     * *         has created. They will get linked in the report view
     * </pre>
     * 
     */
    @JsonProperty("report")
    private SimpleReport report;
    @JsonProperty("workspace_name")
    private String workspaceName;
    @JsonProperty("workspace_id")
    private Long workspaceId;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * <p>Original spec-file type: SimpleReport</p>
     * <pre>
     * * A simple report for use in create()
     * * Optional arguments:
     * *     string text_message - Readable plain-text report message
     * *     string direct_html - Simple HTML text that will be rendered within the report widget
     * *     list<string> warnings - A list of plain-text warning messages
     * *     list<WorkspaceObject> objects_created - List of result workspace objects that this app
     * *         has created. They will get linked in the report view
     * </pre>
     * 
     */
    @JsonProperty("report")
    public SimpleReport getReport() {
        return report;
    }

    /**
     * <p>Original spec-file type: SimpleReport</p>
     * <pre>
     * * A simple report for use in create()
     * * Optional arguments:
     * *     string text_message - Readable plain-text report message
     * *     string direct_html - Simple HTML text that will be rendered within the report widget
     * *     list<string> warnings - A list of plain-text warning messages
     * *     list<WorkspaceObject> objects_created - List of result workspace objects that this app
     * *         has created. They will get linked in the report view
     * </pre>
     * 
     */
    @JsonProperty("report")
    public void setReport(SimpleReport report) {
        this.report = report;
    }

    public CreateParams withReport(SimpleReport report) {
        this.report = report;
        return this;
    }

    @JsonProperty("workspace_name")
    public String getWorkspaceName() {
        return workspaceName;
    }

    @JsonProperty("workspace_name")
    public void setWorkspaceName(String workspaceName) {
        this.workspaceName = workspaceName;
    }

    public CreateParams withWorkspaceName(String workspaceName) {
        this.workspaceName = workspaceName;
        return this;
    }

    @JsonProperty("workspace_id")
    public Long getWorkspaceId() {
        return workspaceId;
    }

    @JsonProperty("workspace_id")
    public void setWorkspaceId(Long workspaceId) {
        this.workspaceId = workspaceId;
    }

    public CreateParams withWorkspaceId(Long workspaceId) {
        this.workspaceId = workspaceId;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperties(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return ((((((((("CreateParams"+" [report=")+ report)+", workspaceName=")+ workspaceName)+", workspaceId=")+ workspaceId)+", additionalProperties=")+ additionalProperties)+"]");
    }

}
