package com.example.testfragment.holder

import android.view.ContextThemeWrapper
import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testfragment.R
import com.example.testfragment.model.Console

class ConsoleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    val textConsoleName = itemView.findViewById<TextView>(R.id.text_view_console_name)
    val textConsoleDescription = itemView.findViewById<TextView>(R.id.text_view_console_description)
    val textDataLancamento = itemView.findViewById<TextView>(R.id.text_view_console_data_lancamento)
    val textConsoleMarker = itemView.findViewById<TextView>(R.id.text_view_console_fabricante)
    var imageConsole = itemView.findViewById<ImageView>(R.id.image_game)

    fun bind(console: Console){
        textConsoleName.text = console.consoleName
        textConsoleDescription.text = console.consoleDescription
        textDataLancamento.text = console.consoleReleaseDate
        textConsoleMarker.text = console.consoleMaker
        imageConsole.setImageDrawable(console.consoleImage)

    }
}