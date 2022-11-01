package com.example.urgentcheer

import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import net.daum.mf.map.api.MapView
import java.security.MessageDigest

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mapView = MapView(this)
        val kakaoMapView = findViewById<ConstraintLayout>(R.id.kakaoMapView)
        kakaoMapView.addView(mapView)
    }
}