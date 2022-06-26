package br.com.brunomatheus.pokedex_android.view

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import br.com.brunomatheus.pokedex_android.domain.Pokemon
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import br.com.brunomatheus.pokedex_android.R

class PokemonAdapter(
    val items: List<Pokemon>
) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.bindView(item)

    }

    override fun getItemCount() = items.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(item: Pokemon) = with(itemView) {
            //mudar a referencia do this usando with
            val ivPokemon = findViewById<ImageView>(R.id.ivPokemon)
            val tvNumber = findViewById<TextView>(R.id.tvNumber)
            val tvPokemon = findViewById<TextView>(R.id.tvPokemon)
            val tvType1 = findViewById<TextView>(R.id.tvType1)
            val tvType2 = findViewById<TextView>(R.id.tvType2)

            //TODO: Load image with glide

            tvNumber.text = "Nº ${item.formattedNumber}"
            tvPokemon.text = item.name
            tvType1.text = item.types[0].name

            if (item.types.size > 1) {
                tvType2.visibility = View.VISIBLE
                tvType2.text = item.types[1].name
            } else {
                tvType2.visibility = View.GONE
            }

        }
    }

}