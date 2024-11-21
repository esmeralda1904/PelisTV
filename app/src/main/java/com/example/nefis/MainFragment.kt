package com.example.nefis

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.HeaderItem
import androidx.leanback.widget.ListRow
import androidx.leanback.widget.ListRowPresenter
import androidx.leanback.widget.OnItemViewClickedListener
import androidx.leanback.widget.OnItemViewSelectedListener

class MainFragment: BrowseSupportFragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        title="Netflix pirata"

        val categories=ArrayObjectAdapter(ListRowPresenter())

        val nutellaTitle = "Nutella"
        val nutellaVideos = ArrayObjectAdapter(Card())
        nutellaVideos.addAll(0, listOf(
            Video("La princesa y el sapo", "Una aventura de ranas", R.mipmap.princesa, "Video Princesa A", R.raw.princesa),
            Video("Rampunzel", "de un cazuelazo", R.mipmap.princesb, "Video Princesa B", R.raw.princesb),
            Video("Sherk", "Sherk buchon", R.mipmap.princesc, "Video Princesa C", R.raw.princesc),
            Video("Nutella", "video", R.mipmap.mishito, "Esta es la descripcion de nutella", R.raw.nutella),
            Video("Sin Luz", "foto", R.mipmap.mandarino, "Esta es la descripcion de mandarino", R.raw.utzmg)
        ))

        val nutellaHeader = HeaderItem(1, nutellaTitle)
        categories.add(ListRow(nutellaHeader, nutellaVideos))

        val musicaTitle = "Musica"
        val musicaVideos = ArrayObjectAdapter(Card())
        musicaVideos.addAll(0, listOf(
            Video("Alfredo Olivas", "El precio de la soledad", R.mipmap.alfredoa, "Alfredo A", R.raw.alfredoa),
            Video("Alfredo Olivas", "TOP 1", R.mipmap.alfredob, "Alfredo B", R.raw.alfredob),
            Video("Alfredo Olivas", "El problema", R.mipmap.alfredoc, "Alfredo C", R.raw.alfredoc),
            Video("Alfredo Olivas", "Vete si te vas", R.mipmap.alfredod, "Alfredo D", R.raw.alfredod),
            Video("Alfredo Olivas", "Tus lagrimas parecen sinseras", R.mipmap.alfredoe, "Alfredo E", R.raw.alfredoe)
        ))
        categories.add(ListRow(HeaderItem(2, musicaTitle), musicaVideos))

        val caricaturasTitle = "Caricaturas"
        val caricaturasVideos = ArrayObjectAdapter(Card())
        caricaturasVideos.addAll(0, listOf(
            Video("Pocoyo", "Un niño jugueton", R.mipmap.caricaturasa, "Caricatura A", R.raw.caricaturasa),
            Video("El pajaro carpintero", "Un pajaro loco", R.mipmap.caricaturasb, "Caricatura B", R.raw.caricaturasb),
            Video("Winne Poo", "cartoon", R.mipmap.caricaturasc, "Caricatura C", R.raw.caricaturasc),
            Video("Chiliw while", "Un pinguinito", R.mipmap.caricaturasd, "Caricatura D", R.raw.caricaturasd),
            Video("El pato Lucas", "Pantalon para tiendas", R.mipmap.caricaturase, "Caricatura E", R.raw.caricaturase)
        ))
        categories.add(ListRow(HeaderItem(3, caricaturasTitle), caricaturasVideos))

        val megamenteTitle = "Megamente"
        val megamenteVideos = ArrayObjectAdapter(Card())
        megamenteVideos.addAll(0, listOf(
            Video("Megamente", "parte 1", R.mipmap.megamentea, "Megamente A", R.raw.megamentea),
            Video("Megamente", "parte 2", R.mipmap.megamenteb, "Megamente B", R.raw.megamenteb),
            Video("Megamente", "parte 3", R.mipmap.megamentec, "Megamente C", R.raw.megamentec),
            Video("Megamente", "parte 4", R.mipmap.megamented, "Megamente D", R.raw.megamented),
            Video("Megamente", "parte 7", R.mipmap.megamentee, "Megamente E", R.raw.megamentee)
        ))
        categories.add(ListRow(HeaderItem(4, megamenteTitle), megamenteVideos))

        val peliculasTitle = "Peliculas"
        val peliculasVideos = ArrayObjectAdapter(Card())
        peliculasVideos.addAll(0, listOf(
            Video("Pelicula de Huevos", "Un huevo que queria ser pollo", R.mipmap.pelisa, "Peli A", R.raw.pelisa),
            Video("Los increibles", "Los poderosos del vecindario", R.mipmap.pelisb, "Peli B", R.raw.pelisb),
            Video("Banbi", "Un Veadito pierde a su mamá", R.mipmap.pelisc, "Peli C", R.raw.pelisc),
            Video("Spirit", "Un espiritud libre", R.mipmap.pelisd, "Peli D", R.raw.pelisd),
            Video("Rio 2", "Un parajo Volador", R.mipmap.pelise, "Peli E", R.raw.pelise)
        ))
        categories.add(ListRow(HeaderItem(5, peliculasTitle), peliculasVideos))

        adapter=categories

        onItemViewClickedListener= OnItemViewClickedListener{ _, video, _, _ ->
            val intent=Intent(requireContext(), PlayActivity::class.java).apply{
                putExtra(PlayActivity.MOVIE_EXTRA, video as Video)
            }
            startActivity(intent)
        }
    }
}