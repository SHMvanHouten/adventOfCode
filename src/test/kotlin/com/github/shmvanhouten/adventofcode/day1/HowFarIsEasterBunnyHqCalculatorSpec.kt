package com.github.shmvanhouten.adventofcode.day1

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it


class HowFarIsEasterBunnyHqCalculatorSpec : Spek({
    describe("a calculator to calculate how far the EasterBunny's hq is") {
        val calculator = HowFarIsEasterBunnyHqCalculator()

        given("We get the instructions: go 1 step to the right") {
            val distance: Int = calculator.calculateDistanceToHq("R1")
            it("should calculate a distance of 1") {
                assertThat(distance, equalTo(1))
            }
        }

        given("We get the instructions: go 2 steps to the right") {
            val distance: Int = calculator.calculateDistanceToHq("R2")
            it("should calculate a distance of 2") {
                assertThat(distance, equalTo(2))
            }
        }

        given("We get the instructions: go 1 step to the right, and another step to the right") {
            val distance: Int = calculator.calculateDistanceToHq("R1, R1")
            it("should calculate a distance of 2") {
                assertThat(distance, equalTo(2))
            }
        }
    }

})