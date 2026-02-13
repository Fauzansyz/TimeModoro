package com.zandeveloper.timemodoro.ui.timer

interface TimerContract {

    interface View {
      fun updateTimer(time: String)
      fun showStartState()
      fun showPauseState()
      fun showFinishState()
      fun showResetState()
}
    
    interface Presenter {
      fun startTimer()
      fun pauseTimer()
      fun resetTimer()
      fun detach()
}

}