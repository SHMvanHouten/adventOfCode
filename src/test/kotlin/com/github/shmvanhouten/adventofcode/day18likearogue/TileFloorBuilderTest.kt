package com.github.shmvanhouten.adventofcode.day18likearogue

import com.github.shmvanhouten.adventofcode.day18likearogue.TrapState.*
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

class TileFloorBuilderTest {

    @Test
    fun `it should add a second row of tiles to the first row`() {
        val tileFloorBuilder = TileFloorBuilder()
        val firstRow = ".^^^"
        val tileFloor: TileFloor = tileFloorBuilder.buildFloorFromFirstRow(firstRow, 2)
        assertThat(tileFloor.rows[1].drawRow(), equalTo("^^.^"))
    }

    @Test
    fun `it should add two more rows of tiles to the first row`() {
        val tileFloorBuilder = TileFloorBuilder()
        val firstRow = "..^^."
        val tileFloor: TileFloor = tileFloorBuilder.buildFloorFromFirstRow(firstRow, 3)
        assertThat(tileFloor.rows[1].drawRow(), equalTo(".^^^^"))
        assertThat(tileFloor.rows[2].drawRow(), equalTo("^^..^"))
    }


    @Test
    fun `it should add nine more rows of tiles to the first row`() {
        val tileFloorBuilder = TileFloorBuilder()
        val firstRow = ".^^.^.^^^^"
        val tileFloor: TileFloor = tileFloorBuilder.buildFloorFromFirstRow(firstRow, 10)
        assertThat(tileFloor.rows[5].drawRow(), equalTo("^^..^.^^.."))
        assertThat(tileFloor.rows[9].drawRow(), equalTo("^^.^^^..^^"))
    }



}

private fun TileRow.drawRow(): String {
    val rowDrawer = StringBuilder()
    this.tiles.forEach { if(it.trapState == SAFE) rowDrawer.append('.') else rowDrawer.append('^') }
    return rowDrawer.toString()
}
