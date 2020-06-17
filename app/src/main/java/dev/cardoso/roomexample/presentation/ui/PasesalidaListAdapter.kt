package dev.cardoso.roomexample.presentation.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.cardoso.roomexample.R
import dev.cardoso.roomexample.presentation.entities.Pasesalida
import kotlinx.android.synthetic.main.pasesalida_items.view.*


class PasesalidaListAdapter : RecyclerView.Adapter<PasesalidaListAdapter.NewsViewHolder>() {

    var pasesalida = mutableListOf<Pasesalida>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pasesalida_items, parent, false)
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return pasesalida.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(pasesalida[position])
    }

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(pasesalida: Pasesalida) {
            with(itemView) {
                folio.text = pasesalida.folio
            }
        }
    }

    fun updateList(list: List<Pasesalida>) {
        if (list.isNotEmpty()) {
            pasesalida.clear()
            pasesalida.addAll(list)
            notifyDataSetChanged()
        }
    }
}