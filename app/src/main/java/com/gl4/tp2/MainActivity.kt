package com.gl4.tp2


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher

import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class MainActivity : AppCompatActivity() {
    val spinner : Spinner by lazy { findViewById(R.id.spinner) }
    var matieres = listOf<String>("Cours","TP")
    val recyclerView : RecyclerView by lazy { findViewById(R.id.recyclerView) }

    lateinit var textViewPersonName : EditText

    val studentDatasetCourse = arrayListOf<Student>(Student("racem", "benrhayem", "man"),
        Student("ranim" , "benrhayem" , "woman" ,) ,
        Student("mayess", "benrhayem", "man" , ) ,
        Student("mohamed", "bouarada", "man") ,
        Student("nour", "benrhayem", "woman")
    );

    val studentDatasetTp = arrayListOf<Student>(Student("mazen", "issaoui", "man"),
        Student("houssem" , "zitoun" , "man" ,) ,
        Student("hamza", "sdiri", "man" , ) ,
        Student("nour", "bouarada", "womman") ,
        Student("aya", "benrhayem", "woman")
    );
    val adapters = arrayListOf<StudentAdapter>(
        StudentAdapter(studentDatasetCourse),
        StudentAdapter(studentDatasetTp)
    )
    var currentAdapter = adapters[0]
    var filter = currentAdapter.filter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        spinner.adapter = ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,matieres)

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {

                handleClick()

            }
            override fun onNothingSelected(adapterView: AdapterView<*>?) {
            }
        }

        textViewPersonName = findViewById(R.id.textPersonName)
        textViewPersonName.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                filter.filter("$s")
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })

        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity);
            adapter = currentAdapter
        }







    }


    fun handleClick() {

        val duration = Toast.LENGTH_SHORT
        val toastText = spinner.selectedItem.toString()
        Toast.makeText(this, toastText, duration).show()

        currentAdapter = if(toastText == "Cours") {
            adapters[0]

        }else {
            adapters[1]

        }
        filter = currentAdapter.filter
        recyclerView.apply {
            adapter = currentAdapter
        }

    }

}