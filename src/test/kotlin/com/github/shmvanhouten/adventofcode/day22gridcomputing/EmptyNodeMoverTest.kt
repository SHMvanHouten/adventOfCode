package com.github.shmvanhouten.adventofcode.day22gridcomputing

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

class EmptyNodeMoverTest {

    @Test
    fun `it should 'move' the empty node up next to the top right corner`() {
        val clusterBuilder = StorageClusterBuilder()

        val rawInput = """"root@ebhq-gridcenter# df -h
Filesystem              Size  Used  Avail  Use%
/dev/grid/node-x0-y0     92T   73T    19T   79%
/dev/grid/node-x0-y1     91T   66T    25T   72%
/dev/grid/node-x0-y2     91T   66T    25T   72%
/dev/grid/node-x0-y3     85T   0T     85T    0%
/dev/grid/node-x1-y0     91T   73T    18T   80%
/dev/grid/node-x1-y1     94T   69T    25T   73%
/dev/grid/node-x1-y2     89T   66T    23T   74%
/dev/grid/node-x1-y3     89T   66T    23T   74%
/dev/grid/node-x2-y0     94T   65T    29T   69%
/dev/grid/node-x2-y1     85T   68T    17T   80%
/dev/grid/node-x2-y2     94T   66T    28T   70%
/dev/grid/node-x2-y3     94T   66T    28T   70%
/dev/grid/node-x3-y0     91T   73T    18T   80%
/dev/grid/node-x3-y1     94T   69T    25T   73%
/dev/grid/node-x3-y2     89T   66T    23T   74%
/dev/grid/node-x3-y3     89T   66T    23T   74%"""
        val cluster: StorageCluster = clusterBuilder.buildStorageClusterFromRawInput(rawInput)
        val mover = EmptyNodeMover(cluster)
        val targetCoordinate = Coordinate(2, 0)
        val (clusterAfterMove, amountOfMoves) = mover.moveEmptyClusterTo(targetCoordinate)
        ClusterDrawer.drawCluster(clusterAfterMove)
        assertThat(amountOfMoves, equalTo(5))
    }

    @Test
    fun `it should move the empty node next to the target node for the challenge input`() {
        val clusterBuilder = StorageClusterBuilder()
        val cluster: StorageCluster = clusterBuilder.buildStorageClusterFromRawInput(day22ChallengeInput)

        val mover = EmptyNodeMover(cluster)
        val targetCoordinate = Coordinate(28, 0)
        val (clusterAfterMove, amountOfStepsTaken) = mover.moveEmptyClusterTo(targetCoordinate)
        println(amountOfStepsTaken)
        assertThat(clusterAfterMove.getEmptyCluster()?.coordinate, equalTo(targetCoordinate))
    }
}