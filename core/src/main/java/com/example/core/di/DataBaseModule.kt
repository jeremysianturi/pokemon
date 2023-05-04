package com.example.core.di

import android.content.Context
import androidx.room.Room
import com.example.core.data.source.local.room.PokemonDatabase
import com.example.core.data.source.local.room.dao.PokemonDetailMovesDao
import com.example.core.data.source.local.room.dao.PokemonDetailTypesDao
import com.example.core.data.source.local.room.dao.PokemonListDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
class DataBaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): PokemonDatabase = Room.databaseBuilder(
        context,
        PokemonDatabase::class.java, "POKEMON.db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun providePokemonListDao(database: PokemonDatabase) : PokemonListDao = database.pokemonListDao()

    @Provides
    fun providePokemonDetailMovesDao(database: PokemonDatabase) : PokemonDetailMovesDao = database.pokemonDetailMovesDao()

    @Provides
    fun providePokemonDetailTypesDao(database: PokemonDatabase) : PokemonDetailTypesDao = database.pokemonDetailTypesDao()

//    @Provides
//    fun provideSubmitDao(database : KmsDatabase) : SubmitDao = database.submit()

}