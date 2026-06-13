package com.example.stickertrack

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAddSticker = findViewById<Button>(R.id.btnAddSticker)
        val btnList = findViewById<Button>(R.id.btnList)
        val btnStats = findViewById<Button>(R.id.btnStats)
        val btnShare = findViewById<Button>(R.id.btnShare)

        btnAddSticker.setOnClickListener {

            val intent = Intent(this, AddStickerActivity::class.java)
            startActivity(intent)

        }

        btnList.setOnClickListener {

            val intent = Intent(this, StickerListActivity::class.java)
            startActivity(intent)

        }

        btnStats.setOnClickListener {

            val intent = Intent(this, StatsActivity::class.java)
            startActivity(intent)
        }

        btnShare.setOnClickListener {

            val shareIntent = Intent(Intent.ACTION_SEND)

            shareIntent.type = "text/plain"

            shareIntent.putExtra(
                Intent.EXTRA_TEXT,
                "Estou usando o StickerTrack para gerenciar minha coleção de figurinhas! ⚽"
            )

            startActivity(
                Intent.createChooser(
                    shareIntent,
                    "Compartilhar via"
                )
            )

        }
    }
}
