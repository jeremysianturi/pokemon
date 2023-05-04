package com.example.myapplication.ui.pokemondetail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.core.domain.model.PokemonDetailMoves
import com.example.myapplication.R
import com.example.myapplication.databinding.ItemListDetailPokemonBinding

class PokemonDetailMovesAdapter : RecyclerView.Adapter<PokemonDetailMovesAdapter.UserViewHolder>() {

    var onItemClick: ((PokemonDetailMoves) -> Unit)? = null

    private val mData = ArrayList<PokemonDetailMoves>()

    fun setData(newListData: List<PokemonDetailMoves>?) {
        if (newListData == null) return
        mData.clear()
        mData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int
    ): PokemonDetailMovesAdapter.UserViewHolder {
        val mView = LayoutInflater.from(parent.context).inflate(R.layout.item_list_detail_pokemon, parent, false)
        return UserViewHolder(mView)
    }

    override fun getItemCount(): Int = mData.size

    override fun onBindViewHolder(holder: PokemonDetailMovesAdapter.UserViewHolder, position: Int) {
        holder.bind(mData[position])
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListDetailPokemonBinding.bind(itemView)
        fun bind(data: PokemonDetailMoves) {
            with(binding) {

                // concat string
                tvMove.text = data.moveName

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