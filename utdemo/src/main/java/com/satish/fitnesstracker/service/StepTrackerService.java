package com.rboomerang.fitnesstracker.service;

import com.rboomerang.fitnesstracker.GoalAchivedListner;
import com.rboomerang.fitnesstracker.StepsGoalTracker;

public interface StepTrackerService {
	
	public void setGoal(String userId, int goal);
	
	public void addSteps(String userId, int steps);
	
	public void removeSteps(String userId, int steps);
	
	public boolean isGoalMet(String userId);
	
	public void addGoalAchivedListener(GoalAchivedListner listener);

	public StepsGoalTracker getTracker(String userId);

}
