package com.jayden.ifkakaoclone.data

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.jayden.ifkakaoclone.data.db.Favorite
import com.jayden.ifkakaoclone.data.db.FavoriteRoomDatabase
import com.jayden.ifkakaoclone.getOrAwaitValue
import kotlinx.coroutines.runBlocking
import org.junit.*

class SessionRepositoryAndroidTest {

    private lateinit var localDataSource: FavoriteRoomDatabase

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        localDataSource =
            Room.inMemoryDatabaseBuilder(context, FavoriteRoomDatabase::class.java).build()
    }

    @After
    fun tearDown() {
        localDataSource.close()
    }

    @Test
    fun getFavorites() = runBlocking {
        with(localDataSource.favoriteDao()) {
            insert(Favorite(1, true))
            insert(Favorite(2, false))
            insert(Favorite(3, true))
            insert(Favorite(4, false))

            val favorites = getFavorites().getOrAwaitValue()

            Assert.assertEquals(4, favorites.size)
            Assert.assertEquals(Favorite(1, true), favorites[0])
            Assert.assertEquals(Favorite(2, false), favorites[1])
            Assert.assertEquals(Favorite(3, true), favorites[2])
            Assert.assertEquals(Favorite(4, false), favorites[3])
        }
    }

    @Test
    fun insertAndUpdate() = runBlocking {
        with(localDataSource.favoriteDao()) {
            insert(Favorite(10, true))
            insert(Favorite(11, false))

            Assert.assertEquals(Favorite(10, true), getFavorites().getOrAwaitValue()[0])
            Assert.assertEquals(Favorite(11, false), getFavorites().getOrAwaitValue()[1])

            insert(Favorite(10, false))
            insert(Favorite(11, true))

            Assert.assertEquals(Favorite(10, false), getFavorites().getOrAwaitValue()[0])
            Assert.assertEquals(Favorite(11, true), getFavorites().getOrAwaitValue()[1])
        }
    }
}