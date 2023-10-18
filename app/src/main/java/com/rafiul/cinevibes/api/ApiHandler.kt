package com.rafiul.cinevibes.api


import retrofit2.Response


sealed interface APIHandler { suspend fun <T : Any> handleApi(execute: suspend () -> Response<T>): NetworkResult<T> }

