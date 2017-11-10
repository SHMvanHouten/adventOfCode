package com.github.shmvanhouten.adventofcode.day3

class ValidTriangleCounter (private val validTriangleChecker: ValidTriangleChecker = ValidTriangleChecker()){
    fun countValidTriangles(triangles: String): Int {
        val trianglesReformatted = reformatTriangleSideString(triangles)
        return trianglesReformatted.trimStart().split("\n").filter { validTriangleChecker.isTriangleValid(it.trimStart().split("  ").map{ it.toInt() }.sortedDescending()) }.size
    }

    fun countValidTrianglesFromVerticalInput(triangles: String): Int {
        val trianglesReformatted = reformatTriangleSideString(triangles)
        val completeSidesList = trianglesReformatted.trimStart().splitToSequence("    ","  ","  ", "\n")
        var firstTempTriangle = mutableListOf<Int>()
        var secondTempTriangle = mutableListOf<Int>()
        var thirdTempTriangle = mutableListOf<Int>()
        val finalTriangleList = mutableListOf<List<Int>>()
        var counter = 0
        for (side in completeSidesList) {
            when(counter){
                0,3,6 -> {
                    firstTempTriangle.add(side.toInt())
                    counter++
                }
                1,4,7 -> {
                    secondTempTriangle.add(side.toInt())
                    counter++
                }
                2,5 -> {
                    thirdTempTriangle.add(side.toInt())
                    counter++
                }
                8 -> {
                    thirdTempTriangle.add(side.toInt())
                    finalTriangleList.add(firstTempTriangle.sortedDescending())
                    finalTriangleList.add(secondTempTriangle.sortedDescending())
                    finalTriangleList.add(thirdTempTriangle.sortedDescending())
                    firstTempTriangle.clear()
                    secondTempTriangle.clear()
                    thirdTempTriangle.clear()
                    counter = 0
                }
            }
            completeSidesList.drop(1)
        }
        return finalTriangleList.filter { validTriangleChecker.isTriangleValid(it) }.size
    }

    private fun reformatTriangleSideString(triangles: String) = triangles.replace("    ", "  ").replace("   ", "  ")


}