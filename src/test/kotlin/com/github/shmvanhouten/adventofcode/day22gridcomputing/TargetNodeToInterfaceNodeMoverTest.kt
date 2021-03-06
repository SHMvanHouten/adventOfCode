package com.github.shmvanhouten.adventofcode.day22gridcomputing

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

class TargetNodeToInterfaceNodeMoverTest {

    @Test
    fun `it should move the target node to the interface node in 11 steps`() {
        val rawInput = """"root@ebhq-gridcenter# df -h
Filesystem              Size  Used  Avail  Use%
/dev/grid/node-x0-y0     92T   73T    19T   79%
/dev/grid/node-x0-y1     91T   66T    25T   72%
/dev/grid/node-x0-y2     91T   66T    25T   72%
/dev/grid/node-x0-y3     85T   72T    13T   83%
/dev/grid/node-x1-y0     91T   73T    18T   80%
/dev/grid/node-x1-y1     94T   69T    25T   73%
/dev/grid/node-x1-y2     89T   66T    23T   74%
/dev/grid/node-x1-y3     89T   66T    23T   74%
/dev/grid/node-x2-y0     91T    0T    91T    0%
/dev/grid/node-x2-y1     85T   68T    17T   80%
/dev/grid/node-x2-y2     94T   66T    28T   70%
/dev/grid/node-x2-y3     94T   66T    28T   70%
/dev/grid/node-x3-y0     94T   59T    29T   69%
/dev/grid/node-x3-y1     94T   69T    25T   73%
/dev/grid/node-x3-y2     89T   66T    23T   74%
/dev/grid/node-x3-y3     89T   66T    23T   74%"""
        val clusterBuilder = StorageClusterBuilder()
        val cluster: StorageCluster = clusterBuilder.buildStorageClusterFromRawInput(rawInput)
        val targetNodeCoordinate = Coordinate(3, 0)
        val targetDataSize = cluster.get(targetNodeCoordinate).used

        val mover = TargetNodeToInterfaceNodeMover(cluster)
        val (storageCluster, amountOfSteps) = mover.moveTargetNodeDataToInterfaceNode(targetNodeCoordinate)
        assertThat(amountOfSteps, equalTo(11))
        assertThat(targetDataSize, equalTo(storageCluster.get(Coordinate(0,0)).used))
    }

    @Test
    fun `it should move the target node to the interface node in 198 steps`() {
        val clusterBuilder = StorageClusterBuilder()
        val cluster: StorageCluster = clusterBuilder.buildStorageClusterFromRawInput(day22ChallengeInput)

        val targetNodeCoordinate = Coordinate(29, 0)

        val targetDataSize = cluster.get(targetNodeCoordinate).used

        val mover = TargetNodeToInterfaceNodeMover(cluster)
        val (storageCluster, amountOfSteps) = mover.moveTargetNodeDataToInterfaceNode(targetNodeCoordinate)
        assertThat(amountOfSteps, equalTo(198))
        assertThat(targetDataSize, equalTo(storageCluster.get(Coordinate(0,0)).used))
    }
}