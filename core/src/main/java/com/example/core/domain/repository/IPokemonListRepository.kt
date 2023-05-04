package com.example.core.domain.repository

import com.example.core.data.Resource
import com.example.core.domain.model.PokemonList
import kotlinx.coroutines.flow.Flow

interface IPokemonListRepository {
    fun getPokemonList() : Flow<Resource<List<PokemonList>>>

    fun getSearchPokemonList(search: String): Flow<List<PokemonList>>
}