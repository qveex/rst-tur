package ru.qveex.rst_tur.domain.interactors

import ru.qveex.rst_tur.data.repository.Repository

class HomeInteractor(
    private val repository: Repository
) {
    suspend fun getMainObjects(id: Int) = repository.getMainObjects(id = id)

    suspend fun getFuns(id: Int, type: String) = repository.getFuns(id = id, type = type)

    suspend fun getRooms(id: Int) = repository.getRooms(id = id)

    suspend fun getTours(id: Int) = repository.getTours(id = id)

    suspend fun getBlogs(id: Int, format: String) = repository.getBlogs(id = id, format = format)
}