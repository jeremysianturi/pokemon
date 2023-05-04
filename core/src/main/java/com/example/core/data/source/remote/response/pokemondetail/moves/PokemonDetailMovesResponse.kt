package com.example.core.data.source.remote.response.pokemondetail.moves

import com.google.gson.annotations.SerializedName

data class PokemonDetailMovesResponse (
    @field:SerializedName("moves")
    val moves: List<MovesResponse>,
        )