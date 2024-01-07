package com.example.newsfilm.Presentetion

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsfilm.R
import com.example.newsfilm.data.model.Movie
import com.example.newsfilm.databinding.ListItemBinding
import kotlin.random.Random

class MovieAdapter() : RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {
    private val moviesList = ArrayList<Movie>()
    fun setList(movies: List<Movie>) {
        moviesList.clear()
        moviesList.addAll(movies)

    }

    class MyViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            binding.descTextView.text = movie.overview
            binding.titleTextView.text = movie.title

            val posterUrl =  "https://image.tmdb.org/t/p/w500/"+ movie.posterpath
            Glide.with(binding.imageView.context).load(posterUrl)
                .into(binding.imageView)
        }
        val cardcolor=binding.cardView

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
            // Generate a new random color while excluding yellow
            // This loop ensures it's not yellow again
            while (randomColor == Color.YELLOW ) {
                red = Random.nextInt(256)
                green = Random.nextInt(256)
                blue = Random.nextInt(256)
                randomColor = Color.parseColor(String.format("#%02X%02X%02X", red, green, blue))
                holder.cardcolor.setBackgroundColor(Color.parseColor(randomColor.toString()))

            }
        }
        holder.bind(moviesList[position])


    }

    override fun getItemCount(): Int {
        return moviesList.size
    }


}