package com.example.core.domain.usecase.pokemonlist

import com.example.core.data.Resource
import com.example.core.domain.model.PokemonList
import kotlinx.coroutines.flow.Flow

interface PokemonListUsecase {

    fun getPokemonList(): Flow<Resource<List<PokemonList>>>

    fun getSearchPokemonList(search: String): Flow<List<PokemonList>>
}