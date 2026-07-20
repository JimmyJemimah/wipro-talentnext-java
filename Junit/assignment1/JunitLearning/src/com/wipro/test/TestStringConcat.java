package com.wipro.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.wipro.task.DailyTasks;

public class TestStringConcat {

    @Test
    public void testDoStringConcat() {
        DailyTasks tasks = new DailyTasks();
        String result = tasks.doStringConcat("Wipro", "TalentNext");
        assertEquals("Wipro TalentNext", result);
    }
}