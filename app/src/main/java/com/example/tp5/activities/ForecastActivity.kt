package com.example.tp5.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tp5.ForecastAdapter
import com.example.tp5.R
import com.example.tp5.WeatherViewModel
import com.example.tp5.model.WeatherModel

class ForecastActivity : AppCompatActivity() {
    private val model: WeatherViewModel by viewModels()
    private var data : ArrayList<WeatherModel> = arrayListOf()
    private var adapter : ForecastAdapter = ForecastAdapter(data)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecast)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this@ForecastActivity)
        recyclerView.adapter = adapter
        model.weatherForecast.observe(this){
            if (it!=null){
                adapter.setData(it)
                recyclerView.adapter = adapter
            }else{
                Log.d("it", "it is null")
            }
        }
        model.getWeatherForecast(model.location)
        val button : Button = findViewById(R.id.ReturnButton)
        button.setOnClickListener(){
            finish()
        }
    }
}