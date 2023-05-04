package com.example.core.data.repository

import com.example.core.data.NetworkBoundResourceWithDeleteLocalData
import com.example.core.data.Resource
import com.example.core.data.source.local.room.LocalDataSource
import com.example.core.data.source.remote.RemoteDataSource
import com.example.core.data.source.remote.network.ApiResponse
import com.example.core.data.source.remote.response.pokemondetail.moves.MovesResponse
import com.example.core.data.source.remote.response.pokemondetail.types.TypesResponse
import com.example.core.domain.model.PokemonDetailMoves
import com.example.core.domain.model.PokemonDetailTypes
import com.example.core.domain.repository.IPokemonDetailMovesRepository
import com.example.core.domain.repository.IPokemonDetailTypesRepository
import com.example.core.helper.datamapper.DataMapperPokemonDetailMoves
import com.example.core.helper.datamapper.DataMapperPokemonDetailTypes
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokemonDetailTypesRepository @Inject constructor (
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
) : IPokemonDetailTypesRepository
{
    override fun getPokemonDetailTypes(name: String): Flow<Resource<List<PokemonDetailTypes>>> =
        object :
            NetworkBoundResourceWithDeleteLocalData<List<PokemonDetailTypes>, List<TypesResponse>>() {

            override fun loadFromDB(): Flow<List<PokemonDetailTypes>> {
                return localDataSource.getPokemonDetailTypes().map {
                    DataMapperPokemonDetailTypes.mapEntitiestoDomain(it)
                }
            }

            override fun shouldFetch(data: List<PokemonDetailTypes>?): Boolean = true

            override suspend fun createCall(): Flow<ApiResponse<List<TypesResponse>>> =
                remoteDataSource.getPokemonDetailTypes(name)

            override suspend fun saveCallResult(data: List<TypesResponse>) {
                val list = DataMapperPokemonDetailTypes.mapResponsetoEntities(data)
                localDataSource.insertPokemonDetailTypes(list)
            }

            override suspend fun emptyDataBase() {
                localDataSource.deletePokemonDetailTypes()
            }

        }.asFlow()

    override fun getSearchPokemonDetailTypes(search: String): Flow<List<PokemonDetailTypes>> {
        return localDataSource.getSearchPokemonDetailTypes(search).map {
            DataMapperPokemonDetailTypes.mapEntitiestoDomain(it)
        }
    }
}