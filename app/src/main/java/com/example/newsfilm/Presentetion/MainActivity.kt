package com.example.newsfilm.Presentetion

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsfilm.Presentetion.di.Injector
import com.example.newsfilm.R
import com.example.newsfilm.data.MovieRepositoryIMPL
import com.example.newsfilm.data.datasource.MovieCacheDataSource
import com.example.newsfilm.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: MyViewModelFactor
    private lateinit var binding: ActivityMainBinding
    private lateinit var movieViewModel: MyViewModel
    private lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        binding.button.setOnClickListener {

            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)

        }




            (application as Injector).createMovieSubComponent().inject(this)

            movieViewModel = ViewModelProvider(this, factory)[MyViewModel::class.java]

            initRecyclerView()


    }

    private fun initRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MovieAdapter(this)
        binding.recyclerView.adapter = adapter

        displayPopularMovie()


    }

    @SuppressLint("NotifyDataSetChanged")
    private fun displayPopularMovie() {
        binding.progressBar.visibility = View.VISIBLE
        val responseLiveData = movieViewModel.getMovies()
        responseLiveData.observe(this, Observer {

            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.progressBar.visibility = View.GONE

            } else {
                binding.progressBar.visibility = View.GONE
                Toast.makeText(applicationContext, "No Data Available", Toast.LENGTH_LONG).show()


            }

        })


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.update, menu)

        return true


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {

            R.id.action_update -> {
                if (isNetworkAvailable()) {
                    updateMovies()
                } else {
                    Toast.makeText(this, "No internet connection available.", Toast.LENGTH_SHORT).show()
                }
                true
            }

            else -> super.onOptionsItemSelected(item)


        }

    }

    fun isNetworkAvailable(): Boolean {
        val connectivityManager = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val activeNetwork = connectivityManager.activeNetwork ?: return false
        val networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false

        return  when {
            networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else ->  false
        }


    }

    @SuppressLint("NotifyDataSetChanged")
    private fun updateMovies() {
        binding.progressBar.visibility = View.VISIBLE
        val response = movieViewModel.updateMovies()
        response.observe(this, Observer {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.progressBar.visibility = View.GONE


            } else {
                binding.progressBar.visibility = View.GONE


            }


        })


    }

}