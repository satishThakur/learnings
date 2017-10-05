package com.satish.fitnesstracker.service;

import com.satish.fitnesstracker.GoalAchivedListner;
import com.satish.fitnesstracker.StepsGoalTracker;

public interface StepTrackerService {
	
	public void setGoal(String userId, int goal);
	
	public void addSteps(String userId, int steps);
	
	public void removeSteps(String userId, int steps);
	
	public boolean isGoalMet(String userId);
	
	public void addGoalAchivedListener(GoalAchivedListner listener);

	public StepsGoalTracker getTracker(String userId);

}
