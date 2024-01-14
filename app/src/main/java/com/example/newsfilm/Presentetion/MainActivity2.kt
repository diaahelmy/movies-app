package com.example.newsfilm.Presentetion

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsfilm.Presentetion.di.Injector
import com.example.newsfilm.R
import com.example.newsfilm.databinding.ActivityMain2Binding
import com.example.newsfilm.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity2 : AppCompatActivity() {
    @Inject
    lateinit var factory: MyViewModelFactor
    private lateinit var movieViewModel: MyViewModel
    private lateinit var binding: ActivityMain2Binding
    private lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        (application as Injector).createMovieSubComponent2().inject2(this)
        movieViewModel = ViewModelProvider(this, factory)[MyViewModel::class.java]

        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.recyclerView2.layoutManager = LinearLayoutManager(this)
        adapter = MovieAdapter(this)
        binding.recyclerView2.adapter = adapter

        displayPopularMovie()


    }
    private fun displayPopularMovie() {
        binding.progressBar2.visibility = View.VISIBLE
        val responseLiveData = movieViewModel.getMovies2()
        responseLiveData.observe(this, Observer {

            if (it != null) {
                adapter.setList2(it)
                adapter.notifyDataSetChanged()

                binding.progressBar2.visibility = View.GONE

            } else {
                binding.progressBar2.visibility = View.GONE
                Toast.makeText(this, "No Data Available", Toast.LENGTH_LONG).show()


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


    private fun updateMovies() {
        binding.progressBar2.visibility = View.VISIBLE
        val response = movieViewModel.updateMovies2()
        response.observe(this, Observer {
            if (it != null) {
                adapter.setList2(it)
                adapter.notifyDataSetChanged()
                binding.progressBar2.visibility = View.GONE


            } else {
                binding.progressBar2.visibility = View.GONE


            }


        })


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
}