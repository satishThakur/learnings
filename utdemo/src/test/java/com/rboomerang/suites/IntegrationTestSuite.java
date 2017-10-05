package com.rboomerang.suites;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import com.rboomerang.fitnesstracker.dao.StepsGoalTrackerDaoTest;

@RunWith(Categories.class)
@SuiteClasses({StepsGoalTrackerDaoTest.class})
public class IntegrationTestSuite {

}
