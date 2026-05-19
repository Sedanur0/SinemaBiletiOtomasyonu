package com.example.sinemabiletiotomasyonu

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Tasarımdaki butonları ID'leri ile koda bağlıyoruz
        val btnAyla = findViewById<Button>(R.id.btnAyla)
        val btnBatman = findViewById<Button>(R.id.btnBatman)
        val btnShrek = findViewById<Button>(R.id.btnShrek)
        val btnThor = findViewById<Button>(R.id.btnThor)

        // Koltuk seçimi sayfasına gitmek için yönlendirici (Intent) oluşturuyoruz
        val intent = Intent(this, SeatSelectionActivity::class.java)

        // Hangi "Bilet Al" butonuna basılırsa basılsın koltuk seçimine yönlendiriyoruz
        btnAyla.setOnClickListener {
            startActivity(intent)
        }

        btnBatman.setOnClickListener {
            startActivity(intent)
        }

        btnShrek.setOnClickListener {
            startActivity(intent)
        }

        btnThor.setOnClickListener {
            startActivity(intent)
        }
    }
}