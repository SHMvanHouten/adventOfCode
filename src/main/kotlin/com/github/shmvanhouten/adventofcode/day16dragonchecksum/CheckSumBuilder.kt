package com.github.shmvanhouten.adventofcode.day16dragonchecksum

class CheckSumBuilder {

    fun buildCheckSum(input: String): String {

        var checkSum: String = input

        while (checkSum.length %2 == 0){
            checkSum = checkSumify(checkSum)
        }

        return checkSum
    }

    private fun checkSumify(input: String): String {
        val checkSumBuilder = StringBuilder()
        for (index in 0.until(input.length) step 2){
            if (input[index] == input[index + 1]){
                checkSumBuilder.append('1')
            } else {
                checkSumBuilder.append('0')
            }
        }
        return checkSumBuilder.toString()
    }
}