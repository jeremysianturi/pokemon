package com.example.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class PokemonDetailMoves (
    val id : Int,
    val moveName : String,
    val moveUrl : String,
        ) : Parcelable