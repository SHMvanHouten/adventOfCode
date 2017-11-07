package com.github.shmvanhouten.adventofcode.day1

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it


class HowFarIsEasterBunnyHqCalculatorSpec : Spek({
    describe("a calculator to calculate how far the EasterBunny's hq is") {



        given("We get the instructions: go 1 step to the right") {
            val calculator = HowFarIsEasterBunnyHqCalculator()
            val distance: Int = calculator.calculateDistanceToHq("R1")
            it("should calculate a distance of 1") {
                assertThat(distance, equalTo(1))
            }
        }

        given("We get the instructions: go 2 steps to the right") {
            val calculator = HowFarIsEasterBunnyHqCalculator()
            val distance: Int = calculator.calculateDistanceToHq("R2")
            it("should calculate a distance of 2") {
                assertThat(distance, equalTo(2))
            }
        }

        given("We get the instructions: go 1 step to the right, and another step to the right") {
            val calculator = HowFarIsEasterBunnyHqCalculator()
            val distance: Int = calculator.calculateDistanceToHq("R1, R1")
            it("should calculate a distance of 2") {
                assertThat(distance, equalTo(2))
            }
        }

        given("We get the instructions: go 1 step to the right, and another step to the right") {
            val calculator = HowFarIsEasterBunnyHqCalculator()
            val distance: Int = calculator.calculateDistanceToHq("L2, L2")
            it("should calculate a distance of 4") {
                assertThat(distance, equalTo(4))
            }
        }

        given("We get the instructions: go 1 step to the right, and another step to the right, and another") {
            val calculator = HowFarIsEasterBunnyHqCalculator()
            val distance: Int = calculator.calculateDistanceToHq("R1, R1, R1")
            it("should calculate a distance of 1") {
                assertThat(distance, equalTo(1))
            }
        }

        given("We get the instructions from the first example of the challenge: R2, R2, R2") {
            val calculator = HowFarIsEasterBunnyHqCalculator()
            val distance: Int = calculator.calculateDistanceToHq("R2, R2, R2")
            it("should calculate a distance of 2") {
                assertThat(distance, equalTo(2))
            }
        }

        given("We get the instructions from the second example of the challenge : R5, L5, R5, R3") {
            val calculator = HowFarIsEasterBunnyHqCalculator()
            val distance: Int = calculator.calculateDistanceToHq("R5, L5, R5, R3")
            it("should calculate a distance of 2") {
                assertThat(distance, equalTo(12))
            }
        }

        given("We get the instructions from the actual challenge") {
            val calculator = HowFarIsEasterBunnyHqCalculator()
            val distance: Int = calculator.calculateDistanceToHq("L5, R1, L5, L1, R5, R1, R1, L4, L1, L3, R2, R4, L4, L1, L1, R2, R4, R3, L1, R4, L4, L5, L4, R4, L5, R1, R5, L2, R1, R3, L2, L4, L4, R1, L192, R5, R1, R4, L5, L4, R5, L1, L1, R48, R5, R5, L2, R4, R4, R1, R3, L1, L4, L5, R1, L4, L2, L5, R5, L2, R74, R4, L1, R188, R5, L4, L2, R5, R2, L4, R4, R3, R3, R2, R1, L3, L2, L5, L5, L2, L1, R1, R5, R4, L3, R5, L1, L3, R4, L1, L3, L2, R1, R3, R2, R5, L3, L1, L1, R5, L4, L5, R5, R2, L5, R2, L1, L5, L3, L5, L5, L1, R1, L4, L3, L1, R2, R5, L1, L3, R4, R5, L4, L1, R5, L1, R5, R5, R5, R2, R1, R2, L5, L5, L5, R4, L5, L4, L4, R5, L2, R1, R5, L1, L5, R4, L3, R4, L2, R3, R3, R3, L2, L2, L2, L1, L4, R3, L4, L2, R2, R5, L1, R2")
            it("should calculate a distance of 226") {
                assertThat(distance, equalTo(226))
            }
        }

    }

})