package com.github.shmvanhouten.adventofcode.day22gridcomputing

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

class StorageClusterBuilderTest {
    @Test
    fun `it should build a 4 by 4 cluster of nodes`() {
        val clusterBuilder = StorageClusterBuilder()

        val rawInput = """"root@ebhq-gridcenter# df -h
Filesystem              Size  Used  Avail  Use%
/dev/grid/node-x0-y0     92T   73T    19T   79%
/dev/grid/node-x0-y1     91T   66T    25T   72%
/dev/grid/node-x0-y2     85T   0T     85T    0%
/dev/grid/node-x1-y0     91T   73T    18T   80%
/dev/grid/node-x1-y1     94T   69T    25T   73%
/dev/grid/node-x1-y2     89T   66T    23T   74%
/dev/grid/node-x2-y0     94T   65T    29T   69%
/dev/grid/node-x2-y1     85T   68T    17T   80%
/dev/grid/node-x2-y2     94T   66T    28T   70%"""
        val cluster: StorageCluster = clusterBuilder.buildStorageClusterFromRawInput(rawInput)
        assertThat(cluster.grid.getValue(Coordinate(2,1)).size, equalTo(85))
        ClusterDrawer.drawCluster(cluster)
    }

    @Test
    fun `it should build the challenge cluster`() {
        val clusterBuilder = StorageClusterBuilder()

        val cluster: StorageCluster = clusterBuilder.buildStorageClusterFromRawInput(day22ChallengeInput)
        cluster.grid.values.forEach { if (it.available > 40) println(it) }
        ClusterDrawer.drawCluster(cluster)
    }
}

object ClusterDrawer {
    fun drawCluster(cluster: StorageCluster) {
        val width = cluster.getWidth()
        val height = cluster.getHeight()
        for(y in 0.until(height)){
            val row = StringBuilder()
            for (x in 0.until(width)){
                val node = cluster.grid.getValue(Coordinate(x, y))
                val available = node.available.toString()
                val amountOfDotsToPrepend = (available.length - 3)
                (amountOfDotsToPrepend..0).forEach { row.append('.') }
                row.append(available)
                row.append('/')
                val used = node.used.toString()
                row.append(used)
                val amountOfDotsToAppend = (used.length - 3)
                (amountOfDotsToAppend..0).forEach { row.append('.') }
                row.append("  --  ")
            }
            println(row.toString())
            println(" ")
        }
    }
}

private fun StorageCluster.getHeight(): Int {
    var y = 0
    while(this.grid.containsKey(Coordinate(0, y))){
        y++
    }
    return y
}

private fun StorageCluster.getWidth(): Int {
    var x = 0
    while(this.grid.containsKey(Coordinate(x, 0))){
        x++
    }
    return x
}
