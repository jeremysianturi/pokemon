package com.example.myapplication.ui.pokemonlist

import android.app.Application
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.core.domain.usecase.pokemonlist.PokemonListUsecase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject

@ExperimentalCoroutinesApi
class PokemonListViewModel @ViewModelInject constructor(
    val pokemonListUsecase: PokemonListUsecase,
) : ViewModel() {
    val searchQuery = MutableStateFlow("")

    private val pokemonListFlow = searchQuery.flatMapLatest {
        pokemonListUsecase.getSearchPokemonList(it)
    }

    val search = pokemonListFlow.asLiveData()

    fun getPokemonList() = pokemonListUsecase.getPokemonList().asLiveData()
}

//@ExperimentalCoroutinesApi
//class PokemonListViewModel @ViewModelInject constructor(
//    val pokemonListUsecase: PokemonListUsecase,
//    @Assisted private val savedStateHandle: SavedStateHandle
//) : ViewModel() {
//    val searchQuery = MutableStateFlow("")
//
//    private val pokemonListFlow = searchQuery.flatMapLatest {
//        pokemonListUsecase.getSearchPokemonList(it)
//    }
//
//    val search = pokemonListFlow.asLiveData()
//
//    fun getPokemonList() = pokemonListUsecase.getPokemonList().asLiveData()
//}


