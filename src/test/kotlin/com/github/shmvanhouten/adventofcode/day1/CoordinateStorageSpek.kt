package com.github.shmvanhouten.adventofcode.day1

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it

class CoordinateStorageSpek : Spek({

    describe("CoordinateStorage") {
        given("We want to store the coordinates for the step taken: 1,1 to 2,1") {
            val coordinateStorage = CoordinateStorage()
            coordinateStorage.checkAndAddCoordinates(1, 1)
            val haveCoordinatesBeenVisited: Boolean = coordinateStorage.checkAndAddCoordinates(2, 1)
            it("should tell us the coordinates 2,1 have been visited") {
                assertThat(haveCoordinatesBeenVisited, `is`(false))
            }
            it("should tell us the coordinates 2,3 have not been visited") {
                val haveCoordinatesBeenVisited2: Boolean = coordinateStorage.checkAndAddCoordinates(1,1)
                assertThat(haveCoordinatesBeenVisited2, `is`(true))
            }
        }

    }

})