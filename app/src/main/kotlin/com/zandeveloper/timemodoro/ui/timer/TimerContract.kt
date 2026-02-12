package com.zandeveloper.timemodoro.ui.timer

interface TimerContract {

    interface View {
      fun updateTimer(time: String)
      fun showStartState()
      fun showPauseState()
      fun showFinishState()
}
    
    interface Presenter {
      fun startTimer()
      fun pauseTimer()
      fun resetTimer()
}

}