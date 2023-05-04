package com.example.core.data.source.remote.response.pokemondetail.types

import com.google.gson.annotations.SerializedName

data class PokemonDetailTypesResponse (
    @field:SerializedName("types")
    val types: List<TypesResponse>,
        )