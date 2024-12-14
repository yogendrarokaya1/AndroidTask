package com.example.androidtask

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvWelcome: TextView = findViewById(R.id.tvWelcome)
        val tvEmail: TextView = findViewById(R.id.tvEmail)
        val tvGender: TextView = findViewById(R.id.tvGender)
        val tvCountry: TextView = findViewById(R.id.tvCountry)
        val tvCity: TextView = findViewById(R.id.tvCity)
        val imageViewResult: ImageView = findViewById(R.id.imageViewResult)

        val fullName = intent.getStringExtra("fullName")
        val email = intent.getStringExtra("email")
        val gender = intent.getStringExtra("gender")
        val country = intent.getStringExtra("country")
        val city = intent.getStringExtra("city")
        val imageResId = intent.getIntExtra("imageResId", R.drawable.profile)

        tvWelcome.text = "Welcome, $fullName"
        tvEmail.text = "Email: $email"
        tvGender.text = "Gender: $gender"
        tvCountry.text = "Country: $country"
        tvCity.text = "City: $city"
        imageViewResult.setImageResource(imageResId)
    }
}
