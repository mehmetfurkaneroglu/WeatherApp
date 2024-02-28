package com.example.weatherapp.view

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.weatherapp.R
import com.example.weatherapp.databinding.ActivityMainBinding
import com.example.weatherapp.viewmodel.MainViewModel

// API KEY : YOUR_API_KEY
// BASE URL : http://api.openweathermap.org/data/2.5/weather?q=istanbul&appid=
// https://api.openweathermap.org/data/2.5/weather?lat=41.0&lon=28.9&appid=YOUR_API_KEY

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var GET: SharedPreferences
    private lateinit var SET: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        GET = getSharedPreferences("com.example.weatherapp.view", MODE_PRIVATE)
        SET = GET.edit()

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val cName = GET.getString("cityName","istanbul").orEmpty()
        binding.editCityName.setText(cName)

/*
        cName?.let {
            viewModel.refreshData(it)
        }
 */

        viewModel.refreshData(cName)/*.toString()*/
        //viewModel.refreshData(cName.toString())
        //viewModel.refreshData(cName!!) // !!'sız yap

        getLiveData()

        binding.swipeRefreshLayout.setOnRefreshListener {
            binding.llData.visibility = View.GONE
            binding.tvError.visibility = View.GONE
            binding.pbLoading.visibility = View.GONE
            binding.tvNullName.visibility = View.GONE

            var cityName = GET.getString("cityName",cName).orEmpty()
            binding.editCityName.setText(cityName)
            viewModel.refreshData(cityName/*.toString()*/)
            binding.swipeRefreshLayout.isRefreshing = false
        }

                binding.editCityName.addTextChangedListener(object : TextWatcher {
                    override fun beforeTextChanged(charSequence: CharSequence?, start: Int, count: Int, after: Int) {
                    }

                    override fun onTextChanged(charSequence: CharSequence?, start: Int, before: Int, count: Int) {
                    }

                    override fun afterTextChanged(editable: Editable?) {
                        val cityName = editable.toString()
                        SET.putString("cityName", cityName)
                        SET.apply()
                        viewModel.refreshData(cityName)
                        getLiveData()
                    }
                })


///*
        binding.imgSearchCity.setOnClickListener{
            val cityName = binding.editCityName.text.toString()
            SET.putString("cityName",cityName)
            SET.apply()
            viewModel.refreshData(cityName)
            getLiveData()
        }

        //*/

    }


    private fun getLiveData() {
        viewModel.weather_data.observe(this, Observer {data ->
            data?.let {
                binding.llData.visibility = View.VISIBLE
                binding.pbLoading.visibility = View.GONE
                binding.tvDegree.text = data.main.temp.toString() + " °C"
                binding.tvCityCode.text = data.sys.country.toString()
                binding.tvCityName.text = data.name.toString()
                binding.tvHumidity.text = data.main.humidity.toString()
                binding.tvWindSpeed.text = data.wind.speed.toString() + "%"
                binding.tvLat.text = data.coord.lat.toString()
                binding.tvLon.text = data.coord.lon.toString()

                Glide.with(this)
                    .load("https://openweathermap.org/img/wn/" + data.weather.get(0).icon + "@2x.png")
                    .into(binding.imgWeatherPictures)


            }
        })
        viewModel.weather_load.observe(this, Observer{ load ->
            load?.let{
                if (it) {
                    binding.pbLoading.visibility = View.VISIBLE
                    binding.tvError.visibility = View.GONE
                    binding.llData.visibility = View.GONE
                    binding.tvNullName.visibility = View.GONE

                }
                else{
                    binding.pbLoading.visibility = View.GONE
                }
            }
        })
        viewModel.weather_error.observe(this, Observer{ load ->
            load?.let{
                if (it) {
                    binding.tvError.visibility = View.VISIBLE
                    binding.llData.visibility = View.GONE
                    binding.pbLoading.visibility = View.GONE
                    binding.tvNullName.visibility = View.GONE

                }
                else{
                    binding.tvError.visibility = View.GONE
                }
            }

        })
        /*
        viewModel.weather_name.observe(this, Observer { load ->
            load?.let {
                if (it) {
                    binding.tvError.visibility = View.VISIBLE
                    binding.llData.visibility = View.GONE
                    binding.pbLoading.visibility = View.GONE
                }
            }
        })
         */
/*
        binding.editCityName.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                println("searching: "+ s.toString())
                search(s.toString())
            }

        })
 */
        /*
        binding.editCityName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                val cityName = s.toString()
                SET.putString("cityName", cityName)
                SET.apply()

                if (cityName.length >= 3) {
                    viewModel.refreshData(cityName)
                    getLiveData()
                    println("searching: $cityName")
                    search(cityName)
                } else {

                }
            }
        })


         */

    }

    private fun search(searchText: String){
        if (searchText.isEmpty()){
            binding.tvNullName.visibility = View.VISIBLE
            binding.tvError.visibility = View.GONE
            binding.llData.visibility = View.GONE
            binding.pbLoading.visibility = View.GONE
        }else{
            binding.tvNullName.visibility = View.GONE
        }
    }
}