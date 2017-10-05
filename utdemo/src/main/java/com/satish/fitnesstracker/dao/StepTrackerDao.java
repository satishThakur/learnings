package com.rboomerang.fitnesstracker.dao;

import com.rboomerang.fitnesstracker.StepsGoalTracker;

public interface StepTrackerDao {

	StepsGoalTracker createStepTracker(String userId, int goalSteps);
	
	StepsGoalTracker getGoalTracker(String userId);
	
	void saveGoalTracker(String userId, StepsGoalTracker tracker);
}
