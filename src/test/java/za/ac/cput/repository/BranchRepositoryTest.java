package za.ac.cput.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Branch;
import za.ac.cput.factory.BranchFactory;
import za.ac.cput.repository.BranchRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BranchRepositoryTest {

    private BranchRepository repository;
    private Branch branch;

    @BeforeEach
    void setUp() {
        repository = new BranchRepository();
        branch = BranchFactory.createBranch("24D89", "Riebeek Branch", "Cape Town");
        repository.save(branch);
    }

    @Test
    void saveBranch() {
        Branch newBranch = BranchFactory.createBranch("24D89", "Riebeek Branch", "Cape Town");
        repository.save(newBranch);
        assertEquals(2, repository.getAll().size());
    }

    @Test
    void findBranchById() {
        Branch found = repository.findById("24D89");
        assertNotNull(found);
        assertEquals("24D89", found.getBranchId());
    }

    @Test
    void getAllBranches() {
        List<Branch> allBranches = repository.getAll();
        assertEquals(1, allBranches.size());
    }

    @Test
    void deleteBranch() {
        repository.delete("24D89");
        assertNull(repository.findById("24D89"));
        assertEquals(0, repository.getAll().size());
    }
}