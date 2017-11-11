package com.github.shmvanhouten.adventofcode.day3

class ValidTriangleCounter(private val validTriangleChecker: ValidTriangleChecker = ValidTriangleChecker()) {

    fun countValidTriangles(inputTrianglesString: String): Int {

        val trianglesList = formatInputStringToList(inputTrianglesString)
        return trianglesList.filter { validTriangleChecker.isTriangleValid(formatToTriangleWithDescendingValues(it)) }.size
    }

    fun countValidTrianglesFromVerticalInput(inputTrianglesString: String): Int {

        val inputLines = formatInputStringToList(inputTrianglesString)

        var validTriangleCount = 0

        val tempTriangles = listOf<MutableList<Int>>(mutableListOf(), mutableListOf(), mutableListOf())

        for (inputLine in inputLines) {
            inputLine.trimStart().split("  ").mapIndexed { index, side -> tempTriangles[index].add(side.toInt()) }

            if (tempTriangles[2].size == 3) {
                validTriangleCount += tempTriangles.filter { validTriangleChecker.isTriangleValid(it.sortedDescending()) }.size
                tempTriangles.map { it.clear() }
            }
        }
        return validTriangleCount
    }

    private fun formatInputStringToList(triangles: String): List<String> =
            triangles.replace("    ", "  ").replace("   ", "  ").split("\n")


    private fun formatToTriangleWithDescendingValues(triangleString: String) =
            triangleString.trimStart().split("  ").map { it.toInt() }.sortedDescending()
}