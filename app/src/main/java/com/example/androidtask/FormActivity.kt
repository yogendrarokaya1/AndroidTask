package com.example.androidtask

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class FormActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        val etFullName: EditText = findViewById(R.id.etFullName)
        val etEmail: EditText = findViewById(R.id.etEmail)
        val rbMale: RadioButton = findViewById(R.id.rbMale)
        val rbFemale: RadioButton = findViewById(R.id.rbFemale)
        val spinnerCountry: Spinner = findViewById(R.id.spinnerCountry)
        val autoCompleteCity: AutoCompleteTextView = findViewById(R.id.autoCompleteCity)
        val checkBoxTerms: CheckBox = findViewById(R.id.checkBoxTerms)
        val btnSubmit: Button = findViewById(R.id.btnSubmit)

        // Populate country dropdown
        val countries = arrayOf("Nepal", "Canada", "UK", "India", "USA")
        val countryAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, countries)
        spinnerCountry.adapter = countryAdapter

        // Populate city autocomplete
        val cities = arrayOf("Kathmandu", "Bhaktapur", "Lalitpur", "Bhairahawa", "Lamahi")
        val cityAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, cities)
        autoCompleteCity.setAdapter(cityAdapter)

        btnSubmit.setOnClickListener {
            // Validate terms checkbox
            if (!checkBoxTerms.isChecked) {
                Toast.makeText(this, "Please agree to terms and conditions", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Collect form data
            val fullName = etFullName.text.toString()
            val email = etEmail.text.toString()
            val gender = if (rbMale.isChecked) "Male" else "Female"
            val country = spinnerCountry.selectedItem.toString()
            val city = autoCompleteCity.text.toString()

            // Navigate to ResultActivity
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("fullName", fullName)
            intent.putExtra("email", email)
            intent.putExtra("gender", gender)
            intent.putExtra("country", country)
            intent.putExtra("city", city)

            intent.putExtra("imageResId", R.drawable.profile)
            startActivity(intent)
        }
    }
}
