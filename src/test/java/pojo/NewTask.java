package pojo;

import com.google.gson.annotations.SerializedName;

public class NewTask {

    @SerializedName("content")
    private String content;

	public void setContent(String content) {
		this.content = content;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public void setLabelsIds(int[] labelsIds) {
		this.labelsIds = labelsIds;
	}

	public void setPriority(int priority) {
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
    private int projectId;

    @SerializedName("section_id")
    private int sectionId;

    @SerializedName("parent")
    private int parent;

    @SerializedName("order")
    private int order;

    @SerializedName("labels_ids")
    private int[] labelsIds;

    @SerializedName("priority")
    private int priority;

    @SerializedName("due_string")
    private String dueString;

    @SerializedName("due_date")
    private String dueDate;

    @SerializedName("due_DateTime")
    private String dueDateTime;

    @SerializedName("due_lang")
    private String dueLang;

}