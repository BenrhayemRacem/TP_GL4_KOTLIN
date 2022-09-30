package com.gl4.tp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var txtEmail : EditText
    lateinit var txtPassword : EditText
    lateinit var btnLogin : Button

    lateinit var email: String
    lateinit var password : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtEmail = findViewById(R.id.email_login)
        txtPassword = findViewById(R.id.password)
        btnLogin = findViewById(R.id.buttonLogin)
         email = txtEmail.text.toString()
         password = txtPassword.text.toString()
        btnLogin.setOnClickListener{view->
            click(view)
        }
    }

     fun click(view: View) {
            val duration = Toast.LENGTH_SHORT
            Log.v(password,email)
         email = txtEmail.text.toString()
         password = txtPassword.text.toString()
            if(! email.equals("gl4@insat.tn") || !password.equals("insat2022")){
                var toastText = "email ou mot de passe incorrecte"

                 Toast.makeText(this, toastText, duration).show()


            } else {
                var toastText = "bon couple login/mdp"


                 Toast.makeText(this, toastText, duration).show()

                val intent = Intent(view.context,WelcomeActivity::class.java)
                intent.putExtra("email",email)
                startActivity(intent)



            }


    }

}