package com.github.shmvanhouten.adventofcode.day15timingiseverything

class CapsuleDropTimeFinder {
    fun findTimeToPressButton(discMachine: DiscMachine): Int {
        var timeToStart = 0
        while (true){
            if(runSimulation(discMachine, timeToStart)) return timeToStart
            timeToStart++
        }
    }

    private fun runSimulation(originalStateMachine: DiscMachine, timeToStart: Int): Boolean {
        var discMachine = originalStateMachine.addSeconds(timeToStart)

        val timeRange = 1..discMachine.discs.size

        for (time in timeRange) {
            discMachine = discMachine.addSecond()
            if (discMachine.discs.getValue(time).currentPosition != 0) {
                return false
            }
        }
        return true
    }
}