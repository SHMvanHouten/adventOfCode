package com.github.shmvanhouten.adventofcode.day3

class ValidTriangleCounter (private val validTriangleChecker: ValidTriangleChecker = ValidTriangleChecker()){
    fun countValidTriangles(triangles: String): Int {
        return triangles.trimStart().split("\n").filter { validTriangleChecker.isTriangleValid(it) }.size
    }

}