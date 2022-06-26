package br.com.brunomatheus.pokedex_android.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.brunomatheus.pokedex_android.R
import br.com.brunomatheus.pokedex_android.api.PokemonRepositore
import br.com.brunomatheus.pokedex_android.domain.Pokemon
import br.com.brunomatheus.pokedex_android.domain.PokemonType

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.rvPokemons)

        val charmander = Pokemon(
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/004.png",
            1,
            "Charmander",
            listOf(
                PokemonType("Fire")
            )
        )


        val pokemons = listOf(
            charmander, charmander
        )

        val pokemonsApi = PokemonRepositore.listPokemons()

        val layoutManeger = LinearLayoutManager(this)

        recyclerView.layoutManager = layoutManeger

        recyclerView.adapter = PokemonAdapter(pokemons)
    }
}