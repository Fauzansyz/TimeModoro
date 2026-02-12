package com.zandeveloper.timemodoro

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zandeveloper.timemodoro.databinding.ActivityMainBinding
import android.content.Intent
import android.os.Handler
import android.os.Looper
import com.zandeveloper.timemodoro.ui.timer.TimerActivity

class MainActivity : AppCompatActivity() {
    
    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding
        get() = checkNotNull(_binding) { "Activity has been destroyed" }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this@MainActivity, TimerActivity::class.java))
            finish() // biar gak bisa balik ke splash
        }, 2000)
        
    }
    
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}