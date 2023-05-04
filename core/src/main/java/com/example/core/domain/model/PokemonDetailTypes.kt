package com.example.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class PokemonDetailTypes (
    val id : Int,
    val typeName : String,
    val typeUrl : String,
) : Parcelable