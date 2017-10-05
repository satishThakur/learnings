package com.rboomerang.fitnesstracker;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.satish.fitnesstracker.StepsGoalTracker;

@RunWith(Parameterized.class)
public class StepsTrackerPositvTotalTest {

	private static StepsGoalTracker tracker = new StepsGoalTracker(1000);

	@Parameters
	public static List<Object[]> getParameters(){		

		return Arrays.asList(new Object[][]{
				{1,1},
				{10,11},
				{50,61},
				{-100, 0}
		});

	}

	private int steps;
	private int total;

	public StepsTrackerPositvTotalTest(int steps, int total){
		this.steps = steps;
		this.total = total;
	}

	@Test
	public void testTotalSteps(){
		if(steps > 0)
			tracker.addSteps(steps);
		else
			tracker.removeSteps(-steps);
		int totalSteps = tracker.getTotalSteps();
		assertThat(totalSteps, is(total));
	}
}
