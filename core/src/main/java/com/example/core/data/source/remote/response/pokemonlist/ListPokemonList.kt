package com.example.core.data.source.remote.response.pokemonlist

import com.google.gson.annotations.SerializedName

data class ListPokemonList (
        @field:SerializedName("results")
        val data: List<PokemonListResponse>
        )