package com.example.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.core.data.source.local.entity.detailpokemonmoves.PokemonDetailMovesEntity
import com.example.core.data.source.local.entity.detailpokemontypes.PokemonDetailTypesEntity
import com.example.core.data.source.local.entity.pokemonlist.PokemonListEntity
import com.example.core.data.source.local.room.dao.PokemonDetailMovesDao
import com.example.core.data.source.local.room.dao.PokemonDetailTypesDao
import com.example.core.data.source.local.room.dao.PokemonListDao

@Database(
    entities = [
        PokemonListEntity::class,
        PokemonDetailMovesEntity::class,
        PokemonDetailTypesEntity::class,
    ],
    version = 1,
    exportSchema = false
)
abstract class PokemonDatabase : RoomDatabase() {

    abstract fun pokemonListDao(): PokemonListDao

    abstract fun pokemonDetailMovesDao(): PokemonDetailMovesDao

    abstract fun pokemonDetailTypesDao(): PokemonDetailTypesDao

}