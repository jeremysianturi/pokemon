package com.example.core.data.source.local.room.dao

import androidx.room.*
import com.example.core.data.source.local.entity.detailpokemonmoves.PokemonDetailMovesEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonDetailMovesDao {

    @Query("SELECT * FROM pokemon_detail_moves")
    fun getPokemonDetailMoves(): Flow<List<PokemonDetailMovesEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemonDetailMoves(pokemonDetailMoves: List<PokemonDetailMovesEntity>)

    @Query("DELETE FROM pokemon_detail_moves")
    suspend fun deletePokemonDetailMoves()

    @Transaction
    suspend fun insertAndDeletePokemonDetailMoves(content : List<PokemonDetailMovesEntity>) {
        deletePokemonDetailMoves()
        insertPokemonDetailMoves(content)
    }

    @Transaction
    @Query("SELECT * FROM pokemon_detail_moves where move_name LIKE '%'|| :search || '%'")
    fun getSearchPokemonDetailMoves(search: String): Flow<List<PokemonDetailMovesEntity>>
}