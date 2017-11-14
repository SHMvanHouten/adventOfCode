package com.github.shmvanhouten.adventofcode.day8

class ScreenDrawer (private val screen: Screen) {
    private val RECT: String = "rect"
    private val ROTATE: String = "rotate"
    private val COLUMN: String = "column"
    private val ROW: String = "row"

    fun followInstructions(instructions: String) {
        val instructionList = instructions.split("\n")
        instructionList.forEach { drawOnScreen(it) }
    }

    fun drawOnScreen(instruction: String) {
        val instructionParts = instruction.split(" ")
        when(instructionParts[0]){
            RECT -> drawRectangle(instructionParts[1])
            ROTATE -> when(instructionParts[1]){
                COLUMN -> rotateColumn(instructionParts[2], instructionParts[4])
                ROW -> rotateRow(instructionParts[2], instructionParts[4])
            }
        }
    }

    private fun rotateRow(yEquals: String, amountToMove: String) {
        val y = yEquals.substring(2).toInt()
        screen.rotateRowByAmount(y, amountToMove.toInt())
    }

    private fun rotateColumn(xEquals: String, amountToMove: String) {
        val x = xEquals.substring(2).toInt()
        screen.rotateColumnByAmount(x, amountToMove.toInt())
    }

    private fun drawRectangle(widthAndHeight: String) {
        val widthAndHeightSplit = widthAndHeight.split("x")
        screen.turnOnPixelsTopLeft(widthAndHeightSplit[0].toInt(),widthAndHeightSplit[1].toInt())
    }

}

