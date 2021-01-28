package com.survivalcoding.ifkakao

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.survivalcoding.ifkakao.second.model.favorite.database.AppDatabase
import com.survivalcoding.ifkakao.second.model.favorite.database.Favorite
import com.survivalcoding.ifkakao.second.model.favorite.database.FavoriteDao
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class RoomDatabaseTest {
    private lateinit var favoriteDao: FavoriteDao
    private lateinit var db: AppDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, AppDatabase::class.java
        ).build()
        favoriteDao = db.favoriteDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun writeAndReadList() = runBlocking {
        val data = listOf(
            Favorite(0, false),
            Favorite(1, true),
            Favorite(2, false),
            Favorite(1, false)
        )
        data.forEach { favoriteDao.insert(it) }
        val datas = favoriteDao.getAll()
        assertEquals(datas.size, 3)
        assertEquals(datas[0].isFavorite, false)
        assertEquals(datas[1].isFavorite, false)
        assertEquals(datas[2].isFavorite, false)
    }
}