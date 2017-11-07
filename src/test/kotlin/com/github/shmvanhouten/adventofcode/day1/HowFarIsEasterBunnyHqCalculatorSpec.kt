package com.github.shmvanhouten.adventofcode.day1

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it


class HowFarIsEasterBunnyHqCalculatorSpec : Spek({
    describe("a calculator to calculate how far the EasterBunny's hq is"){
        val calculator = HowFarIsEasterBunnyHqCalculator()

        given("We get the instructions: go 1 step to the right") {
            val distance: Int = calculator.calculateDistanceToHq("R1")
            it("should calculate a distance of 1"){
                assertThat(distance, equalTo(1))
            }
        }
    }

})