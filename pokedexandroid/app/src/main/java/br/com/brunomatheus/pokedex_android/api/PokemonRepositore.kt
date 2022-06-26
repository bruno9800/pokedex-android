package br.com.brunomatheus.pokedex_android.api

import android.util.Log
import br.com.brunomatheus.pokedex_android.api.model.PokemonApiResult
import br.com.brunomatheus.pokedex_android.api.model.PokemonsApiResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PokemonRepositore {
    //https://pokeapi.co/api/v2/pokemon/?limit=151
    private val service: PokemonService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(PokemonService::class.java)
    }

    fun listPokemons(limit: Int = 151) {
        val call = service.listPokemons(limit)

        call.enqueue(object : Callback<PokemonsApiResult> {
            override fun onResponse(
                call: Call<PokemonsApiResult>,
                response: Response<PokemonsApiResult>
            ) {
                if(response.isSuccessful){
                    val body =  response.body()

                    body?.results?.let {
                        Log.d("POKEMON_API", it[0].name)
                    }
                }
                Log.e("POKEMON_API", "Pokemons list loaded.")
            }

            override fun onFailure(call: Call<PokemonsApiResult>, t: Throwable) {
                Log.e("POKEMON_API", "Error loading pokemons list.", t)
            }
        })
    }
}