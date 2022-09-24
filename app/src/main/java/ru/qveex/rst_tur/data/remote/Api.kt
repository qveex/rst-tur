package ru.qveex.rst_tur.data.remote

import retrofit2.http.GET
import retrofit2.http.Query
import ru.qveex.rst_tur.domain.models.Data
import ru.qveex.rst_tur.domain.models.MainObject
import ru.qveex.rst_tur.domain.models.ResponseApi

interface Api {

    @GET("api/base-app/fun")
    suspend fun getObject(
        @Query("id") id: Int,
        @Query("type") type: String
    ): ResponseApi<Data>

    @GET("api/base-app/main")
    suspend fun getMainObjects(@Query("id") id: Int): ResponseApi<MainObject>
}