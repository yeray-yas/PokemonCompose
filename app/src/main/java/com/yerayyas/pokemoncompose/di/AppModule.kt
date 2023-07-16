package com.yerayyas.pokemoncompose.di

import com.yerayyas.pokemoncompose.data.remote.PokeApi
import com.yerayyas.pokemoncompose.domain.repository.PokemonRepository
import com.yerayyas.pokemoncompose.presentation.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePokemonRepository(
        api:PokeApi
    ) = PokemonRepository(api)

    @Provides
    @Singleton
    fun providePokemonApi():PokeApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PokeApi::class.java)
    }
}