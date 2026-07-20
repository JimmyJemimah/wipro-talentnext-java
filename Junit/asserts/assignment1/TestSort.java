package asserts.assignment1;

public class TestSort {
    
}
package assignment1;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class TestSort {

    @Test
    public void testSortValues() {
        DailyTasks tasks = new DailyTasks();
        
        int[] input = {5, 2, 8, 1, 3};
        int[] expected = {1, 2, 3, 5, 8};
        
        // Testing arrays match using assertArrayEquals
        assertArrayEquals(expected, tasks.sortValues(input));
    }
}