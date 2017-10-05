package com.satish.fitnesstracker;

import java.util.Objects;

/**
 * Goal represents number of steps as target
 * @author satish
 *
 */
public class StepsGoalTracker {
	
	private int goal;
	
	private int totalSteps;

	public StepsGoalTracker(int goal){
		if(goal <= 0){
			throw new IllegalArgumentException("Goal should be positive");
		}
		this.goal = goal;
	}
	
	public void addSteps(int steps){
		if(steps < 0)
			throw new IllegalArgumentException("Addsteps negitive steps not allowed");
		totalSteps += steps;
	}
	
	public void removeSteps(int steps){
		if(steps < 0)
			throw new IllegalArgumentException("removeSteps negitive steps not allowed");
		totalSteps -= steps;
		if(totalSteps < 0){
			totalSteps = 0;
		}
	}
	
	public boolean isGoalAchived(){
		return totalSteps >= goal;
	}
	
	public int getTotalSteps(){
		return totalSteps;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(goal, totalSteps);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StepsGoalTracker other = (StepsGoalTracker) obj;
		return goal == other.goal &&
				totalSteps == other.totalSteps;
	}

}
