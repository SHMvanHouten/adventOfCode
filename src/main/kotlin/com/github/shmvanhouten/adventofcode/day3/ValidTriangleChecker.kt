package com.github.shmvanhouten.adventofcode.day3

class ValidTriangleChecker {
    fun isTriangleValid(triangle: List<Int>): Boolean {
        return   triangle[0] < (  triangle[1] +   triangle[2])
    }
}