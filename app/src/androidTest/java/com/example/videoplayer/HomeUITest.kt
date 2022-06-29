package com.example.videoplayer

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class HomeUITest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun `Check if title is play movie`() {
        onView(withText("PlayMovie")).check(matches(isDisplayed()))
    }

    // Need to mock viewModel
    @Test
    fun `Check if Adventure label isDisplayed`(){
        onView(withText("Adventure")).check(matches(isDisplayed()))
    }
}