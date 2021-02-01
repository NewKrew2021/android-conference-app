package com.survivalcoding.ifkakao

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.survivalcoding.ifkakao.database.AppDatabase
import com.survivalcoding.ifkakao.livedata.LiveDataTestUtil
import com.survivalcoding.ifkakao.livedata.observeOnce
import com.survivalcoding.ifkakao.model.like.Like
import com.survivalcoding.ifkakao.model.like.LikeDao
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException
import kotlin.jvm.Throws

@RunWith(AndroidJUnit4::class)
class RoomDatabaseTest {

    private lateinit var likeDao: LikeDao
    private lateinit var database: AppDatabase

    /**
     * InstantTaskExecutorRule()
     * 모든 Architecture Components-related background 작업을
     * 동일한 Thread에서 돌게하여 동기적인 처리가 가능하도록 해준다.
     */
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun createDatabaseAndSetData() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        database =
            Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        likeDao = database.likeDao()
    }

    @After
    @Throws(IOException::class)
    fun finishTest() {
        database.close()
    }

    @Test
    @Throws(Exception::class)
    fun tesLikeSizeFromDb() = runBlocking {

        likeDao.insert(Like(0, true))
        likeDao.insert(Like(1, true))
        likeDao.insert(Like(2, false))
        likeDao.insert(Like(3, true))

        assertEquals(4, likeDao.getAllLikeStates().size)

        /**
         * way 1
         */
        assertEquals(true, LiveDataTestUtil.getValue(likeDao.getLikeStateByIdx(0)))

//        assertEquals(true, likeDao.getLikeStateByIdx(0)) // error

        /**
         * way 2
         */
        likeDao.getLikeStateByIdx(1).observeOnce {
            assertEquals(true, it)
        }
    }
}

