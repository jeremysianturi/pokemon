package com.example.core.data.source.local.room.dao

import androidx.room.*
import com.example.core.data.source.local.entity.pokemonlist.PokemonListEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonListDao {

    @Query("SELECT * FROM pokemon_list")
    fun getPokemonList(): Flow<List<PokemonListEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemonList(pokemonList: List<PokemonListEntity>)

    @Query("DELETE FROM pokemon_list")
    suspend fun deletePokemonList()

    @Transaction
    suspend fun insertAndDeletePokemonList(content : List<PokemonListEntity>) {
        deletePokemonList()
        insertPokemonList(content)
    }

    @Transaction
    @Query("SELECT * FROM pokemon_list where name LIKE '%'|| :search || '%'")
    fun getSearchPokemonList(search: String): Flow<List<PokemonListEntity>>
}