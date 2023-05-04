package com.example.myapplication.ui.pokemondetail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.core.domain.model.PokemonDetailTypes
import com.example.myapplication.R
import com.example.myapplication.databinding.ItemListDetailPokemonBinding

class PokemonDetailTypesAdapter : RecyclerView.Adapter<PokemonDetailTypesAdapter.UserViewHolder>() {

    var onItemClick: ((PokemonDetailTypes) -> Unit)? = null

    private val mData = ArrayList<PokemonDetailTypes>()

    fun setData(newListData: List<PokemonDetailTypes>?) {
        if (newListData == null) return
        mData.clear()
        mData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int
    ): PokemonDetailTypesAdapter.UserViewHolder {
        val mView = LayoutInflater.from(parent.context).inflate(R.layout.item_list_detail_pokemon, parent, false)
        return UserViewHolder(mView)
    }

    override fun getItemCount(): Int = mData.size

    override fun onBindViewHolder(holder: PokemonDetailTypesAdapter.UserViewHolder, position: Int) {
        holder.bind(mData[position])
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListDetailPokemonBinding.bind(itemView)
        fun bind(data: PokemonDetailTypes) {
            with(binding) {

                // concat string
                tvMove.text = data.typeName

//                tvDateWahana.text = data.beginDate
//                ivProfilepic.loadImage(itemView.context,data.thumbnail)
//                ivContentWahana.loadImage(itemView.context,data.thumbnail)
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(mData[adapterPosition])
            }
        }


    }

}