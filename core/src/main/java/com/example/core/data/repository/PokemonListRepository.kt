package com.example.core.data.repository

import com.example.core.data.NetworkBoundResourceWithDeleteLocalData
import com.example.core.data.Resource
import com.example.core.data.source.local.room.LocalDataSource
import com.example.core.data.source.remote.RemoteDataSource
import com.example.core.data.source.remote.network.ApiResponse
import com.example.core.data.source.remote.response.pokemonlist.PokemonListResponse
import com.example.core.domain.model.PokemonList
import com.example.core.domain.repository.IPokemonListRepository
import com.example.core.helper.datamapper.DataMapperPokemonList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokemonListRepository @Inject constructor (
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
        ) : IPokemonListRepository
{
    override fun getPokemonList(): Flow<Resource<List<PokemonList>>> =
        object :
            NetworkBoundResourceWithDeleteLocalData<List<PokemonList>, List<PokemonListResponse>>() {

            override fun loadFromDB(): Flow<List<PokemonList>> {
                return localDataSource.getPokemonList().map {
                    DataMapperPokemonList.mapEntitiestoDomain(it)
                }
            }

            override fun shouldFetch(data: List<PokemonList>?): Boolean = true

            override suspend fun createCall(): Flow<ApiResponse<List<PokemonListResponse>>> =
                remoteDataSource.getPokemonList()

            override suspend fun saveCallResult(data: List<PokemonListResponse>) {
                val list = DataMapperPokemonList.mapResponsetoEntities(data)
                localDataSource.insertPokemonList(list)
            }

            override suspend fun emptyDataBase() {
                localDataSource.deletePokemonList()
            }

        }.asFlow()

    override fun getSearchPokemonList(search: String): Flow<List<PokemonList>> {
        return localDataSource.getSearchPokemonList(search).map {
            DataMapperPokemonList.mapEntitiestoDomain(it)
        }
    }
}