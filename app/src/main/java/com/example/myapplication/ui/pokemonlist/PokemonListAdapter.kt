package com.example.myapplication.ui.pokemonlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.core.domain.model.PokemonList
import com.example.myapplication.R
import com.example.myapplication.databinding.ItemPokemonListBinding

class PokemonListAdapter : RecyclerView.Adapter<PokemonListAdapter.UserViewHolder>() {

    var onItemClick: ((PokemonList) -> Unit)? = null

    private val mData = ArrayList<PokemonList>()

    fun setData(newListData: List<PokemonList>?) {
        if (newListData == null) return
        mData.clear()
        mData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int
    ): PokemonListAdapter.UserViewHolder {
        val mView = LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon_list, parent, false)
        return UserViewHolder(mView)
    }

    override fun getItemCount(): Int = mData.size

    override fun onBindViewHolder(holder: PokemonListAdapter.UserViewHolder, position: Int) {
        holder.bind(mData[position])
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemPokemonListBinding.bind(itemView)
        fun bind(data: PokemonList) {
            with(binding) {

                // concat string
                tvContenttitle.text = data.name
                tvName.text = data.url
                tvId.text = data.id.toString()

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