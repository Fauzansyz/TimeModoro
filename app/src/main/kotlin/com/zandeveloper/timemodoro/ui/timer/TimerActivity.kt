package com.zandeveloper.timemodoro.ui.timer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import com.zandeveloper.timemodoro.R
import com.zandeveloper.timemodoro.databinding.ActivityTimerBinding

class TimerActivity : AppCompatActivity(), TimerContract.View {

    private var _binding: ActivityTimerBinding? = null
    private val binding: ActivityTimerBinding
        get() = checkNotNull(_binding) { "Activity has been destroyed" }
    private lateinit var presenter: TimerContract.Presenter
    private val backgrounds = listOf(
       R.drawable.bg_afternoon_mountains,
       R.drawable.bg_night_mountains,
       R.drawable.bg_night_forest,
       R.drawable.bg_default
)

    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityTimerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = TimerPresenter(this)
        
        val randomImage = backgrounds.random()
        
        binding.bgImage.animate()
        .alpha(0f)
        .setDuration(300)
        .withEndAction {
        binding.bgImage.setImageResource(randomImage)
        binding.bgImage.animate().alpha(1f).setDuration(300)
    }

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
    
    override fun showResetState(){
    binding.btnStart.isEnabled = true
    binding.btnPause.isEnabled = true
    }
    
    override fun onDestroy(){
      super.onDestroy()
      presenter.detach()
    }
    
    override fun showStartState() {
    binding.btnStart.isEnabled = false
    binding.btnPause.isEnabled = true
   }

    override fun showFinishState() {
        Toast.makeText(this, "Time's up bro 🍅", Toast.LENGTH_SHORT).show()
    }
}