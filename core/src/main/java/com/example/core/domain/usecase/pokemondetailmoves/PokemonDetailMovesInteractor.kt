package com.example.core.domain.usecase.pokemondetailmoves

import com.example.core.data.Resource
import com.example.core.data.repository.PokemonDetailMovesRepository
import com.example.core.domain.model.PokemonDetailMoves
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PokemonDetailMovesInteractor @Inject constructor(private val pokemonDetailMovesRepository: PokemonDetailMovesRepository) :
    PokemonDetailMovesUsecase {

    override fun getPokemonDetailMoves(name: String): Flow<Resource<List<PokemonDetailMoves>>> =
        pokemonDetailMovesRepository.getPokemonDetailMoves(name)

}