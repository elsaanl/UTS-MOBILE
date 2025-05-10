package com.example.aplikasiuts
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast


class RegisterActivity  : AppCompatActivity() {
    // Deklarasi komponen UI
    private lateinit var ivProfilePic: ImageView
    private lateinit var etFullName: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var etConfirmPassword: EditText
    private lateinit var btnRegister: Button
    private lateinit var tvLogin: TextView

    // Tag untuk Log
    private val TAG = "RegisterActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Mengatur layout yang akan digunakan
        setContentView(R.layout.activity_register)

        // Inisialisasi komponen UI
        ivProfilePic = findViewById(R.id.iv_profile_pic)
        etFullName = findViewById(R.id.et_full_name)
        etEmail = findViewById(R.id.et_email)
        etPassword = findViewById(R.id.et_password)
        etConfirmPassword = findViewById(R.id.et_confirm_password)
        btnRegister = findViewById(R.id.btn_register)
        tvLogin = findViewById(R.id.tv_login)

        // Set click listener untuk gambar profil
        ivProfilePic.setOnClickListener {
            // Di sini bisa ditambahkan kode untuk memilih foto dari galeri
            Toast.makeText(this, "Pilih foto profil", Toast.LENGTH_SHORT).show()
        }

        // Set OnClickListener untuk tombol Register
        btnRegister.setOnClickListener {
            // Mengambil nilai dari input pengguna
            val fullName = etFullName.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()
            val confirmPassword = etConfirmPassword.text.toString().trim()

            // Validasi input
            if (fullName.isEmpty()) {
                etFullName.error = "Nama lengkap harus diisi"
                etFullName.requestFocus()
                return@setOnClickListener
            }

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

            if (password.length < 6) {
                etPassword.error = "Password minimal 6 karakter"
                etPassword.requestFocus()
                return@setOnClickListener
            }

            if (confirmPassword.isEmpty()) {
                etConfirmPassword.error = "Konfirmasi password harus diisi"
                etConfirmPassword.requestFocus()
                return@setOnClickListener
            }

            if (password != confirmPassword) {
                etConfirmPassword.error = "Password tidak cocok"
                etConfirmPassword.requestFocus()
                return@setOnClickListener
            }

            // Logging untuk debugging
            Log.d(TAG, "Register attempt with email: $email")

            // Menampilkan multiple toast sesuai permintaan
            Toast.makeText(this, "Pendaftaran berhasil", Toast.LENGTH_SHORT).show()
            Toast.makeText(this, "Selamat datang, $fullName", Toast.LENGTH_SHORT).show()
            Toast.makeText(this, "Silahkan login dengan email $email", Toast.LENGTH_LONG).show()

            // Logging berhasil
            Log.i(TAG, "Registration successful for user: $email")

            // Pindah ke LoginActivity
            val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Set OnClickListener untuk text Login
        tvLogin.setOnClickListener {
            // Kembali ke LoginActivity
            finish()
        }
    }
}


