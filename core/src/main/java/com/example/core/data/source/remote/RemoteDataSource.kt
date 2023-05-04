package com.example.core.data.source.remote

import android.util.Log
import com.example.core.data.source.remote.network.ApiResponse
import com.example.core.data.source.remote.network.ApiService
import com.example.core.data.source.remote.response.pokemondetail.moves.MovesResponse
import com.example.core.data.source.remote.response.pokemondetail.types.TypesResponse
import com.example.core.data.source.remote.response.pokemonlist.PokemonListResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(
    private val apiService : ApiService
) {

    suspend fun getPokemonList(
    ): Flow<ApiResponse<List<PokemonListResponse>>> {
        return flow {
            try {
                val response = apiService.getPokemonList()
                val dataArray = response.data
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.data))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getPokemonDetailMoves(
        name: String
    ): Flow<ApiResponse<List<MovesResponse>>> {
        return flow {
            try {
                val response = apiService.getDetailPokemonMoves(name)
                val dataArray = response.moves
                Log.d("test","check di remote data source move $dataArray dan name: $name")
                if (dataArray.toString() != "null") {
                    emit(ApiResponse.Success(dataArray))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getPokemonDetailTypes(
        name: String
    ): Flow<ApiResponse<List<TypesResponse>>> {
        return flow {
            try {
                val response = apiService.getDetailPokemontypes(name)
                val dataArray = response.types
                Log.d("test","check di remote data source move $dataArray dan name: $name")
                if (dataArray.toString() != "null") {
                    emit(ApiResponse.Success(dataArray))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

}