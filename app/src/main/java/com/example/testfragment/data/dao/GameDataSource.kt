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
                context.getDrawable(R.drawable.mortalkombat)!!, "Mortal Kombat é uma série de jogos criados pelo estúdio de Chicago da Midway Games. Em 2011, depois da falência da Midway, a produção de Mortal Kombat foi adquirida pela Warner Bros, tornando-se em seguida na Netherealm. A Warner detém atualmente os direitos da série.", 5.0f,
                listOf(
                    Console(1, "PlayStation 4", "2013-12-25", "O PlayStation 4, ou PS4 (como é mais conhecido) é um video game da Sony lançado em 2013. O console tem três versões principais: fat, slim e Pro.","SONY",
                         context.getDrawable(R.drawable.ps4console)!!),
                    Console(2, "Snes", "1990-12-05", "Enquanto gráficos tridimensionais raramente foram vistos em outros consoles com o chip Super FX tendo início com o Star Fox em 1993, o Super Nintendo era capaz de rodar gráficos tridimensionais com mais detalhes e suavidade, despertando uma grande curiosidade entre os fãs da franquia.","Nintendo",
                         context.getDrawable(R.drawable.ps4console)!!)
                ))
            )

            games.add(Game(2, "Street Fighter",
                context.getDrawable(R.drawable.street)!!, "Street Fighter III é um jogo muito foda de luta!", 2.5f,
                listOf(
                    Console(1, "Snes", "1990-12-05", "Enquanto gráficos tridimensionais raramente foram vistos em outros consoles com o chip Super FX tendo início com o Star Fox em 1993, o Super Nintendo era capaz de rodar gráficos tridimensionais com mais detalhes e suavidade, despertando uma grande curiosidade entre os fãs da franquia.","Nintendo",
                         context.getDrawable(R.drawable.ps4console)!!)))
            )

            games.add(Game(3, "Black",
                context.getDrawable(R.drawable.black)!!, "Black é o melhor jogo de tiro do Ps2, e também o mais dificil!", 4.0f,
                listOf(
                    Console(1, "PlayStation 2", "2000-04-04", "O PlayStation 2 completa seu aniversário de 20 anos nesta quarta-feira (4). O console, lançado no Japão no ano 2000, foi a segunda empreitada da Sony no mercado de games após uma impressionante estreia com o PlayStation One. ","SONY",
                         context.getDrawable(R.drawable.ps4console)!!)))
            )

            return games

        }
    }
}