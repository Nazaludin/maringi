package com.developer.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley


class RegisActivity : AppCompatActivity() {
    private lateinit var buttonMasuk: Button
    private lateinit var buttonBack: ImageButton
    val url = "https://itgercep.xyz/MaringiUser"
    private lateinit var textNama :EditText;
    private lateinit var textEmail :EditText;
    private lateinit var textPassword :EditText;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        setContentView(R.layout.registrasi_page)

        buttonMasuk = findViewById<Button>(R.id.button_daftar_regis)
        buttonBack = findViewById<ImageButton>(R.id.imageButton_back_regis)

        textNama = findViewById<EditText>(R.id.editTextNama)
        textEmail = findViewById<EditText>(R.id.editTextEmailAddress)
        textPassword = findViewById<EditText>(R.id.editTextPassword)

        buttonMasuk.setOnClickListener {

            // Instantiate the RequestQueue.
            val queue = Volley.newRequestQueue(this)



            val sr: StringRequest = object : StringRequest(Method.POST, url,
                Response.Listener { response ->
//                    Toast.makeText(applicationContext, "Success", Toast.LENGTH_SHORT).show()
                    //your response
                    Toast.makeText(applicationContext, textNama.text.toString(), Toast.LENGTH_SHORT).show()
                    // Activity
                    startActivity(Intent(this@RegisActivity, MainMenuActivity::class.java))
                },
                Response.ErrorListener { error ->
                    //your error
                    Toast.makeText(applicationContext, "ERROR: %s".format(error.toString()), Toast.LENGTH_SHORT).show()
                }) {
                override fun getParams(): Map<String, String> {
//                    val params = HashMap<String, String>()
//                    params["nama"]      = textNama.text.toString()
//                    params["email"]     = textEmail.text.toString()
//                    params["password"]  = textPassword.text.toString()

                    val params: MutableMap<String, String> = HashMap()
                    params["nama"]      = textNama.text.toString()
                    params["email"]     = textEmail.text.toString()
                    params["password"]  = textPassword.text.toString()
                    return params
                }

//                @Throws(AuthFailureError::class)
//                override fun getHeaders(): Map<String, String> {
//                    val params: MutableMap<String, String> = HashMap()
//                    params["Content-Type"] = "application/x-www-form-urlencoded"
//                    return params
//                }
            }
            // Add the request to the RequestQueue.
           queue.add(sr)


        }
        buttonBack.setOnClickListener {
            startActivity(Intent(this@RegisActivity, LandingPageActivity::class.java))
        }






    }


}