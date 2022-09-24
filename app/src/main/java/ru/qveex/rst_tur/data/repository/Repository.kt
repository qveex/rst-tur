package ru.qveex.rst_tur.data.repository

import javax.inject.Inject

class Repository @Inject constructor(
    private val remote: RemoteDataSource
) {

    suspend fun getMainObjects(id: Int) = remote.getMainObjects(id = id)


    suspend fun getObject(id: Int, type: String) = remote.getObject(id = id, type = type)
}