package com.rboomerang.fitnesstracker;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import com.satish.fitnesstracker.StepsGoalTracker;

@RunWith(Theories.class)
public class StepsTrackerObjectCreationTest {

	@DataPoints
	public static int[] getGoalVaules(){
		return new int[]{100,450, 1000, -100, -1, 0};
	}
	
	@Rule
	public ExpectedException invalidGoalException = ExpectedException.none();
	
	@Theory
	public void testExceptionOnInvalidGoals(int goal){
		org.junit.Assume.assumeThat(goal, lessThanOrEqualTo(0));
		invalidGoalException.expect(IllegalArgumentException.class);
		invalidGoalException.expectMessage(containsString("Goal should be positive"));
		new StepsGoalTracker(goal);
	}
	
	@Theory
	public void testValidGoals(int goal){
		org.junit.Assume.assumeThat(goal, greaterThan(0));
		StepsGoalTracker tracker = new StepsGoalTracker(goal);
		assertThat(tracker.isGoalAchived(), is(false));
	}
}
