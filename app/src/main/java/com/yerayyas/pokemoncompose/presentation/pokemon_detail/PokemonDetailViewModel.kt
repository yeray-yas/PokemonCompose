package com.yerayyas.pokemoncompose.presentation.pokemon_detail

import androidx.lifecycle.ViewModel
import com.yerayyas.pokemoncompose.data.remote.responses.Pokemon
import com.yerayyas.pokemoncompose.domain.repository.PokemonRepository
import com.yerayyas.pokemoncompose.presentation.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepository
):ViewModel() {

    suspend fun getPokemonInfo(pokemonName: String):Resource<Pokemon>
    = repository.getPokemonInfo(pokemonName)


}