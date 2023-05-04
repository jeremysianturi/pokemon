package com.example.core.helper.datamapper

import com.example.core.data.source.local.entity.pokemonlist.PokemonListEntity
import com.example.core.data.source.remote.response.pokemonlist.PokemonListResponse
import com.example.core.domain.model.PokemonList

object DataMapperPokemonList {
    fun mapResponsetoEntities(input: List<PokemonListResponse>): List<PokemonListEntity> {
        val pokemonListList = ArrayList<PokemonListEntity>()
        input.map {
            val pokemonList = PokemonListEntity(
                id = 0,
                name = it.name ?: "",
                url = it.url ?: "",
            )
            pokemonListList.add(pokemonList)
        }

        return pokemonListList
    }

    fun mapEntitiestoDomain(input: List<PokemonListEntity>): List<PokemonList> =
        input.map {
            PokemonList(
                id = it.id,
                name = it.name,
                url = it.url,
            )
        }
}