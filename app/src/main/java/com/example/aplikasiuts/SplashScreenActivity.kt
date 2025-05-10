package com.example.aplikasiuts
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView

class SplashScreenActivity : AppCompatActivity () {
    // Deklarasi komponen UI
    private lateinit var ivLogo: ImageView
    private lateinit var tvAppName: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Mengatur layout yang akan digunakan
        setContentView(R.layout.activity_splash_screen_xml)

        // Inisialisasi komponen UI
        ivLogo = findViewById(R.id.iv_logo)
        tvAppName = findViewById(R.id.tv_app_name)

        // Menambahkan animasi untuk logo dan nama aplikasi
        ivLogo.startAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_in))
        tvAppName.startAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_in))

        // Menunda navigasi ke LoginActivity selama 3 detik
        Handler(Looper.getMainLooper()).postDelayed({
            // Intent untuk berpindah ke LoginActivity
            val intent = Intent(this@SplashScreenActivity, LoginActivity::class.java)
            startActivity(intent)

            // Menutup SplashScreen Activity agar tidak bisa dikembalikan dengan tombol back
            finish()

        }, 3000)
    }
}