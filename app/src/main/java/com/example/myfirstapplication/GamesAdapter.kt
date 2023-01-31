package com.example.myfirstapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class GamesViewHolder(view : View) : RecyclerView.ViewHolder(view){

    val gameName : TextView

    init {
        gameName = view.findViewById(R.id.games_name)
    }
}

class GamesAdapter(val games : List<GamesList>) : RecyclerView.Adapter<GamesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GamesViewHolder {
        val gameView = LayoutInflater.from(parent.context).inflate(R.layout.games_list_items, parent, false)
        return GamesViewHolder(gameView)
    }

    override fun getItemCount(): Int {
        return games.size
    }

    override fun onBindViewHolder(holder: GamesViewHolder, position: Int) {
        holder.gameName.text = games[position].name
    }
}