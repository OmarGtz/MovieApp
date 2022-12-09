package com.example.movieapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.toMovieUrl

class MovieDetailFragment : Fragment() {

    lateinit var stringTituloPelicula: String
    lateinit var stringImagenFondo:String
    lateinit var stringImagenPrincipal:String
    lateinit var stringDescripcionPelicula:String
    lateinit var stringFechaHora:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { bundle ->
            stringTituloPelicula = bundle.getString("title").toString()
            stringImagenFondo = bundle.getString("backdrop_path").toString()
            stringImagenPrincipal = bundle.getString("poster_path").toString()
            stringDescripcionPelicula = bundle.getString("overview").toString()
            stringFechaHora = bundle.getString("release_date").toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_movil_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tituloPelicula = view.findViewById<TextView>(R.id.titulo_pelicula)
        val imagenFondo = view.findViewById<ImageView>(R.id.imagen_fondo)
        val imagenPrincipal = view.findViewById<ImageView>(R.id.imagen_principal)
        val descripcionPelicula = view.findViewById<TextView>(R.id.descripcionpelicula)
        val fechaHora = view.findViewById<TextView>(R.id.fecha_hora)

        tituloPelicula.text = stringTituloPelicula
        descripcionPelicula.text = stringDescripcionPelicula
        fechaHora.text = stringFechaHora
        Glide.with(requireContext())
            .load(stringImagenFondo?.toMovieUrl())
            .into(imagenFondo)
        Glide.with(requireContext())
            .load(stringImagenPrincipal.toMovieUrl())
            .into(imagenPrincipal)
    }

}