package com.example.sinemabiletiotomasyonu

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SummaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

        val btnAnaSayfa = findViewById<Button>(R.id.btnAnaSayfa)
        val txtBiletDetay = findViewById<TextView>(R.id.txtBiletDetay)

        // Yan sayfadan gönderilen koltuk isimlerini yakalıyoruz
        val gelenKoltuklar = intent.getStringExtra("SECILEN_KOLTUKLAR")

        // Ekrandaki yazıyı dinamik olarak güncelliyoruz
        txtBiletDetay.text = "Film: Seçilen Film\nTarih: 20 Mayıs 2026\nSaat: 20:00\nKoltuk: $gelenKoltuklar"

        btnAnaSayfa.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }
    }
}