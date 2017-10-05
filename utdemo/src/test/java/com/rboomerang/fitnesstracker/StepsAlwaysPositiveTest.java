package com.rboomerang.fitnesstracker;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import com.rboomerang.fitnesstracker.StepsGoalTracker;

@RunWith(Theories.class)
public class StepsAlwaysPositiveTest {
	
	private static StepsGoalTracker tracker = new StepsGoalTracker(100);

	@DataPoints	
	public static int[] getSteps(){
		return new int[]{1, 2, 3,-100,30, 50,-400};
	}
	
	@Theory
	public void testTotalIsNotNegative(int steps){
		if(steps > 0)
			tracker.addSteps(steps);
		else
			tracker.removeSteps(-steps);
		//assertTrue(tracker.getTotalSteps() >= 0);
		assertThat(tracker.getTotalSteps(), greaterThanOrEqualTo(0));
	}
	
}
