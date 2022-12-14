package ru.qveex.rst_tur.data.remote

import retrofit2.http.GET
import retrofit2.http.Query
import ru.qveex.rst_tur.domain.models.*

interface Api {

    @GET("api/base-app/fun")
    suspend fun getFuns(
        @Query("id") id: Int,
        @Query("type") type: String
    ): ResponseApi<List<Fun>>

    @GET("api/base-app/rooms")
    suspend fun getRooms(
        @Query("id") id: Int,
    ): ResponseApi<List<Room>>

    @GET("api/base-app/tours")
    suspend fun getTours(
        @Query("id") id: Int,
    ): ResponseApi<List<Tour>>

    @GET("api/base-app/blog")
    suspend fun getBlogs(
        @Query("id") id: Int,
        @Query("format") format: String,
    ): ResponseApi<List<Blog>>

    @GET("api/base-app/blog-info")
    suspend fun getBlog(
        @Query("id") id: Int,
        @Query("blog_id") blogId: Int,
    ): ResponseApi<BlogInfo>

    @GET("api/base-app/main")
    suspend fun getMainObjects(@Query("id") id: Int): ResponseApi<MainObject>
}