package com.example.core.data.source.remote.network

import com.example.core.data.source.remote.response.pokemondetail.moves.MovesResponse
import com.example.core.data.source.remote.response.pokemondetail.moves.PokemonDetailMovesResponse
import com.example.core.data.source.remote.response.pokemondetail.types.PokemonDetailTypesResponse
import com.example.core.data.source.remote.response.pokemonlist.ListPokemonList
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("pokemon")
    suspend fun getPokemonList(
    ): ListPokemonList

    @GET("pokemon/{name}")
    suspend fun getDetailPokemonMoves(
        @Path(value = "name",encoded = true) name : String,
    ): PokemonDetailMovesResponse

    @GET("pokemon/{name}")
    suspend fun getDetailPokemontypes(
        @Path(value = "name",encoded = true) name : String,
    ): PokemonDetailTypesResponse


}