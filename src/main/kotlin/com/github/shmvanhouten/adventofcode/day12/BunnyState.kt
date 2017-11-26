package com.github.shmvanhouten.adventofcode.day12

import com.github.shmvanhouten.adventofcode.day12.Register.*

data class BunnyState(val a: Int = 0, val b: Int = 0, val c: Int = 0, val d: Int = 0){

    fun set(a: Int = this.a,
            b: Int = this.b,
            c: Int = this.c,
            d: Int = this.d): BunnyState = BunnyState(a,b,c,d)

    fun inc(register: Register): BunnyState {

        var a = this.a
        var b = this.b
        var c = this.c
        var d = this.d

        when(register){
            A -> a += 1
            B -> b += 1
            C -> c += 1
            D -> d += 1
        }

        return BunnyState(a,b,c,d)
    }

    fun dec(register: Register): BunnyState {

        var a = this.a
        var b = this.b
        var c = this.c
        var d = this.d

        when(register){
            A -> a -= 1
            B -> b -= 1
            C -> c -= 1
            D -> d -= 1
        }

        return BunnyState(a,b,c,d)
    }

}