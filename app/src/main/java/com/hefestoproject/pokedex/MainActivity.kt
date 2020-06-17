package com.hefestoproject.pokedex

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_itempokemon.view.*

class MainActivity : AppCompatActivity() {
    private var pokemons: List<Pokemon> = listOf(
        Pokemon(
            "Pikachu",
           25,
            listOf("Eletric"),
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png",
           6f,
            4f,
            -3.1028263,
            -68.8147652
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvPokemons.adapter = PokemonAdapter(pokemons)
        shouldDisplayEmptyView(pokemons.isEmpty())
    }

    fun shouldDisplayEmptyView(isEmpty : Boolean){
        emptyView.visibility = if(isEmpty) View.VISIBLE else View.GONE
    }

    class PokemonAdapter(private val pokemons: List<Pokemon>): RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>(){
        class PokemonViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
            val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.list_itempokemon, parent, false)
            return PokemonViewHolder(itemView)
        }

        override fun getItemCount() = pokemons.size

        @SuppressLint("SetTextI18n")
        override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
            holder.itemView.tvPokemonName.text = pokemons[position].name
            holder.itemView.tvPokemonNumber.text = "#%03d".format(pokemons[position].number)
            Picasso.get().load(pokemons[position].imageUrl).into(holder.itemView.ivPokemonImage)

        }
    }
}