package com.github.shmvanhouten.adventofcode.day8

import com.github.shmvanhouten.adventofcode.day8.GridComponentType.*
import com.github.shmvanhouten.adventofcode.day8.InstructionType.*

class ScreenDrawer (private val screen: Screen) {

    fun followInstructions(instructions: String) {
        val instructionList = instructions.split("\n")
        instructionList.forEach { drawOnScreen(it) }
    }

    fun drawOnScreen(instruction: String) {
        val instructionParts = instruction.split(" ")
        when(getInstructionTypeFromRawInstruction(instructionParts[0])){
            DRAW_RECTANGLE -> drawRectangle(instructionParts[1])
            ROTATE -> when(getGridComponentTypeFromRawInstruction(instructionParts[1])){
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

enum class InstructionType(val rawInstruction: String) {
    DRAW_RECTANGLE("rect"),
    ROTATE("rotate")
}

enum class GridComponentType(val rawInstruction: String){
    COLUMN("column"),
    ROW("row")
}

private fun getInstructionTypeFromRawInstruction(rawInstruction: String): InstructionType{
    //assuming raw instructions are always formatted correctly
    return InstructionType.values().find { it.rawInstruction == rawInstruction }!!
}
private fun getGridComponentTypeFromRawInstruction(rawInstruction: String): GridComponentType{
    //assuming raw instructions are always formatted correctly
    return GridComponentType.values().find { it.rawInstruction == rawInstruction }!!
}
