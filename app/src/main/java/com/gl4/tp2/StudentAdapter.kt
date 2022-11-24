package com.gl4.tp2

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class StudentAdapter(private val dataSet: ArrayList<Student>):
    RecyclerView.Adapter<StudentAdapter.ViewHolder>() ,Filterable
    {

        var dataFilterList = ArrayList<Student>()
        init {
            dataFilterList = dataSet
        }
        /**
         * Provide a reference to the type of views that you are using
         * (custom ViewHolder).
         */
        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val textView: TextView
            val imageView :ImageView
            val absentCheckBox : CheckBox
            val presentCheckBox :CheckBox

            init {
                // Define click listener for the ViewHolder's View.
                textView = view.findViewById(R.id.fullName_text)
                imageView = view.findViewById(R.id.gender_image)
                absentCheckBox = view.findViewById(R.id.checkBoxAbsent)
                presentCheckBox = view.findViewById(R.id.checkBoxPresent)

            }
        }

        // Create new views (invoked by the layout manager)
        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
            // Create a new view, which defines the UI of the list item
            val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.student_item, viewGroup, false)

            return ViewHolder(view)
        }

        // Replace the contents of a view (invoked by the layout manager)
        override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
            val currentStudent :Student = dataFilterList[position]
            // Get element from your dataset at this position and replace the
            // contents of the view with that element
            viewHolder.textView.text =
                "${currentStudent.firstName}  ${currentStudent.lastName}"
            if (currentStudent.gender == "woman") {
                viewHolder.imageView.setImageResource(R.drawable.woman_photo)
            }
            val checkBoxPresent = viewHolder.presentCheckBox
            val checkBoxAbsent = viewHolder.absentCheckBox

            checkBoxAbsent.setOnClickListener{
                currentStudent.status = "absent"
                checkBoxAbsent.isChecked = true
                checkBoxPresent.isChecked = false

            }

            checkBoxPresent.setOnClickListener{
                currentStudent.status = "present"
                checkBoxAbsent.isChecked = false
                checkBoxPresent.isChecked = true

            }

            checkBoxPresent.isChecked = currentStudent.status == "present"
            checkBoxAbsent.isChecked = currentStudent.status == "absent"

        }

        // Return the size of your dataset (invoked by the layout manager)
        override fun getItemCount() = dataFilterList.size
        override fun getFilter(): Filter {
            return object : Filter(){
                override fun performFiltering(constraint: CharSequence?): FilterResults {
                    var charSearch = constraint.toString()

                    if (charSearch.isEmpty()) {
                        dataFilterList = dataSet
                    } else {
                        var parts : List<String>  = charSearch.split(":")
                        val resultList = ArrayList<Student>()
                        charSearch = parts[1]
                        if(parts[0]=="firstName") {
                            for (student in dataSet) {
                                if (student.firstName.lowercase(Locale.ROOT)
                                        .contains(charSearch.lowercase(Locale.ROOT))
                                ) {
                                    resultList.add(student)
                                }
                            }

                        }else if(parts[0]=="status") {
                            for(student in dataSet){
                                if(student.status==charSearch){
                                    resultList.add(student)
                                }


                            }
                        }
                        //Log.d("array" , resultList.toString())
                        dataFilterList = resultList
                    }
                    val filterResults = FilterResults()
                    filterResults.values = dataFilterList
                    return filterResults
                }

                override fun publishResults(constraint: CharSequence?, results: FilterResults?) {

                        dataFilterList = if (results?.values == null) {
                            ArrayList()
                        }else{
                            results?.values as ArrayList<Student>
                        }
                        notifyDataSetChanged()


                }

            }
        }
    }

