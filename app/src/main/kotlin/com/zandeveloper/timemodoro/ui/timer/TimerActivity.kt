package com.zandeveloper.timemodoro.ui.timer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import com.zandeveloper.timemodoro.databinding.ActivityTimerBinding

class TimerActivity : AppCompatActivity(), TimerContract.View {

    private var _binding: ActivityTimerBinding? = null
    private val binding: ActivityTimerBinding
        get() = checkNotNull(_binding) { "Activity has been destroyed" }
    private lateinit var presenter: TimerContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityTimerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = TimerPresenter(this)

        binding.btnStart.setOnClickListener {
            presenter.startTimer()
        }

        binding.btnPause.setOnClickListener {
            presenter.pauseTimer()
        }

        binding.btnReset.setOnClickListener {
            presenter.resetTimer()
        }
    }

    override fun updateTimer(time: String) {
        binding.tvTimer.text = time
    }
    
    override fun showPauseState(){
    binding.btnStart.isEnabled = true
    binding.btnPause.isEnabled = false
    }
    
    override fun showStartState() {
    binding.btnStart.isEnabled = false
    binding.btnPause.isEnabled = true
   }

    override fun showFinishState() {
        Toast.makeText(this, "Time's up bro 🍅", Toast.LENGTH_SHORT).show()
    }
}