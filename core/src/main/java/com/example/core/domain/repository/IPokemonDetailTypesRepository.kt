package com.example.core.domain.repository

import com.example.core.data.Resource
import com.example.core.domain.model.PokemonDetailTypes
import kotlinx.coroutines.flow.Flow

interface IPokemonDetailTypesRepository {

    fun getPokemonDetailTypes(name: String) : Flow<Resource<List<PokemonDetailTypes>>>

    fun getSearchPokemonDetailTypes(search: String): Flow<List<PokemonDetailTypes>>
}