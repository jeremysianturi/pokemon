package com.example.core.data.source.local.room

import com.example.core.data.source.local.entity.detailpokemonmoves.PokemonDetailMovesEntity
import com.example.core.data.source.local.entity.detailpokemontypes.PokemonDetailTypesEntity
import com.example.core.data.source.local.entity.pokemonlist.PokemonListEntity
import com.example.core.data.source.local.room.dao.PokemonDetailMovesDao
import com.example.core.data.source.local.room.dao.PokemonDetailTypesDao
import com.example.core.data.source.local.room.dao.PokemonListDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(
    private val mPokemonListDao: PokemonListDao,
    private val mPokemonDetailMovesDao: PokemonDetailMovesDao,
    private val mPokemonDetailTypesDao: PokemonDetailTypesDao
)
{
    fun getPokemonList(): Flow<List<PokemonListEntity>> = mPokemonListDao.getPokemonList()
    suspend fun insertPokemonList(pokemonList : List<PokemonListEntity>) = mPokemonListDao.insertAndDeletePokemonList(pokemonList)

    suspend fun deletePokemonList() = mPokemonListDao.deletePokemonList()

    fun getSearchPokemonList(search: String): Flow<List<PokemonListEntity>> = mPokemonListDao.getSearchPokemonList(search)


    fun getPokemonDetailMoves(): Flow<List<PokemonDetailMovesEntity>> = mPokemonDetailMovesDao.getPokemonDetailMoves()
    suspend fun insertPokemonDetailMoves(pokemonDetailMoves : List<PokemonDetailMovesEntity>) = mPokemonDetailMovesDao.insertAndDeletePokemonDetailMoves(pokemonDetailMoves)

    suspend fun deletePokemonDetailMoves() = mPokemonDetailMovesDao.deletePokemonDetailMoves()

    fun getSearchPokemonDetailMoves(search: String): Flow<List<PokemonDetailMovesEntity>> = mPokemonDetailMovesDao.getSearchPokemonDetailMoves(search)


    fun getPokemonDetailTypes(): Flow<List<PokemonDetailTypesEntity>> = mPokemonDetailTypesDao.getPokemonDetailTypes()
    suspend fun insertPokemonDetailTypes(pokemonDetailTypes : List<PokemonDetailTypesEntity>) = mPokemonDetailTypesDao.insertAndDeletePokemonDetailTypes(pokemonDetailTypes)

    suspend fun deletePokemonDetailTypes() = mPokemonDetailTypesDao.deletePokemonDetailTypes()

    fun getSearchPokemonDetailTypes(search: String): Flow<List<PokemonDetailTypesEntity>> = mPokemonDetailTypesDao.getSearchPokemonDetailTypes(search)
}