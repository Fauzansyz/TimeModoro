package com.zandeveloper.timemodoro.ui.timer
import com.zandeveloper.timemodoro.ui.timer.TimerContract
import android.os.CountDownTimer

class TimerPresenter(
    private val view: TimerContract.View
) : TimerContract.Presenter {

    private var timeLeft = 25 * 60
    private var timer: CountDownTimer? = null

    override fun startTimer() {
        timer = object : CountDownTimer(timeLeft * 1000L, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timeLeft = (millisUntilFinished / 1000).toInt()
                view.updateTimer(formatTime(timeLeft))
            }

            override fun onFinish() {
                view.showFinishState()
            }
        }.start()
    }

    override fun pauseTimer() {
        timer?.cancel()
    }

    override fun resetTimer() {
        timer?.cancel()
        timeLeft = 25 * 60
        view.updateTimer("25:00")
    }

    private fun formatTime(sec: Int): String {
        val m = sec / 60
        val s = sec % 60
        return String.format("%02d:%02d", m, s)
    }
}