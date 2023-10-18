package com.rafiul.cinevibes.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.rafiul.cinevibes.api.APIHandler
import com.rafiul.cinevibes.api.MovieServices
import com.rafiul.cinevibes.paging.DiscoverMoviePagingSource
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val movieServices: MovieServices,
    private val apiHandler: APIHandler
) {
    fun discoverMovieRepo() = Pager(
        config = PagingConfig(pageSize = 20, maxSize = 100),
        pagingSourceFactory = { DiscoverMoviePagingSource(movieServices, apiHandler) }
    ).liveData
}