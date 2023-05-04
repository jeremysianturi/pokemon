package com.example.core.data.source.remote.response.pokemondetail.moves

import com.google.gson.annotations.SerializedName

data class MovesResponse (
    @field:SerializedName("move")
    val move: MoveResponse?,
        )