package com.example.core.domain.usecase.pokemondetailtypes

import com.example.core.data.Resource
import com.example.core.domain.model.PokemonDetailTypes
import kotlinx.coroutines.flow.Flow

interface PokemonDetailTypesUsecase {
    fun getPokemonDetailTypes(name: String): Flow<Resource<List<PokemonDetailTypes>>>
}