package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Branch;

import static org.junit.jupiter.api.Assertions.*;

class BranchFactoryTest {
    @Test
    void createBranch() {
        Branch branch = BranchFactory.createBranch("24D89", "Riebeek Branch", "Cape Town");

        assertNotNull(branch);
        assertEquals("24D89", branch.getBranchId());
        assertEquals("Riebeek Branch", branch.getBranchName());
        assertEquals("Cape Town", branch.getLocation());
    }

}