package com.example.myapplication.ui.pokemondetail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.core.domain.usecase.pokemondetailmoves.PokemonDetailMovesUsecase
import com.example.core.domain.usecase.pokemondetailtypes.PokemonDetailTypesUsecase
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class PokemonDetailViewModel @ViewModelInject constructor(
    private val pokemonDetailMovesUsecase: PokemonDetailMovesUsecase,
    private val pokemonDetailTypesUsecase: PokemonDetailTypesUsecase,
) : ViewModel() {

    // search by
//    val searchQuery = MutableStateFlow("")
//    private fun bannerFlow(apiKey: String, language: String, sortBy: String, includeAdult: Boolean, includeVideo: Boolean, page: String) = searchQuery.flatMapLatest { bannerUsecase.getSearchBusinesses(searchBy,it,sortBy) }
//    fun search(searchBy: String, sortBy: String) = businessesFlow(searchBy,sortBy).asLiveData()



    fun getPokemonDetailMoves(name: String) =
        pokemonDetailMovesUsecase.getPokemonDetailMoves(name).asLiveData()

    fun getPokemonDetailTypes(name: String) =
        pokemonDetailTypesUsecase.getPokemonDetailTypes(name).asLiveData()

}