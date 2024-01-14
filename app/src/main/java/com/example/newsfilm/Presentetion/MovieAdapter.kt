package com.example.newsfilm.Presentetion

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsfilm.R
import com.example.newsfilm.data.model.Movie
import com.example.newsfilm.data.model.MovieRate
import com.example.newsfilm.databinding.ListItemBinding

import kotlin.random.Random

class MovieAdapter(private val context: Context) : RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {
    private val moviesList = ArrayList<Movie>()
    private val moviesList2 = ArrayList<MovieRate>()
    fun setList(movies: List<Movie>) {
        moviesList.clear()
        moviesList.addAll(movies)

    }

    fun setList2(moviesR: List<MovieRate>) {
        moviesList2.clear()
        moviesList2.addAll(moviesR)

    }

    class MyViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            binding.descTextView.text = movie.overview
            binding.titleTextView.text = movie.title

            val posterUrl = "https://image.tmdb.org/t/p/w500/" + movie.posterpath
            Glide.with(binding.imageView.context).load(posterUrl)
                .into(binding.imageView)
        }

        fun bind2(movie: MovieRate) {
            binding.descTextView.text = movie.overview
            binding.titleTextView.text = movie.title

            val posterUrl = "https://image.tmdb.org/t/p/w500/" + movie.posterpath
            Glide.with(binding.imageView.context).load(posterUrl)
                .into(binding.imageView)
        }

        val cardcolor = binding.cardView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)
        return MyViewHolder(binding)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        var red = Random.nextInt(256)
        var green = Random.nextInt(256)
        var blue = Random.nextInt(256)
        var randomColor = Color.parseColor(String.format("#%02X%02X%02X", red, green, blue))
        if (randomColor != Color.YELLOW) {
            holder.cardcolor.setBackgroundColor(randomColor)
        } else {
            while (randomColor == Color.YELLOW) {
                red = Random.nextInt(256)
                green = Random.nextInt(256)
                blue = Random.nextInt(256)
                randomColor = Color.parseColor(String.format("#%02X%02X%02X", red, green, blue))
                holder.cardcolor.setBackgroundColor(Color.parseColor(randomColor.toString()))

            }
        }


        if (context is MainActivity) { // Use `this.context` to refer to the Android Context
            holder.bind(moviesList[position])
        } else {
            holder.bind2(moviesList2[position])
        }

    }

    override fun getItemCount(): Int {
         if (context is MainActivity) { // Use `this.context` to refer to the Android Context
             return   moviesList.size
        } else {
          return  moviesList2.size
        }
    }


}