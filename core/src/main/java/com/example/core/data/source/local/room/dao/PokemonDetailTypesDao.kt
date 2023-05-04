package com.example.core.data.source.local.room.dao

import androidx.room.*
import com.example.core.data.source.local.entity.detailpokemontypes.PokemonDetailTypesEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonDetailTypesDao {

    @Query("SELECT * FROM pokemon_detail_types")
    fun getPokemonDetailTypes(): Flow<List<PokemonDetailTypesEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemonDetailTypes(pokemonDetailTypes: List<PokemonDetailTypesEntity>)

    @Query("DELETE FROM pokemon_detail_types")
    suspend fun deletePokemonDetailTypes()

    @Transaction
    suspend fun insertAndDeletePokemonDetailTypes(content : List<PokemonDetailTypesEntity>) {
        deletePokemonDetailTypes()
        insertPokemonDetailTypes(content)
    }

    @Transaction
    @Query("SELECT * FROM pokemon_detail_types where type_name LIKE '%'|| :search || '%'")
    fun getSearchPokemonDetailTypes(search: String): Flow<List<PokemonDetailTypesEntity>>
}