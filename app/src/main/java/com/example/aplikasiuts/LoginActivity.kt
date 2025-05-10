package com.example.aplikasiuts
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity () {
    // Deklarasi komponen UI
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var tvRegister: TextView

    // Tag untuk Log
    private val TAG = "LoginActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Mengatur layout yang akan digunakan
        setContentView(R.layout.activity_login)

        // Inisialisasi komponen UI
        etEmail = findViewById(R.id.et_email)
        etPassword = findViewById(R.id.et_password)
        btnLogin = findViewById(R.id.btn_login)
        tvRegister = findViewById(R.id.tv_register)

        // Set OnClickListener untuk tombol Login
        btnLogin.setOnClickListener {
            // Mengambil nilai dari input pengguna
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            // Validasi input
            if (email.isEmpty()) {
                etEmail.error = "Email harus diisi"
                etEmail.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                etPassword.error = "Password harus diisi"
                etPassword.requestFocus()
                return@setOnClickListener
            }

            // Logging untuk debugging
            Log.d(TAG, "Login attempt with email: $email")

            // Simulasi proses login sederhana
            if (email == "user@example.com" && password == "password") {
                // Login berhasil, navigasi ke ListChatActivity
                Log.i(TAG, "Login successful for user: $email")
                Toast.makeText(this, "Login berhasil", Toast.LENGTH_SHORT).show()

                val intent = Intent(this@LoginActivity, ListChatActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                // Login gagal
                Log.e(TAG, "Login failed for user: $email")
                Toast.makeText(this, "Email atau password salah", Toast.LENGTH_SHORT).show()
            }
        }


        // Set OnClickListener untuk text Register
        tvRegister.setOnClickListener {
            // Navigasi ke RegisterActivity
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}