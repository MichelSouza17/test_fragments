package com.example.testfragment.holder

import android.view.ContextThemeWrapper
import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testfragment.R
import com.example.testfragment.model.Game
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import kotlinx.android.synthetic.main.holder_game_layout.view.*

class GameViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    val textGameName = itemView.findViewById<TextView>(R.id.text_view_game_name)
    val textGameDescription = itemView.findViewById<TextView>(R.id.text_view_game_description)
    val ratingBarGame = itemView.findViewById<RatingBar>(R.id.rating_bar_game)
    var imageGame = itemView.findViewById<ImageView>(R.id.image_game)
    val chipGroupConsoles = itemView.findViewById<ChipGroup>(R.id.chip_group_consoles)

    fun bind(game: Game){
        textGameName.text = game.gameName
        textGameDescription.text = game.gameDescription
        ratingBarGame.rating = game.gameRating
        imageGame.setImageDrawable(game.gameImage)

        for (console in game.consoles) {
            val chip = Chip(ContextThemeWrapper(itemView.context,  R.style.ChipTextAppearance), null, 0)

            chip.text = console.consoleName
            chipGroupConsoles.addView(chip)
        }

    }


}