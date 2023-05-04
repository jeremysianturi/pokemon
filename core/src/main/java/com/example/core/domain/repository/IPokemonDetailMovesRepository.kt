package com.example.core.domain.repository

import com.example.core.data.Resource
import com.example.core.domain.model.PokemonDetailMoves
import kotlinx.coroutines.flow.Flow

interface IPokemonDetailMovesRepository {
    fun getPokemonDetailMoves(name: String) : Flow<Resource<List<PokemonDetailMoves>>>

    fun getSearchPokemonDetailMoves(search: String): Flow<List<PokemonDetailMoves>>
}