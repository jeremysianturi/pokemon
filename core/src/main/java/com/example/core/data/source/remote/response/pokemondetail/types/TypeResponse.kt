package com.example.core.data.source.remote.response.pokemondetail.types

import com.google.gson.annotations.SerializedName

data class TypeResponse (
    @field:SerializedName("name")
    val name: String?,

    @field:SerializedName("url")
    val url: String?,
        )