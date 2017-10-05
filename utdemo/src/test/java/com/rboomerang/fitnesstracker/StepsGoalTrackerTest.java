package com.rboomerang.fitnesstracker;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.satish.fitnesstracker.StepsGoalTracker;

public class StepsGoalTrackerTest {
	
	private StepsGoalTracker tracker;
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testNegativeGoalThrowsException(){
		tracker = new StepsGoalTracker(-10);
	}
	
	public void testNegativeGoalEx(){
		
		try{
			new StepsGoalTracker(-10);
			fail();
		}catch(Exception ex){

		}
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testZeroGoalThrowsException(){
		tracker = new StepsGoalTracker(0);
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testNegativeGoalThrowsExceptionNew(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage(containsString("Goal should be positive"));
		tracker = new StepsGoalTracker(-10);
	}

	
	
	
	@Test(expected=NullPointerException.class)
	public void testNullPointerExceptionWhenGoalIsNull(){
		Integer nullInt = null;
		tracker = new StepsGoalTracker(nullInt);
	}
	
	@Test
	public void testTracketStartsWithGoalNotMet(){
		tracker = new StepsGoalTracker(1);
		assertThat(tracker.isGoalAchived(), is(false));
	}
	
	@Test
	public void testTrackerGoalIsMetWhenEnoughStepsAreAdded(){
		tracker = new StepsGoalTracker(100);
		tracker.addSteps(40);
		tracker.addSteps(60);
		assertThat(tracker.isGoalAchived(), is(true));
		
	}
	
	
	@Test
	public void testTrackerGoalIsMetWhenStepsAreMoreThanGoal(){
		tracker = new StepsGoalTracker(300);
		tracker.addSteps(400);
		tracker.addSteps(60);
		assertThat(tracker.isGoalAchived(), is(true));
	}
	
	
	@Test
	public void testTrackerGoalIsNotMetWhenStepsAreRemoved(){
		tracker = new StepsGoalTracker(300);
		tracker.addSteps(400);
		tracker.addSteps(60);
		assertThat(tracker.isGoalAchived(), is(true));
		tracker.removeSteps(200);
		assertThat(tracker.isGoalAchived(), is(false));
	}
	
	@Test(timeout=10)
	@Ignore
	public void testBadTest(){
		tracker = new StepsGoalTracker(300000);
		for(int i = 0; i < 100000000; i++){
			tracker.addSteps(1);
		}
		assertThat(tracker.isGoalAchived(), is(true));
	}
	

}
