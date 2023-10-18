package com.rafiul.cinevibes.paging

import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.rafiul.cinevibes.api.APIHandler
import com.rafiul.cinevibes.api.MovieServices
import com.rafiul.cinevibes.api.NetworkResult
import com.rafiul.cinevibes.data.models.ResponseMovies
import retrofit2.HttpException
import java.io.IOException

class DiscoverMoviePagingSource(
    private val movieServices: MovieServices,
    private val apiHandler: APIHandler
) : PagingSource<Int, ResponseMovies.Result>() {

    companion object {
        private const val STARTING_PAGE_INDEX = 1
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ResponseMovies.Result> {
        val position = params.key ?: STARTING_PAGE_INDEX

        return try {
            val response = getMovies(position)
            LoadResult.Page(
                data = response.results,
                prevKey = if (position == STARTING_PAGE_INDEX) null else position - 1,
                nextKey = if (position == response.totalPages) null else position + 1
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }

    private suspend fun getMovies(page: Int): ResponseMovies {
        return when (val response = apiHandler.handleApi { movieServices.getAllMoviesFromApi(page) }) {
            is NetworkResult.Success -> response.data
            is NetworkResult.Exception -> throw response.e
            is NetworkResult.Error -> throw IOException(response.errorMessage)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, ResponseMovies.Result>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val anchorPage = state.closestPageToPosition(anchorPosition)
        return anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
    }
}
