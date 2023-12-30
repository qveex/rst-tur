package ru.qveex.rst_tur.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.qveex.rst_tur.data.repository.Repository
import ru.qveex.rst_tur.domain.interactors.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideUseCases(repository: Repository) = Interactors(
            blogInteractor = BlogInteractor(repository),
            bookingInteractor = BookingInteractor(repository),
            chatsInteractor = ChatsInteractor(repository),
            homeInteractor = HomeInteractor(repository),
            profileInteractor = ProfileInteractor(repository),
            mapInteractor = MapInteractor(repository),
            splashInteractor = SplashInteractor(repository)
        )
}