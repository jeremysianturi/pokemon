package com.example.core.data.repository

import com.example.core.data.NetworkBoundResourceWithDeleteLocalData
import com.example.core.data.Resource
import com.example.core.data.source.local.room.LocalDataSource
import com.example.core.data.source.remote.RemoteDataSource
import com.example.core.data.source.remote.network.ApiResponse
import com.example.core.data.source.remote.response.pokemondetail.moves.MovesResponse
import com.example.core.domain.model.PokemonDetailMoves
import com.example.core.domain.repository.IPokemonDetailMovesRepository
import com.example.core.helper.datamapper.DataMapperPokemonDetailMoves
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokemonDetailMovesRepository @Inject constructor (
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
) : IPokemonDetailMovesRepository
{
    override fun getPokemonDetailMoves(name: String): Flow<Resource<List<PokemonDetailMoves>>> =
        object :
            NetworkBoundResourceWithDeleteLocalData<List<PokemonDetailMoves>, List<MovesResponse>>() {

            override fun loadFromDB(): Flow<List<PokemonDetailMoves>> {
                return localDataSource.getPokemonDetailMoves().map {
                    DataMapperPokemonDetailMoves.mapEntitiestoDomain(it)
                }
            }

            override fun shouldFetch(data: List<PokemonDetailMoves>?): Boolean = true

            override suspend fun createCall(): Flow<ApiResponse<List<MovesResponse>>> =
                remoteDataSource.getPokemonDetailMoves(name)

            override suspend fun saveCallResult(data: List<MovesResponse>) {
                val list = DataMapperPokemonDetailMoves.mapResponsetoEntities(data)
                localDataSource.insertPokemonDetailMoves(list)
            }

            override suspend fun emptyDataBase() {
                localDataSource.deletePokemonDetailMoves()
            }

        }.asFlow()

    override fun getSearchPokemonDetailMoves(search: String): Flow<List<PokemonDetailMoves>> {
        return localDataSource.getSearchPokemonDetailMoves(search).map {
            DataMapperPokemonDetailMoves.mapEntitiestoDomain(it)
        }
    }
}