package com.example.core.data.source.local.entity.detailpokemontypes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemon_detail_types")
class PokemonDetailTypesEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "type_name")
    val typeName: String,

    @ColumnInfo(name = "type_url")
    val typeUrl: String,
)
