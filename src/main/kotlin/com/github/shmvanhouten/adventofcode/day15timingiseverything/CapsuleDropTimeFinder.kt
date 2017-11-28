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

        val discRange = 1..discMachine.discs.size

        for (discPositionCapsuleIsAt in discRange) {
            discMachine = discMachine.addSeconds(1)
            if (discMachine.discs.getValue(discPositionCapsuleIsAt).currentPosition != 0) {
                return false
            }
        }
        return true
    }
}