package com.mona.batmansearch.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mona.batmansearch.data.db.dao.MovieDao
import com.mona.batmansearch.data.db.model.Movie


@Database(entities = [Movie::class], version = 1)
abstract class MovieDb: RoomDatabase(){

    abstract fun movieDao() : MovieDao
}

