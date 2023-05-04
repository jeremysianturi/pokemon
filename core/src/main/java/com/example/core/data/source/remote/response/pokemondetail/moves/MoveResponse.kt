package com.example.core.data.source.remote.response.pokemondetail.moves

import com.google.gson.annotations.SerializedName

data class MoveResponse(
        @field:SerializedName("name")
        val name: String?,

        @field:SerializedName("url")
        val url: String?,
        )