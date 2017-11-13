package com.github.shmvanhouten.adventofcode.day7

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

class SSLSupportCheckerForIpTest{
    private val sslSupportChecker = SSLSupportCheckerForIp()

    @Test
    fun `It should find 'aba(bab)xyz' does support SSL`() {
        assertThat(sslSupportChecker.doesIpSupportSSL("aba[bab]xyz"), equalTo(true))
    }

    @Test
    fun `It should find 'xyx(xyx)xyx' does not support SSL`() {
        assertThat(sslSupportChecker.doesIpSupportSSL("xyx[xyx]xyx"), equalTo(false))
    }

    @Test
    fun `It should find 'aaa(kek)eke' does support SSL`() {
        assertThat(sslSupportChecker.doesIpSupportSSL("aaa[kek]eke"), equalTo(true))
    }

    @Test
    fun `It should find 'zazbz(bzb)cdb' does support SSL`() {
        assertThat(sslSupportChecker.doesIpSupportSSL("zazbz[bzb]cdb"), equalTo(true))
    }

    @Test
    fun `It should test the amount of ssl supported ips in the challenge input`() {
        val count1 = sslSupportChecker.countIpsthatSupportSSL(challengeInput)
        val count2 = sslSupportChecker.countIpsthatSupportSSL(challengeInputPart2)
        val count3 = sslSupportChecker.countIpsthatSupportSSL(challengeInputPart3)
        val count4 = sslSupportChecker.countIpsthatSupportSSL(challengeInputPart4)
        val actualAmountOfTrue = count1 + count2 +count3 + count4

        assertThat(actualAmountOfTrue, equalTo(242))

    }
}