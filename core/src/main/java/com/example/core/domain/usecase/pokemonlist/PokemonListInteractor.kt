package com.example.core.domain.usecase.pokemonlist

import com.example.core.data.Resource
import com.example.core.data.repository.PokemonListRepository
import com.example.core.domain.model.PokemonList
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PokemonListInteractor @Inject constructor(private val pokemonListRepository : PokemonListRepository) : PokemonListUsecase {

    override fun getPokemonList(): Flow<Resource<List<PokemonList>>> = pokemonListRepository.getPokemonList()

    override fun getSearchPokemonList(search: String): Flow<List<PokemonList>> = pokemonListRepository.getSearchPokemonList(search)


}