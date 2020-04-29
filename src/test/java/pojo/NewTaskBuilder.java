package pojo;

public final class NewTaskBuilder {
    private final String content;

    private final Integer projectId;
    private final Integer sectionId;
    private final Integer parent;
    private final Integer order;
    private final Integer[] labelsIds;
    private final Integer priority;
    private final String dueString;
    private final String dueDate;
    private final String dueDateTime;
    private final String dueLang;

    public static class Builder{
        private final String content;

        private Integer projectId;
        private Integer sectionId;
        private Integer parent;
        private Integer order;
        private Integer[] labelsIds;
        private Integer priority;
        private String dueString;
        private String dueDate;
        private String dueDateTime;
        private String dueLang;

        public Builder(String content){
            this.content = content;
        }

        public Builder projectId(Integer val) {
            projectId = val;
            return this;
        }

        public Builder sectionId(Integer val) {
            sectionId = val;
            return this;
        }

        public Builder parent(Integer val) {
            parent = val;
            return this;
        }

        public Builder order(Integer val) {
            order = val;
            return this;
        }

        public Builder labelsIds(Integer[] val) {
            labelsIds = val;
            return this;
        }

        public Builder priority(Integer val) {
            priority = val;
            return this;
        }

        public Builder dueString(String val) {
            dueString = val;
            return this;
        }

        public Builder dueDate(String val) {
            dueDate = val;
            return this;
        }

        public Builder dueDateTime(String val) {
            dueDateTime = val;
            return this;
        }

        public Builder dueLang(String val) {
            dueLang = val;
            return this;
        }

        public NewTaskBuilder build() {
            return new NewTaskBuilder(this);
        }
    }

    private NewTaskBuilder(Builder builder) {
        content = builder.content;
        projectId = builder.projectId;
        sectionId = builder.sectionId;
        parent = builder.parent;
        order = builder.order;
        labelsIds = builder.labelsIds;
        priority = builder.priority;
        dueString = builder.dueString;
        dueDate = builder.dueDate;
        dueDateTime = builder.dueDateTime;
        dueLang = builder.dueLang;
    }

}
