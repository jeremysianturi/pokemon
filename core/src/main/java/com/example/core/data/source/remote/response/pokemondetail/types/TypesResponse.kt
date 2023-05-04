package com.example.core.data.source.remote.response.pokemondetail.types

import com.google.gson.annotations.SerializedName

data class TypesResponse (
    @field:SerializedName("type")
    val type: TypeResponse?,
        )