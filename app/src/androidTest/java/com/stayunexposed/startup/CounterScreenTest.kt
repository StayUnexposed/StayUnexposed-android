package com.stayunexposed.startup

import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.stayunexposed.startup.ui.COUNT_TEXT_TAG
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CounterScreenTest {

    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun incrementButton_updatesCount() {
        composeRule.onNodeWithTag(COUNT_TEXT_TAG).assertTextEquals("Count: 0")

        composeRule.onNodeWithText("Increment").performClick()

        composeRule.onNodeWithTag(COUNT_TEXT_TAG).assertTextEquals("Count: 1")
    }

    @Test
    fun resetButton_returnsCountToZero() {
        composeRule.onNodeWithText("Increment").performClick()
        composeRule.onNodeWithText("Increment").performClick()

        composeRule.onNodeWithText("Reset").performClick()

        composeRule.onNodeWithTag(COUNT_TEXT_TAG).assertTextEquals("Count: 0")
    }
}
