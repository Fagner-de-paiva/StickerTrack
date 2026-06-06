package com.example.stickertrack

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.stickertrack.fragments.StatsFragment

class StatsActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_stats)

        supportFragmentManager.beginTransaction()
            .replace(
                R.id.fragmentContainer,
                StatsFragment()
            )
            .commit()

    }


}
