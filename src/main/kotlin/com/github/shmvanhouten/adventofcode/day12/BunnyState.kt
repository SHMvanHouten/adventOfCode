package com.github.shmvanhouten.adventofcode.day12

data class BunnyState(val a: Int = 0, val b: Int = 0, val c: Int = 0, val d: Int = 0){
    fun setA(aValue: Int): BunnyState {
        return BunnyState(
                a = aValue,
                b = this.b,
                c = this.c,
                d = this.d
        )
    }
    fun setB(bValue: Int): BunnyState {
        return BunnyState(
                a = this.a,
                b = bValue,
                c = this.c,
                d = this.d
        )
    }
    fun setC(cValue: Int): BunnyState {
        return BunnyState(
                a = this.a,
                b = this.b,
                c = cValue,
                d = this.d
        )
    }
    fun setD(dValue: Int): BunnyState {
        return BunnyState(
                a = this.a,
                b = this.b,
                c = this.c,
                d = dValue
        )
    }

    fun incA(): BunnyState {
        return BunnyState(
                a = this.a + 1,
                b = this.b,
                c = this.c,
                d = this.d
        )
    }
    fun incB(): BunnyState {
        return BunnyState(
                a = this.a,
                b = this.b + 1,
                c = this.c,
                d = this.d
        )
    }
    fun incC(): BunnyState {
        return BunnyState(
                a = this.a,
                b = this.b,
                c = this.c + 1,
                d = this.d
        )
    }
    fun incD(): BunnyState {
        return BunnyState(
                a = this.a,
                b = this.b,
                c = this.c,
                d = this.d + 1
        )
    }

    fun decA(): BunnyState {
        return BunnyState(
                a = this.a - 1,
                b = this.b,
                c = this.c,
                d = this.d
        )
    }
    fun decB(): BunnyState {
        return BunnyState(
                a = this.a,
                b = this.b - 1,
                c = this.c,
                d = this.d
        )
    }
    fun decC(): BunnyState {
        return BunnyState(
                a = this.a,
                b = this.b,
                c = this.c - 1,
                d = this.d
        )
    }
    fun decD(): BunnyState {
        return BunnyState(
                a = this.a,
                b = this.b,
                c = this.c,
                d = this.d - 1
        )
    }

}