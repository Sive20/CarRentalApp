package za.ac.cput.factory;

import za.ac.cput.domain.Branch;

public class BranchFactory {
    public static Branch createBranch(String branchId, String name, String location) {
        return Branch.builder()
                .branchId(branchId)
                .branchName(name)
                .location(location)
                .build();
    }

}
