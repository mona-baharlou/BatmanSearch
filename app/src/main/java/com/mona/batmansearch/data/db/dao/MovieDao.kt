package com.mona.batmansearch.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mona.batmansearch.data.db.model.Movie

@Dao
interface MovieDao {

    @Query("SELECT * FROM movies")
    fun getAllMovies(): List<Movie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movie: Movie)

    @Delete
    fun deleteMovie(movie: Movie)


}