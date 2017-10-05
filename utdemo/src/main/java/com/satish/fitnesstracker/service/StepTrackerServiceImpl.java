package com.rboomerang.fitnesstracker.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.rboomerang.fitnesstracker.GoalAchivedListner;
import com.rboomerang.fitnesstracker.StepsGoalTracker;
import com.rboomerang.fitnesstracker.dao.StepTrackerDao;

public class StepTrackerServiceImpl implements StepTrackerService{
	
	private List<GoalAchivedListner> listeners = new CopyOnWriteArrayList<>();
	
	private StepTrackerDao stepTrackerDao;
	
	
	public StepTrackerServiceImpl(StepTrackerDao dao){
		stepTrackerDao = dao;
	}

	@Override
	public void setGoal(String userId, int goalSteps) {
		
		stepTrackerDao.createStepTracker(userId, goalSteps);
		
	}
	
	@Override
	public StepsGoalTracker getTracker(String userId){
		return  stepTrackerDao.getGoalTracker(userId);
	}

	@Override
	public void addSteps(String userId, int steps) {
		
		StepsGoalTracker tracker = stepTrackerDao.getGoalTracker(userId);
		tracker.addSteps(steps);
		stepTrackerDao.saveGoalTracker(userId, tracker);
		if(tracker.isGoalAchived()){
			notifyGoalAchived(userId,tracker);
		}
		
	}

	private void notifyGoalAchived(String userId,StepsGoalTracker tracker ) {
		for(GoalAchivedListner listener : listeners){
			listener.goalMet(userId, tracker);
		}
		
	}

	@Override
	public void removeSteps(String userId, int steps) {
		StepsGoalTracker tracker = stepTrackerDao.getGoalTracker(userId);
		tracker.removeSteps(steps);
		stepTrackerDao.saveGoalTracker(userId, tracker);
		
	}

	@Override
	public boolean isGoalMet(String userId) {
		StepsGoalTracker tracker = stepTrackerDao.getGoalTracker(userId);
		return tracker.isGoalAchived();
	}

	@Override
	public void addGoalAchivedListener(GoalAchivedListner listener) {
		
		listeners.add(listener);
	}

}
