package assignment2;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class TestCheckPresence {

    @Test
    public void testCheckPresenceSuccess() {
        DailyTasks tasks = new DailyTasks();
        // Should return true since "Wipro" contains "pro"
        assertTrue(tasks.checkPresence("Wipro", "pro"));
    }

    @Test
    public void testCheckPresenceFailure() {
        DailyTasks tasks = new DailyTasks();
        // Should return false since "Wipro" does not contain "Java"
        assertFalse(tasks.checkPresence("Wipro", "Java"));
    }
}