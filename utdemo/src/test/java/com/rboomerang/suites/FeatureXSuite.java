package com.rboomerang.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.rboomerang.TestUtLifecycle;
import com.rboomerang.fitnesstracker.StepsGoalTrackerTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({StepsGoalTrackerTest.class,TestUtLifecycle.class})
public class FeatureXSuite {

}
