
package kbasereport;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * <p>Original spec-file type: CreateExtendedReportParams</p>
 * <pre>
 * * Parameters used to create a more complex report with file and HTML links
 * *
 * * Pass in *either* workspace_name or workspace_id -- only one is needed.
 * * Note that workspace_id is preferred over workspace_name because workspace_id immutable.
 * *
 * * Required arguments:
 * *     string workspace_name - Name of the workspace where the report
 * *         should be saved. Required if workspace_id is absent
 * *     int workspace_id - ID of workspace where the report should be saved.
 * *         Required if workspace_name is absent
 * * Optional arguments:
 * *     string message - Simple text message to store in the report object
 * *     list<WorkspaceObject> objects_created - List of result workspace objects that this app
 * *         has created. They will be linked in the report view
 * *     list<string> warnings - A list of plain-text warning messages
 * *     list<File> html_links - A list of paths or shock IDs pointing to HTML files or directories.
 * *         If you pass in paths to directories, they will be zipped and uploaded
 * *     int direct_html_link_index - Index in html_links to set the direct/default view in the
 * *         report. Set either direct_html_link_index or direct_html, but not both
 * *     string direct_html - Simple HTML text content that will be rendered within the report
 * *         widget. Set either direct_html or direct_html_link_index, but not both
 * *     list<File> file_links - A list of file paths or shock node IDs. Allows the user to
 * *         specify files that the report widget should link for download. If you pass in paths
 * *         to directories, they will be zipped
 * *     string report_object_name - Name to use for the report object (will
 * *         be auto-generated if unspecified)
 * *     html_window_height - Fixed height in pixels of the HTML window for the report
 * *     summary_window_height - Fixed height in pixels of the summary window for the report
 * </pre>
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("com.googlecode.jsonschema2pojo")
@JsonPropertyOrder({
    "message",
    "objects_created",
    "warnings",
    "html_links",
    "direct_html",
    "direct_html_link_index",
    "file_links",
    "report_object_name",
    "html_window_height",
    "summary_window_height",
    "workspace_name",
    "workspace_id"
})
public class CreateExtendedReportParams {

    @JsonProperty("message")
    private java.lang.String message;
    @JsonProperty("objects_created")
    private List<WorkspaceObject> objectsCreated;
    @JsonProperty("warnings")
    private List<String> warnings;
    @JsonProperty("html_links")
    private List<kbasereport.File> htmlLinks;
    @JsonProperty("direct_html")
    private java.lang.String directHtml;
    @JsonProperty("direct_html_link_index")
    private Long directHtmlLinkIndex;
    @JsonProperty("file_links")
    private List<kbasereport.File> fileLinks;
    @JsonProperty("report_object_name")
    private java.lang.String reportObjectName;
    @JsonProperty("html_window_height")
    private Double htmlWindowHeight;
    @JsonProperty("summary_window_height")
    private Double summaryWindowHeight;
    @JsonProperty("workspace_name")
    private java.lang.String workspaceName;
    @JsonProperty("workspace_id")
    private Long workspaceId;
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();

    @JsonProperty("message")
    public java.lang.String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(java.lang.String message) {
        this.message = message;
    }

    public CreateExtendedReportParams withMessage(java.lang.String message) {
        this.message = message;
        return this;
    }

    @JsonProperty("objects_created")
    public List<WorkspaceObject> getObjectsCreated() {
        return objectsCreated;
    }

    @JsonProperty("objects_created")
    public void setObjectsCreated(List<WorkspaceObject> objectsCreated) {
        this.objectsCreated = objectsCreated;
    }

    public CreateExtendedReportParams withObjectsCreated(List<WorkspaceObject> objectsCreated) {
        this.objectsCreated = objectsCreated;
        return this;
    }

    @JsonProperty("warnings")
    public List<String> getWarnings() {
        return warnings;
    }

    @JsonProperty("warnings")
    public void setWarnings(List<String> warnings) {
        this.warnings = warnings;
    }

    public CreateExtendedReportParams withWarnings(List<String> warnings) {
        this.warnings = warnings;
        return this;
    }

    @JsonProperty("html_links")
    public List<kbasereport.File> getHtmlLinks() {
        return htmlLinks;
    }

    @JsonProperty("html_links")
    public void setHtmlLinks(List<kbasereport.File> htmlLinks) {
        this.htmlLinks = htmlLinks;
    }

    public CreateExtendedReportParams withHtmlLinks(List<kbasereport.File> htmlLinks) {
        this.htmlLinks = htmlLinks;
        return this;
    }

    @JsonProperty("direct_html")
    public java.lang.String getDirectHtml() {
        return directHtml;
    }

    @JsonProperty("direct_html")
    public void setDirectHtml(java.lang.String directHtml) {
        this.directHtml = directHtml;
    }

    public CreateExtendedReportParams withDirectHtml(java.lang.String directHtml) {
        this.directHtml = directHtml;
        return this;
    }

    @JsonProperty("direct_html_link_index")
    public Long getDirectHtmlLinkIndex() {
        return directHtmlLinkIndex;
    }

    @JsonProperty("direct_html_link_index")
    public void setDirectHtmlLinkIndex(Long directHtmlLinkIndex) {
        this.directHtmlLinkIndex = directHtmlLinkIndex;
    }

    public CreateExtendedReportParams withDirectHtmlLinkIndex(Long directHtmlLinkIndex) {
        this.directHtmlLinkIndex = directHtmlLinkIndex;
        return this;
    }

    @JsonProperty("file_links")
    public List<kbasereport.File> getFileLinks() {
        return fileLinks;
    }

    @JsonProperty("file_links")
    public void setFileLinks(List<kbasereport.File> fileLinks) {
        this.fileLinks = fileLinks;
    }

    public CreateExtendedReportParams withFileLinks(List<kbasereport.File> fileLinks) {
        this.fileLinks = fileLinks;
        return this;
    }

    @JsonProperty("report_object_name")
    public java.lang.String getReportObjectName() {
        return reportObjectName;
    }

    @JsonProperty("report_object_name")
    public void setReportObjectName(java.lang.String reportObjectName) {
        this.reportObjectName = reportObjectName;
    }

    public CreateExtendedReportParams withReportObjectName(java.lang.String reportObjectName) {
        this.reportObjectName = reportObjectName;
        return this;
    }

    @JsonProperty("html_window_height")
    public Double getHtmlWindowHeight() {
        return htmlWindowHeight;
    }

    @JsonProperty("html_window_height")
    public void setHtmlWindowHeight(Double htmlWindowHeight) {
        this.htmlWindowHeight = htmlWindowHeight;
    }

    public CreateExtendedReportParams withHtmlWindowHeight(Double htmlWindowHeight) {
        this.htmlWindowHeight = htmlWindowHeight;
        return this;
    }

    @JsonProperty("summary_window_height")
    public Double getSummaryWindowHeight() {
        return summaryWindowHeight;
    }

    @JsonProperty("summary_window_height")
    public void setSummaryWindowHeight(Double summaryWindowHeight) {
        this.summaryWindowHeight = summaryWindowHeight;
    }

    public CreateExtendedReportParams withSummaryWindowHeight(Double summaryWindowHeight) {
        this.summaryWindowHeight = summaryWindowHeight;
        return this;
    }

    @JsonProperty("workspace_name")
    public java.lang.String getWorkspaceName() {
        return workspaceName;
    }

    @JsonProperty("workspace_name")
    public void setWorkspaceName(java.lang.String workspaceName) {
        this.workspaceName = workspaceName;
    }

    public CreateExtendedReportParams withWorkspaceName(java.lang.String workspaceName) {
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

    public CreateExtendedReportParams withWorkspaceId(Long workspaceId) {
        this.workspaceId = workspaceId;
        return this;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperties(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public java.lang.String toString() {
        return ((((((((((((((((((((((((((("CreateExtendedReportParams"+" [message=")+ message)+", objectsCreated=")+ objectsCreated)+", warnings=")+ warnings)+", htmlLinks=")+ htmlLinks)+", directHtml=")+ directHtml)+", directHtmlLinkIndex=")+ directHtmlLinkIndex)+", fileLinks=")+ fileLinks)+", reportObjectName=")+ reportObjectName)+", htmlWindowHeight=")+ htmlWindowHeight)+", summaryWindowHeight=")+ summaryWindowHeight)+", workspaceName=")+ workspaceName)+", workspaceId=")+ workspaceId)+", additionalProperties=")+ additionalProperties)+"]");
    }

}
