package com.example.myapplication.ui.pokemonlist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.core.data.Resource
import com.example.core.utils.ErrorMessageSplit
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityPokemonListBinding
import com.example.myapplication.ui.pokemondetail.DetailPokemonActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import timber.log.Timber

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class PokemonListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPokemonListBinding
    private lateinit var adapter : PokemonListAdapter
    private val pokemonListViewModel : PokemonListViewModel by viewModels()

    private val tag = PokemonListActivity::class.java.simpleName.toString()
    private var nameChoosen : String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokemonListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        // onclick
        onclick()

        // setup toolbar
        toolbarSetup()

        // observe
        setupObserver()
        buildList()

        // search
        binding.layoutToolbar.edtSearch.doOnTextChanged { text, start, before, count ->
            pokemonListViewModel.searchQuery.value = text.toString()
        }
    }

    private fun setupObserver() {

        pokemonListViewModel.getPokemonList().observe(this) { data ->

            if (data != null) {
                when (data) {
                    is Resource.Loading -> binding.progressBarProposal.visibility = View.VISIBLE
                    is Resource.Success -> {
                        binding.progressBarProposal.visibility = View.GONE
                        adapter.setData(data.data)
                        Timber.tag(tag).d("observer pokemon list: ${data.data}")
                    }
                    is Resource.Error -> {
                        binding.progressBarProposal.visibility = View.GONE
                        val message = data.message.toString()
                        Toast.makeText(this, "Error: $message", Toast.LENGTH_SHORT).show()
                        Log.d("$tag","check error : $message")
//                        val message = ErrorMessageSplit.message(data.message.toString())
//                        val code = ErrorMessageSplit.code(data.message.toString())
//                        SimpleDialog.newInstance(code, message)
//                            .show(supportFragmentManager, SimpleDialog.TAG)
//                        ErrorBottomSheet.instance(code, message)
//                            .show(supportFragmentManager, ErrorBottomSheet.TAG)
                    }
                }

            }
        }

        pokemonListViewModel.search.observe(this, { data ->
            adapter.setData(data)

        })
    }

    private fun buildList() {

        adapter = PokemonListAdapter()
        binding.rvPokemonlist.setHasFixedSize(true)
        binding.rvPokemonlist.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvPokemonlist.adapter = adapter

        binding.rvPokemonlist.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )

        adapter.onItemClick = { selectData ->
            val mIntent = Intent(this, DetailPokemonActivity::class.java)
            mIntent.putExtra("name", selectData.name)
            mIntent.putExtra("url", selectData.url)
            startActivity(mIntent)
        }
    }

    private fun onclick() {
        binding.apply {

        }
    }

    private fun toolbarSetup() {

        binding.layoutToolbar.apply {
            ivNavigationBack.setOnClickListener { onBackPressed() }

            Glide.with(this@PokemonListActivity)
                .load(R.drawable.pokemon_three)
                .into(imageView)

            tvTittle1.text = "Pokemon"
            tvTittle2.text = "Application"
        }
    }
}