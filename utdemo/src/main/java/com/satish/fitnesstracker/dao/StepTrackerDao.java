package com.satish.fitnesstracker.dao;

import com.satish.fitnesstracker.StepsGoalTracker;

public interface StepTrackerDao {

	StepsGoalTracker createStepTracker(String userId, int goalSteps);
	
	StepsGoalTracker getGoalTracker(String userId);
	
	void saveGoalTracker(String userId, StepsGoalTracker tracker);
}
