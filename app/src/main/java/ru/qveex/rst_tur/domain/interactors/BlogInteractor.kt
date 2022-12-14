package ru.qveex.rst_tur.domain.interactors

import ru.qveex.rst_tur.data.repository.Repository

class BlogInteractor(
    private val repository: Repository
) {
    suspend operator fun invoke(id: Int, blogId: Int) = repository.getBlog(id = id, blogId = blogId)
}