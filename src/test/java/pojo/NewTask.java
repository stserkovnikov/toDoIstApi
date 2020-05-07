package pojo;

import com.google.gson.annotations.SerializedName;

public class NewTask {

    @SerializedName("content")
    private String content;

    public void setContent(String content) {
        this.content = content;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public void setLabelsIds(Integer[] labelsIds) {
        this.labelsIds = labelsIds;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public void setDueString(String dueString) {
        this.dueString = dueString;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public void setDueDateTime(String dueDateTime) {
        this.dueDateTime = dueDateTime;
    }

    public void setDueLang(String dueLang) {
        this.dueLang = dueLang;
    }

    @SerializedName("project")
    private Integer projectId;

    @SerializedName("section_id")
    private Integer sectionId;

    @SerializedName("parent")
    private Integer parent;

    @SerializedName("order")
    private Integer order;

    @SerializedName("labels_ids")
    private Integer[] labelsIds;

    @SerializedName("priority")
    private Integer priority;

    @SerializedName("due_string")
    private String dueString;

    @SerializedName("due_date")
    private String dueDate;

    @SerializedName("due_DateTime")
    private String dueDateTime;

    @SerializedName("due_lang")
    private String dueLang;

}