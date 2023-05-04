package com.example.myapplication

import com.example.core.domain.usecase.pokemondetailmoves.PokemonDetailMovesInteractor
import com.example.core.domain.usecase.pokemondetailmoves.PokemonDetailMovesUsecase
import com.example.core.domain.usecase.pokemondetailtypes.PokemonDetailTypesInteractor
import com.example.core.domain.usecase.pokemondetailtypes.PokemonDetailTypesUsecase
import com.example.core.domain.usecase.pokemonlist.PokemonListInteractor
import com.example.core.domain.usecase.pokemonlist.PokemonListUsecase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class AppModule {

    @Binds
    abstract fun providePokemonListUsecase(pokemonListInteractor: PokemonListInteractor) : PokemonListUsecase

    @Binds
    abstract fun providePokemonDetailMovesUsecase(pokemonDetailMovesInteractor: PokemonDetailMovesInteractor) : PokemonDetailMovesUsecase

    @Binds
    abstract fun providePokemonDetailTypesUsecase(pokemonDetailTypesInteractor: PokemonDetailTypesInteractor) : PokemonDetailTypesUsecase


}