package com.example.core.domain.usecase.pokemondetailmoves

import com.example.core.data.Resource
import com.example.core.domain.model.PokemonDetailMoves
import kotlinx.coroutines.flow.Flow

interface PokemonDetailMovesUsecase {
    fun getPokemonDetailMoves(name: String): Flow<Resource<List<PokemonDetailMoves>>>
}