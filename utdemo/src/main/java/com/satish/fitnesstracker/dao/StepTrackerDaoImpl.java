package com.rboomerang.fitnesstracker.dao;

import java.util.HashMap;
import java.util.Map;

import com.rboomerang.fitnesstracker.StepsGoalTracker;

public class StepTrackerDaoImpl implements StepTrackerDao {
	
	private Map<String, StepsGoalTracker> inmemoryDb = new HashMap<>();

	@Override
	public StepsGoalTracker createStepTracker(String userId, int goalSteps) {
		StepsGoalTracker tracker = new StepsGoalTracker(goalSteps);
		inmemoryDb.put(userId, tracker);
		return tracker;
	}

	@Override
	public StepsGoalTracker getGoalTracker(String userId) {
		return inmemoryDb.get(userId);
	}

	@Override
	public void saveGoalTracker(String userId, StepsGoalTracker tracker) {
		inmemoryDb.put(userId, tracker);
	}

}
