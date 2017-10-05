package com.rboomerang.fitnesstracker.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.rboomerang.fitnesstracker.GoalAchivedListner;
import com.rboomerang.fitnesstracker.StepsGoalTracker;
import com.rboomerang.fitnesstracker.dao.StepTrackerDao;
import com.rboomerang.fitnesstracker.service.StepTrackerService;
import com.rboomerang.fitnesstracker.service.StepTrackerServiceImpl;

public class StepTrackerServiceTest {
	
	private StepTrackerService trackerService;
	
	private StepTrackerDao trackerDaoMock;
	
	@Before
	public void onSetup(){
		trackerDaoMock = mock(StepTrackerDao.class);
		trackerService = new StepTrackerServiceImpl(trackerDaoMock);
	}
	
	
	@Test
	public void testUserGoalIsCreated(){
		String userId = "abc";
		int goal = 1000;	
		trackerService.setGoal(userId, goal);
		verify(trackerDaoMock).createStepTracker(userId, goal);
	}
	
	@Test
	public void testNotificationOnceGoalIsCompleted(){
		
		GoalAchivedListner listenerMock = mock(GoalAchivedListner.class);
		trackerService.addGoalAchivedListener(listenerMock);		
		
		String userId = "abc";
		int goal = 1000;
		
		StepsGoalTracker tracker = new StepsGoalTracker(goal);	
		when(trackerDaoMock.getGoalTracker(userId)).thenReturn(tracker);
		
		trackerService.setGoal(userId, goal);
		verifyNoMoreInteractions(listenerMock);
		
		trackerService.addSteps(userId, 500);
		verifyNoMoreInteractions(listenerMock);
		
		trackerService.addSteps(userId, 500);
		verify(listenerMock).goalMet(userId, tracker);		
	}
	
	@Test
	public void testMultipleUserGoalsWorkFine(){
		
		int user1Goal = 1000, user2Goal = 3000;
		String userId1 = "user1", userId2 = "user2";
		
		StepsGoalTracker tracke1 = new StepsGoalTracker(user1Goal);
		StepsGoalTracker tracke2 = new StepsGoalTracker(user2Goal);
		
		when(trackerDaoMock.getGoalTracker(userId1)).thenReturn(tracke1);
		when(trackerDaoMock.getGoalTracker(userId2)).thenReturn(tracke2);
		
		
		trackerService.addSteps(userId1, 500);
		assertThat(trackerService.getTracker(userId1).getTotalSteps(), is(500));
		assertThat(trackerService.getTracker(userId2).getTotalSteps(), is(0));
		
	}
	

}
