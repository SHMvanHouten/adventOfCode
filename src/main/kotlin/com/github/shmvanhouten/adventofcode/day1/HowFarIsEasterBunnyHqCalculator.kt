package com.github.shmvanhouten.adventofcode.day1


class HowFarIsEasterBunnyHqCalculator(){
    fun calculateDistanceToHq(instructions: String): Int {
        val instructionsList: List<String> = instructions.split(", ")
        return instructionsList.sumBy { it.substring(1).toInt() }
    }

}