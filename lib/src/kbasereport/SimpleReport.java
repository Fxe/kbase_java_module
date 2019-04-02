
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
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("com.googlecode.jsonschema2pojo")
@JsonPropertyOrder({
    "text_message",
    "direct_html",
    "warnings",
    "objects_created"
})
public class SimpleReport {

    @JsonProperty("text_message")
    private java.lang.String textMessage;
    @JsonProperty("direct_html")
    private java.lang.String directHtml;
    @JsonProperty("warnings")
    private List<String> warnings;
    @JsonProperty("objects_created")
    private List<WorkspaceObject> objectsCreated;
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();

    @JsonProperty("text_message")
    public java.lang.String getTextMessage() {
        return textMessage;
    }

    @JsonProperty("text_message")
    public void setTextMessage(java.lang.String textMessage) {
        this.textMessage = textMessage;
    }

    public SimpleReport withTextMessage(java.lang.String textMessage) {
        this.textMessage = textMessage;
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

    public SimpleReport withDirectHtml(java.lang.String directHtml) {
        this.directHtml = directHtml;
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

    public SimpleReport withWarnings(List<String> warnings) {
        this.warnings = warnings;
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

    public SimpleReport withObjectsCreated(List<WorkspaceObject> objectsCreated) {
        this.objectsCreated = objectsCreated;
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
        return ((((((((((("SimpleReport"+" [textMessage=")+ textMessage)+", directHtml=")+ directHtml)+", warnings=")+ warnings)+", objectsCreated=")+ objectsCreated)+", additionalProperties=")+ additionalProperties)+"]");
    }

}
