package com.intrast.depi_s1

import androidx.lifecycle.ViewModel

class ScoreViewModel : ViewModel() {
    // data , state
    var teamAScore = 0
    var teamBScore = 0

    // actions
    fun incrementScore(isTeamA: Boolean) {
        if (isTeamA) {
            teamAScore++
        } else {
            teamBScore++
        }
    }

    fun resetScore(){
        teamAScore = 0
        teamBScore = 0
    }
}