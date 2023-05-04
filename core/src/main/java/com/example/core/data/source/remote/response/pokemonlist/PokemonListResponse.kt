package com.example.core.data.source.remote.response.pokemonlist

import com.google.gson.annotations.SerializedName

data class PokemonListResponse (

    @field:SerializedName("name")
    val name: String?,

    @field:SerializedName("url")
    val url: String?,

)