package ru.qveex.rst_tur.domain.interactors

import ru.qveex.rst_tur.data.repository.Repository

class HomeInteractor(
    private val repository: Repository
) {
    suspend operator fun invoke(id: Int) = repository.getMainObjects(id = id)
}