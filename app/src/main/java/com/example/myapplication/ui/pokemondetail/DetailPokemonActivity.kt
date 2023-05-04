package com.example.myapplication.ui.pokemondetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.core.data.Resource
import com.example.core.domain.model.PokemonDetailMoves
import com.example.core.domain.model.PokemonDetailTypes
import com.example.myapplication.databinding.ActivityDetailPokemonBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class DetailPokemonActivity : AppCompatActivity() {

    private val tag = DetailPokemonActivity::class.java.simpleName.toString()

    private lateinit var binding: ActivityDetailPokemonBinding
    private lateinit var adapterMoves: PokemonDetailMovesAdapter
    private lateinit var adapterTypes: PokemonDetailTypesAdapter
    private val pokemonDetailViewModel: PokemonDetailViewModel by viewModels()

    private var dataPokemonDetailMoves: List<PokemonDetailMoves>? = null
    private var dataPokemonDetailTypes: List<PokemonDetailTypes>? = null

    private lateinit var name: String
    private lateinit var url: String

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailPokemonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        name = intent.getStringExtra("name").toString()
        url = intent.getStringExtra("url").toString()
        Log.d(tag, "name from intent: $name")

        setupObserverMoves(name)
        buildListMoves()

        setupObserverTypes(name)
        buildListTypes()

    }

    private fun setupObserverMoves(name: String) {

        pokemonDetailViewModel.getPokemonDetailMoves(name).observe(this) { data ->

            if (data != null) {
                when (data) {
                    is Resource.Loading -> binding.progressBarPokemonDetail.visibility =
                        View.VISIBLE
                    is Resource.Success -> {
                        binding.progressBarPokemonDetail.visibility = View.GONE
                        adapterMoves.setData(data.data)
                        dataPokemonDetailMoves = data.data
                        setViewMoves()
                        Log.d("$tag", "observer pokrmon detail ${dataPokemonDetailMoves?.get(0)?.moveName}")
                    }
                    is Resource.Error -> {
                        binding.progressBarPokemonDetail.visibility = View.GONE
                        Log.d("$tag", "error_message pokemon detail ${data.message}")
//                        ErrorBottomSheet.instance(data.message.toString(), data.message.toString())
//                            .show(supportFragmentManager, ErrorBottomSheet.TAG)
                    }
                }

            }
        }

    }

    private fun buildListMoves() {

        adapterMoves = PokemonDetailMovesAdapter()
        binding.rvMoves.setHasFixedSize(true)
        binding.rvMoves.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvMoves.adapter = adapterMoves

        binding.rvMoves.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )

//        adapter.onItemClick = { selectData ->
//            val mIntent = Intent(this, DetailPokemonActivity::class.java)
//            mIntent.putExtra("name", selectData.name)
//            mIntent.putExtra("url", selectData.url)
//            startActivity(mIntent)
//        }
    }

    private fun setupObserverTypes(name: String) {

        pokemonDetailViewModel.getPokemonDetailTypes(name).observe(this) { data ->

            if (data != null) {
                when (data) {
                    is Resource.Loading -> binding.progressBarPokemonDetail.visibility =
                        View.VISIBLE
                    is Resource.Success -> {
                        binding.progressBarPokemonDetail.visibility = View.GONE
                        adapterTypes.setData(data.data)
                        dataPokemonDetailTypes = data.data
                        setViewTypes()
                        Log.d("$tag", "observer pokrmon detail ${dataPokemonDetailMoves?.get(0)?.moveName}")
                    }
                    is Resource.Error -> {
                        binding.progressBarPokemonDetail.visibility = View.GONE
                        Log.d("$tag", "error_message pokemon detail ${data.message}")
//                        ErrorBottomSheet.instance(data.message.toString(), data.message.toString())
//                            .show(supportFragmentManager, ErrorBottomSheet.TAG)
                    }
                }

            }
        }

    }

    private fun buildListTypes() {

        adapterTypes = PokemonDetailTypesAdapter()
        binding.rvTypes.setHasFixedSize(true)
        binding.rvTypes.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvTypes.adapter = adapterTypes

        binding.rvTypes.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )


    }

    private fun setViewMoves(){
        binding.apply {
            Log.d("$tag","check move name pertama : ${dataPokemonDetailMoves?.get(0)?.moveName} ")
            tvName.text = name
            tvDate.text = url
        }
    }

    private fun setViewTypes(){
        binding.apply {
            Log.d("$tag","check type name pertama : ${dataPokemonDetailTypes?.get(0)?.typeName} ")
            tvName.text = name
            tvDate.text = url
        }
    }

}