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
        title = "HBO Version Temu"

        val categories=ArrayObjectAdapter(ListRowPresenter())

        val nutellaTitle = "Aventuras"
        val nutellaVideos = ArrayObjectAdapter(Card())
        nutellaVideos.addAll(0, listOf(
            Video("La princesa y el sapo", "Una aventura de ranas", R.mipmap.princesa, "Una aventura de un principe y una mecera con un sueño", R.raw.princesa),
            Video("Rampunzel", "de un cazuelazo", R.mipmap.princesb, "Es robada desde bebe porque tenia un poder magico", R.raw.princesb),
            Video("Sherk", "Sherk buchon", R.mipmap.princesc, "Un ogro que se enamora", R.raw.princesc),
            Video("Nutella", "video", R.mipmap.mishito, "Esta es la descripcion de nutella", R.raw.nutella),
            Video("Sin Luz", "foto", R.mipmap.mandarino, "Esta es la descripcion de mandarino", R.raw.utzmg)
        ))

        val nutellaHeader = HeaderItem(1, nutellaTitle)
        categories.add(ListRow(nutellaHeader, nutellaVideos))

        val musicaTitle = "Musica"
        val musicaVideos = ArrayObjectAdapter(Card())
        musicaVideos.addAll(0, listOf(
            Video("Alfredo Olivas", "El precio de la soledad", R.mipmap.alfredoa, "La musica es la puerta a un gran corazon", R.raw.alfredoa),
            Video("Alfredo Olivas", "TOP 1", R.mipmap.alfredob, "No solo es el sentomiento, si no lo que representa ante el alma", R.raw.alfredob),
            Video("Alfredo Olivas", "El problema", R.mipmap.alfredoc, " El himno de muchos", R.raw.alfredoc),
            Video("Alfredo Olivas", "Vete si te vas", R.mipmap.alfredod, "Directo al corazon", R.raw.alfredod),
            Video("Alfredo Olivas", "Tus lagrimas parecen sinseras", R.mipmap.alfredoe, "Sin duda una de las mejores en el albun", R.raw.alfredoe)
        ))
        categories.add(ListRow(HeaderItem(2, musicaTitle), musicaVideos))

        val caricaturasTitle = "Caricaturas"
        val caricaturasVideos = ArrayObjectAdapter(Card())
        caricaturasVideos.addAll(0, listOf(
            Video("Pocoyo", "Un niño jugueton", R.mipmap.caricaturasa, "Caricatura para niños", R.raw.caricaturasa),
            Video("El pajaro carpintero", "Un pajaro loco", R.mipmap.caricaturasb, "Un ave de muchas aventuras", R.raw.caricaturasb),
            Video("Winne Poo", "cartoon", R.mipmap.caricaturasc, "De las caricaturas de Disney", R.raw.caricaturasc),
            Video("Chiliw while", "Un pinguinito", R.mipmap.caricaturasd, "Un pinguinito muy bonito", R.raw.caricaturasd),
            Video("El pato Lucas", "Pantalon para tiendas", R.mipmap.caricaturase, "Una de las mas mejores", R.raw.caricaturase)
        ))
        categories.add(ListRow(HeaderItem(3, caricaturasTitle), caricaturasVideos))

        val megamenteTitle = "Megamente"
        val megamenteVideos = ArrayObjectAdapter(Card())
        megamenteVideos.addAll(0, listOf(
            Video("Megamente", "parte 1", R.mipmap.megamentea, "Megamente introducción", R.raw.megamentea),
            Video("Megamente", "parte 2", R.mipmap.megamenteb, "Megamente el inicio", R.raw.megamenteb),
            Video("Megamente", "parte 3", R.mipmap.megamentec, "Megamente y las aventuras", R.raw.megamentec),
            Video("Megamente", "parte 4", R.mipmap.megamented, "Megamente secuestro de roxan", R.raw.megamented),
            Video("Megamente", "parte 7", R.mipmap.megamentee, "Megamente rencuentro con metroman", R.raw.megamentee)
        ))
        categories.add(ListRow(HeaderItem(4, megamenteTitle), megamenteVideos))

        val peliculasTitle = "Peliculas"
        val peliculasVideos = ArrayObjectAdapter(Card())
        peliculasVideos.addAll(0, listOf(
            Video("Pelicula de Huevos", "Un huevo que queria ser pollo", R.mipmap.pelisa, "Una aventura de huevos", R.raw.pelisa),
            Video("Los increibles", "Los poderosos del vecindario", R.mipmap.pelisb, "Una familia con superpoderes", R.raw.pelisb),
            Video("Banbi", "Un Veadito pierde a su mamá", R.mipmap.pelisc, "Banbi queda herfano despues de que los humanos mataran a su mamá", R.raw.pelisc),
            Video("Spirit", "Un espiritud libre", R.mipmap.pelisd, "Uncaballo indomable", R.raw.pelisd),
            Video("Rio 2", "Un parajo Volador", R.mipmap.pelise, "Una aventura de aves", R.raw.pelise)
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