package ru.qveex.rst_tur.data.repository

import ru.qveex.rst_tur.data.remote.Api
import ru.qveex.rst_tur.domain.models.Data
import ru.qveex.rst_tur.domain.models.MainObject
import ru.qveex.rst_tur.domain.models.ResponseApi

class RemoteDataSource(
    private val api: Api
) {

    suspend fun getMainObjects(id: Int): ResponseApi<MainObject> = api.getMainObjects(id = id)

    suspend fun getObject(id: Int, type: String): ResponseApi<Data> =
        api.getObject(id = id, type = type)

}