package com.rafiul.cinevibes.api

import com.rafiul.cinevibes.data.models.ResponseMovies
import com.rafiul.cinevibes.utils.MOVIES_END_POINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieServices {

    @GET(MOVIES_END_POINT)
    suspend fun getAllMoviesFromApi(@Query("page") page: Int): Response<ResponseMovies>
}