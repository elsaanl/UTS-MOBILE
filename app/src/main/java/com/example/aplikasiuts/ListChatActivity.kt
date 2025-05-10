package com.example.aplikasiuts
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar


class ListChatActivity : AppCompatActivity() {
    // Deklarasi komponen UI
    private lateinit var listView: ListView
    private lateinit var toolbar: Toolbar

    // Tag untuk Log
    private val TAG = "ListChatActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Mengatur layout yang akan digunakan
        setContentView(R.layout.activity_list_chat)

        // Inisialisasi toolbar
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "List Chat"

        // Inisialisasi ListView
        listView = findViewById(R.id.lv_chats)



        }
    }