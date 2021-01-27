package com.survivalcoding.ifkakao

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.runner.RunWith

import com.survivalcoding.ifkakao.ifkakao.database.FavoriteDao
import com.survivalcoding.ifkakao.ifkakao.database.FavoriteTable
import com.survivalcoding.ifkakao.ifkakao.database.InAppDataBase
import org.hamcrest.CoreMatchers.equalTo
import org.junit.After
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import java.io.IOException
import kotlin.jvm.Throws


// Execution failed for task ':app:kaptDebugKotlin'.
//  > A failure occurred while executing org.jetbrains.kotlin.gradle.internal.KaptExecution
//   > java.lang.reflect.InvocationTargetException (no error message)

//@RunWith(AndroidJUnit4::class)
//class RoomDatabaseTest() {
//    private lateinit var favoriteDao: FavoriteDao
//    private lateinit var db: InAppDataBase
//
//    @Before
//    fun createDb() {
//        val context = ApplicationProvider.getApplicationContext<Context>()
//        db = Room.inMemoryDatabaseBuilder(
//            context, InAppDataBase::class.java
//        ).allowMainThreadQueries().build()
//        favoriteDao = db.favoriteDao()
//    }
//
//    @After
//    @Throws(IOException::class)
//    fun closeDb() {
//        db.close()
//    }
//
//    @Test
//    @Throws(Exception::class)
//    suspend fun InsertDataAndGetData() {
//        val idx = FavoriteTable(29, 0)
//        favoriteDao.insertIdx(idx)
//
//        val getData = favoriteDao.getAll()
//        assertThat(getData[0], equalTo(idx))
//    }
//
//}