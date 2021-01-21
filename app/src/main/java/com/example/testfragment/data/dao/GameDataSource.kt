package com.example.testfragment.data.dao

import android.content.Context
import com.example.testfragment.R
import com.example.testfragment.model.Console
import com.example.testfragment.model.Game

class GameDataSource {

    companion object {
        fun getGames(context: Context) : ArrayList<Game> {
            var games = ArrayList<Game>()

            games.add(Game(1, "Mortal Kombat",
                context.getDrawable(R.drawable.mortalkombat)!!, "Mortal Kombat é um jogo bem legal!", 4.5,
                listOf(
                    Console(1, "PlayStation 3", "Sony", "2011-04-19"),
                    Console(2, "Snes", "Nintendo", "1990-12-05")
                ))
            )

            games.add(Game(2, "Street Fighter",
                context.getDrawable(R.drawable.street)!!, "Street Fighter III é um jogo muito foda de luta!", 4.5,
                listOf(
                    Console(1, "Snes", "Nintendo", "1990-12-05")))
            )

            games.add(Game(3, "Black",
                context.getDrawable(R.drawable.black)!!, "Black é o melhor jogo de tiro do Ps2, e também o mais dificil!", 5.0,
                listOf(
                    Console(1, "PlayStation 2", "Sony", "2000-04-04")))
            )

            return games

        }
    }
}