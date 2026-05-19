package com.example.sinemabiletiotomasyonu

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.GridLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SeatSelectionActivity : AppCompatActivity() {


    private val secilenKoltuklar = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seat_selection)

        val btnKoltukOnayla = findViewById<Button>(R.id.btnKoltukOnayla)
        val gridLayout = btnKoltukOnayla.parent as android.view.ViewGroup
        val koltukGrid = gridLayout.getChildAt(1) as GridLayout


        for (i in 0 until koltukGrid.childCount) {
            val koltuk = koltukGrid.getChildAt(i) as Button
            val koltukAdi = koltuk.text.toString()


            koltuk.setBackgroundColor(Color.parseColor("#4CAF50"))
            koltuk.isEnabled = true

            koltuk.setOnClickListener {

                if (secilenKoltuklar.contains(koltukAdi)) {
                    koltuk.setBackgroundColor(Color.parseColor("#4CAF50")) // Yeşil
                    secilenKoltuklar.remove(koltukAdi)
                }
                // Koltuk boşsa seç (Sarı yap)
                else {
                    koltuk.setBackgroundColor(Color.parseColor("#FFEB3B")) // Sarı
                    koltuk.setTextColor(Color.BLACK)
                    secilenKoltuklar.add(koltukAdi)
                }
            }
        }


        btnKoltukOnayla.setOnClickListener {
            if (secilenKoltuklar.isEmpty()) {
                Toast.makeText(this, "Lütfen en az bir koltuk seçiniz!", Toast.LENGTH_SHORT).show()
            } else {
                // Seçilen koltukları metne dönüştürüp özet ekranına yolluyoruz
                val koltuklarMetni = secilenKoltuklar.joinToString(", ")
                val intent = Intent(this, SummaryActivity::class.java)
                intent.putExtra("SECILEN_KOLTUKLAR", koltuklarMetni)
                startActivity(intent)
            }
        }
    }
}