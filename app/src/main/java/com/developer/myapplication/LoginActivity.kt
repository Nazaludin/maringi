package com.developer.myapplication

import android.content.Intent
import android.content.SharedPreferences
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject


class LoginActivity : AppCompatActivity() {
    private lateinit var buttonMasuk: Button
    private lateinit var buttonBack: ImageButton
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor
    private lateinit var textEmail :EditText;
    private lateinit var textPassword :EditText;
    val url = "https://itgercep.xyz/user-email"



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        setContentView(R.layout.login_page)
        textEmail = findViewById<EditText>(R.id.editText_email_login)
        textPassword = findViewById<EditText>(R.id.editText_password_login)

        sharedPreferences = getSharedPreferences("session-data", MODE_PRIVATE)
        editor= sharedPreferences.edit();


        buttonMasuk = findViewById<Button>(R.id.button_masuk_login)
        buttonBack = findViewById<ImageButton>(R.id.imageButton_back_login)

        buttonMasuk.setOnClickListener {
            val queue = Volley.newRequestQueue(this)

            val sr: StringRequest = object : StringRequest(
                Method.POST, url,
                Response.Listener { response ->
                        try {
                            Log.v("COBA", response);
                            val responseArray = JSONArray(response)
                            val jsonObject: JSONObject = responseArray.getJSONObject(0)
                            Log.e("ResponseObject", jsonObject.getString("id_user"));

                            val  userId : String   = jsonObject.getString("id_user");
                            Toast.makeText(applicationContext, userId, Toast.LENGTH_LONG).show()

                            editor.putString("email", textEmail.text.toString())
                            editor.putString("id_user", jsonObject.getString("id_user"))
                            editor.putString("alamat", jsonObject.getString("alamat"))
                            editor.putString("nama", jsonObject.getString("nama"))
                            editor.putBoolean("is_login", true)
                            editor.apply()

                            Toast.makeText(applicationContext, "Login Berhasil", Toast.LENGTH_LONG).show()
                            startActivity(Intent(this@LoginActivity, MainMenuActivity::class.java))

                        } catch (e:JSONException) {
                            Toast.makeText(applicationContext, "Program Error", Toast.LENGTH_LONG).show()
                            e.printStackTrace();

                        }
                },
                Response.ErrorListener { error ->
                    Toast.makeText(applicationContext, "ERROR: %s".format(error.toString()), Toast.LENGTH_SHORT).show()
                }) {
                override fun getParams(): Map<String, String> {
                    val params: MutableMap<String, String> = HashMap()
                    params["email"]     = textEmail.text.toString()
                    return params
                }
            }
            // Add the request to the RequestQueue.
            queue.add(sr)


//            Toast.makeText(applicationContext, "Perikasa Akun atau Akun belum terdaftar", Toast.LENGTH_SHORT).show()
//            editor.putString("email", textEmail.text.toString())
//            editor.putBoolean("is_login", true)
//            editor.apply()

//            startActivity(Intent(this@LoginActivity, MainMenuActivity::class.java))
        }
        buttonBack.setOnClickListener {

            startActivity(Intent(this@LoginActivity, LandingPageActivity::class.java))
        }
    }


}