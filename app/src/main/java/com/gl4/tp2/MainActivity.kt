package com.gl4.tp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    val spinner : Spinner by lazy { findViewById(R.id.spinner) }
    var matieres = listOf<String>("Cours","TP")
    val recyclerView : RecyclerView by lazy { findViewById(R.id.recyclerView) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        spinner.adapter = ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,matieres)

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                handleClick(view)

            }
            override fun onNothingSelected(adapterView: AdapterView<*>?) {
            }
        }

        var studentDataset = listOf<Student>(Student("racem", "benrhayem", "man"),
            Student("ranim" , "benrhayem" , "woman") ,
            Student("mayess", "benrhayem", "man") ,
            Student("mohamed", "bouarada", "man") ,
            Student("nour", "benrhayem", "woman")
            );

        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity);
            adapter = StudentAdapter(studentDataset)
        }



    }

    fun handleClick(view:View?) {

        val duration = Toast.LENGTH_SHORT
        var toastText = "item clicked"

        Toast.makeText(this, toastText, duration).show()
    }

}