package ru.qveex.rst_tur.data.repository

import javax.inject.Inject

class Repository @Inject constructor(
    private val remote: RemoteDataSource
) {

    suspend fun getMainObjects(id: Int) = remote.getMainObjects(id = id)

    suspend fun getFuns(id: Int, type: String) = remote.getFuns(id = id, type = type)

    suspend fun getRooms(id: Int) = remote.getRooms(id = id)

    suspend fun getTours(id: Int) = remote.getTours(id = id)

    suspend fun getBlogs(id: Int, format: String) = remote.getBlogs(id = id, format = format)

    suspend fun getBlog(id: Int, blogId: Int) = remote.getBlog(id = id, blogId = blogId)
}