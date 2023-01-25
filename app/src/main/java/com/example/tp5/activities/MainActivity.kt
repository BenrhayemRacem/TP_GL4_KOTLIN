package com.example.tp5.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.tp5.R
import com.example.tp5.WeatherViewModel
import com.example.tp5.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    private val model: WeatherViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private val locations = listOf<String>("Tunis", "London", "Paris", "Mozambique", "Brazil")
    var currentLocation : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        model.weather.observe(this) {
            this@MainActivity.binding.temp.text = it.temp.toString() + "°C"
            this@MainActivity.binding.overcast.text = it.overcast
            this@MainActivity.binding.humidityValue.text = it.humidity.toString()
            this@MainActivity.binding.pressureValue.text = it.pressure.toString()
            Picasso.get().load(it.iconUrl).into(binding.imageView)
        }

        binding.location.adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, this.locations)
        binding.location.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                currentLocation = this@MainActivity.locations[position]
                model.location = currentLocation
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(applicationContext, "Degla fsfs", Toast.LENGTH_SHORT).show()
            }
        }
        val button : Button = findViewById(R.id.button)
        button.setOnClickListener{
            val intent = Intent(this@MainActivity, ForecastActivity::class.java)
            intent.putExtra("location",currentLocation)
            startActivity(intent)
        }
    }
}