package ru.qveex.rst_tur.data.repository

import ru.qveex.rst_tur.data.remote.Api
import ru.qveex.rst_tur.domain.models.*

class RemoteDataSource(
    private val api: Api
) {

    suspend fun getMainObjects(id: Int): ResponseApi<MainObject> =
        api.getMainObjects(id = id)

    suspend fun getFuns(id: Int, type: String): ResponseApi<List<Fun>> =
        api.getFuns(id = id, type = type)

    suspend fun getRooms(id: Int): ResponseApi<List<Room>> =
        api.getRooms(id = id)

    suspend fun getTours(id: Int): ResponseApi<List<Tour>> =
        api.getTours(id = id)

    suspend fun getBlogs(id: Int, format: String): ResponseApi<List<Blog>> =
        api.getBlogs(id = id, format = format)
}