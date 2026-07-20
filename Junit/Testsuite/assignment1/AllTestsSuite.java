package Testsuite; // Matches your folder name exactly

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

// Specifying that this class is a Test Suite runner
@RunWith(Suite.class)

// Bundling the test cases using their correct folder paths
@Suite.SuiteClasses({
    com.wipro.test.TestStringConcat.class,
    assignment1.TestSort.class,
    assignment2.TestCheckPresence.class
})

public class AllTestsSuite {
    // This class remains empty.
}