package com.example.core.helper.datamapper

import com.example.core.data.source.local.entity.detailpokemontypes.PokemonDetailTypesEntity
import com.example.core.data.source.remote.response.pokemondetail.types.TypesResponse
import com.example.core.domain.model.PokemonDetailMoves
import com.example.core.domain.model.PokemonDetailTypes

object DataMapperPokemonDetailTypes {
    fun mapResponsetoEntities(input: List<TypesResponse>): List<PokemonDetailTypesEntity> {
        val pokemonDetailTypesList = ArrayList<PokemonDetailTypesEntity>()
        input.map {
            val pokemonDetailTypes = PokemonDetailTypesEntity(
                id = 0,
                typeName = it.type?.name!!,
                typeUrl = it.type.url!!,
            )
            pokemonDetailTypesList.add(pokemonDetailTypes)
        }

        return pokemonDetailTypesList
    }

    fun mapEntitiestoDomain(input: List<PokemonDetailTypesEntity>): List<PokemonDetailTypes> =
        input.map {
            PokemonDetailTypes(
                id = it.id,
                typeName = it.typeName,
                typeUrl = it.typeUrl,
            )
        }
}