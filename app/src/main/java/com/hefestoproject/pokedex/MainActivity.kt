package com.hefestoproject.pokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun shouldDisplayEmptyView(isEmpty : Boolean){
        ivFootprint.visibility = View.GONE
        tvMessage.visibility = View.GONE
    }
}