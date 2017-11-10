package com.github.shmvanhouten.adventofcode.day3

class ValidTriangleChecker {
    fun isTriangleValid(triangle: String): Boolean {
        val triangleSides = triangle.trimStart().split("  ").map{ it.toInt() }.sortedDescending()
        return triangleSides[0] < (triangleSides[1] + triangleSides[2])
    }
}