package com.example.core.helper.datamapper

import com.example.core.data.source.local.entity.detailpokemonmoves.PokemonDetailMovesEntity
import com.example.core.data.source.remote.response.pokemondetail.moves.MovesResponse
import com.example.core.data.source.remote.response.pokemondetail.moves.PokemonDetailMovesResponse
import com.example.core.domain.model.PokemonDetailMoves

object DataMapperPokemonDetailMoves {
    fun mapResponsetoEntities(input: List<MovesResponse>): List<PokemonDetailMovesEntity> {
        val pokemonDetailMovesList = ArrayList<PokemonDetailMovesEntity>()
        input.map {
            val pokemonDetailMoves = PokemonDetailMovesEntity(
                id = 0,
                moveName = it.move?.name!!,
                moveUrl = it.move.url!!,
            )
            pokemonDetailMovesList.add(pokemonDetailMoves)
        }

        return pokemonDetailMovesList
    }

    fun mapEntitiestoDomain(input: List<PokemonDetailMovesEntity>): List<PokemonDetailMoves> =
        input.map {
            PokemonDetailMoves(
                id = it.id,
                moveName = it.moveName,
                moveUrl = it.moveUrl,
            )
        }
}