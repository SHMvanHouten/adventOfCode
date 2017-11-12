package com.github.shmvanhouten.adventofcode.day5

class PasswordFinder (val hashUtil: HashUtil = HashUtil()){
    fun calculatePassword(doorId: String): String {
        val zeroToMax = 0..Int.MAX_VALUE
        val passwordBuilder = StringBuilder()
//        run breaker@ {
//            zeroToMax.forEach {
//                val sixthHexaDecimal = hashUtil.get00000xHashMd5(doorId + it)
//                if(sixthHexaDecimal != null){
//                    passwordBuilder.append(sixthHexaDecimal)
//                    if(passwordBuilder.length >= 8) return@breaker
//                }
//            }
//        }
        for (index in zeroToMax) {
            val sixthHexaDecimal = hashUtil.get00000xHashMd5(doorId + index)
            if(sixthHexaDecimal != null){
                passwordBuilder.append(sixthHexaDecimal)
                if(passwordBuilder.length >= 8) break
            }
        }

        return passwordBuilder.toString()
    }
}