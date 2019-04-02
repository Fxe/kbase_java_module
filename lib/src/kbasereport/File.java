
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
 * <p>Original spec-file type: File</p>
 * <pre>
 * * A file to be linked in the report. Pass in *either* a shock_id or a
 * * path. If a path to a file is given, then the file will be uploaded. If a
 * * path to a directory is given, then it will be zipped and uploaded.
 * * Required arguments:
 * *     string path - Can be a file or directory path. Required if shock_id is absent
 * *     string shock_id - Shock node ID. Required if path is absent
 * *     string name - Plain-text filename (eg. "results.zip") -- shown to the user
 * * Optional arguments:
 * *     string label - A short description for the file (eg. "Filter results")
 * *     string description - A more detailed, human-readable description of the file
 * </pre>
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("com.googlecode.jsonschema2pojo")
@JsonPropertyOrder({
    "path",
    "shock_id",
    "name",
    "label",
    "description"
})
public class File {

    @JsonProperty("path")
    private String path;
    @JsonProperty("shock_id")
    private String shockId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("label")
    private String label;
    @JsonProperty("description")
    private String description;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    public File withPath(String path) {
        this.path = path;
        return this;
    }

    @JsonProperty("shock_id")
    public String getShockId() {
        return shockId;
    }

    @JsonProperty("shock_id")
    public void setShockId(String shockId) {
        this.shockId = shockId;
    }

    public File withShockId(String shockId) {
        this.shockId = shockId;
        return this;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public File withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("label")
    public String getLabel() {
        return label;
    }

    @JsonProperty("label")
    public void setLabel(String label) {
        this.label = label;
    }

    public File withLabel(String label) {
        this.label = label;
        return this;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    public File withDescription(String description) {
        this.description = description;
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
        return ((((((((((((("File"+" [path=")+ path)+", shockId=")+ shockId)+", name=")+ name)+", label=")+ label)+", description=")+ description)+", additionalProperties=")+ additionalProperties)+"]");
    }

}
