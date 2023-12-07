package com.mona.batmansearch.data.db.repository

import com.mona.batmansearch.data.db.dao.MovieDao
import com.mona.batmansearch.data.db.model.Movie
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val movieDao: MovieDao
) {

    fun getAllMovies(): List<Movie> {
        return movieDao.getAllMovies()
    }

    fun insertMovie(movie: Movie) {
        movieDao.insertMovie(movie = movie)
    }

    fun deleteMovie(movie: Movie) {
        movieDao.deleteMovie(movie)
    }
}