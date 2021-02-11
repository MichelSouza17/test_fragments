package com.example.testfragment.data.dao

import android.content.Context
import com.example.testfragment.R
import com.example.testfragment.model.Console

class ConsoleDataSource {
    companion object {
        fun getConsoles(context: Context) : ArrayList<Console> {
            var consoles = ArrayList<Console>()

            consoles.add(
                Console(1, "PS4","25-12-2013", "O PlayStation 4, ou PS4 (como é mais conhecido) é um video game da Sony lançado em 2013. O console tem três versões principais: fat, slim e Pro.","SONY",
                     context.getDrawable(R.drawable.ps4console)!!
               )
            )

            consoles.add(
                Console(2, "XBOX-360","22-09-2005", "O sucessor do Xbox original foi revelado no dia 12 de maio de 2005. O Xbox 360 chegou em novembro daquele após ganhar vários apelidos antes de ter o nome original revelado: Xbox Next, Xenon, Xbox 2, Xbox FS e Next Xbox (o mesmo nick do Xbox 720).","MICROSOFT",
                    context.getDrawable(R.drawable.xbox)!!
                )
            )

            consoles.add(
                Console(3, "WII","19-06-2006", "Nintendo Wii, o quinto console da Nintendo, foi lançado em 2006 e faz parte da sétima geração de videogames. Dentre suas características marcantes, o Wii inovou ao trazer um controle sem fios - Wii Remote - capaz de detectar movimentos através de um acelerômetro.","NINTENDO",
                    context.getDrawable(R.drawable.nintendo)!!
                )
            )

            return consoles

        }
    }
}