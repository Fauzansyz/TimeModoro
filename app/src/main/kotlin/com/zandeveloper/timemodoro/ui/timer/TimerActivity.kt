package com.zandeveloper.timemodoro.ui.timer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class TimerActivity : AppCompatActivity(), TimerContract.View {

    private lateinit var binding: ActivityTimerBinding
    private lateinit var presenter: TimerContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTimerBinding.inflate(layoutInflater)
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

    override fun showFinishState() {
        Toast.makeText(this, "Time's up bro 🍅", Toast.LENGTH_SHORT).show()
    }
}