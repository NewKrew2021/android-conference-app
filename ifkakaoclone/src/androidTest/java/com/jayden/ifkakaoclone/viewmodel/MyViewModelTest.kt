package com.jayden.ifkakaoclone.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.*

class MyViewModelTest {

    // LiveData setValue()가 MainThread(UI Thread) 에서만 동작하게 하기 때문에
    // 그 값을 판단하는 isMainThread()를 true 로 fix 해버림

    // Test Thread = Thread[Instr: androidx.test.runner.AndroidJUnitRunner,5,main]
    // UI Thread = Thread[main,5,main]
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val viewModel = MyViewModel()

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun liveData2IsNull() {
        viewModel.setNewValue("foo")

        // MutableLiveData 이고 계산되야할 값 변환이 없으므로 liveData1의 value 를 읽을 수 있다.
        Assert.assertEquals("foo", viewModel.liveData1.value)

        // Transformation is not computed if it's not observed
        Assert.assertEquals(null, viewModel.liveData2.value)
    }

    @Test
    fun liveData2IsNotNull() {
        viewModel.setNewValue("foo")

        viewModel.liveData2.observeForever { }

        Assert.assertEquals("foo", viewModel.liveData1.value)

        Assert.assertEquals("FOO", viewModel.liveData2.value)
    }
}