package com.stayunexposed.startup.viewmodel

import org.junit.Assert.assertEquals
import org.junit.Test

class CounterViewModelTest {

    @Test
    fun `initial count is zero`() {
        val viewModel = CounterViewModel()

        assertEquals(0, viewModel.count.value)
    }

    @Test
    fun `increment adds one per call`() {
        val viewModel = CounterViewModel()

        viewModel.increment()
        viewModel.increment()

        assertEquals(2, viewModel.count.value)
    }

    @Test
    fun `reset returns count to zero`() {
        val viewModel = CounterViewModel()
        viewModel.increment()

        viewModel.reset()

        assertEquals(0, viewModel.count.value)
    }
}
