package za.ac.cput.domain;

public class Branch {
    private final String branchId;
    private final String branchName;
    private final String location;

    // Private constructor
    private Branch(builder builder) {
        this.branchId = builder.branchId;
        this.branchName = builder.branchName;
        this.location = builder.location;
    }

    // Getters
    public String getBranchId() {
        return branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public String getLocation() {
        return location;
    }

    // Static builder method
    public static builder builder() {
        return new builder();
    }

    // Builder class
    public static class builder {
        private String branchId;
        private String branchName;
        private String location;

        public builder branchId(String branchId) {
            this.branchId = branchId;
            return this;
        }

        public builder branchName(String branchName) {
            this.branchName = branchName;
            return this;
        }

        public builder location(String location) {
            this.location = location;
            return this;
        }

        public builder copy(Branch branch) {
            this.branchId = branch.branchId;
            this.branchName = branch.branchName;
            this.location = branch.location;
            return this;
        }

        public Branch build() {
            if (branchId == null || branchId.isEmpty()) {
                throw new IllegalStateException("Branch ID cannot be null");
            }
            return new Branch(this);
        }
    }
}
