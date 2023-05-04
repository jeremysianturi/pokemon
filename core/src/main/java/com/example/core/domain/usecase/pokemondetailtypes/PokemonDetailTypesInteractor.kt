package com.example.core.domain.usecase.pokemondetailtypes

import com.example.core.data.Resource
import com.example.core.data.repository.PokemonDetailMovesRepository
import com.example.core.data.repository.PokemonDetailTypesRepository
import com.example.core.domain.model.PokemonDetailMoves
import com.example.core.domain.model.PokemonDetailTypes
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PokemonDetailTypesInteractor @Inject constructor(private val pokemonDetailTypesRepository: PokemonDetailTypesRepository) :
    PokemonDetailTypesUsecase {

    override fun getPokemonDetailTypes(name: String): Flow<Resource<List<PokemonDetailTypes>>> =
        pokemonDetailTypesRepository.getPokemonDetailTypes(name)

}