package org.traineProject.utils.listeners;

import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestPlan;
import org.traineProject.utils.config.ConfigReader;


public class CustomTestExecutionListener implements TestExecutionListener {

    @Override
    public void testPlanExecutionStarted(TestPlan testPlan) {
        ConfigReader.readProperties();
    }
}