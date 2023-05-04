package com.example.core.data.source.local.entity.detailpokemonmoves

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemon_detail_moves")
class PokemonDetailMovesEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "move_name")
    val moveName: String,

    @ColumnInfo(name = "move_url")
    val moveUrl: String,
        )

