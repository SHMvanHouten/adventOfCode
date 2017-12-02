package com.github.shmvanhouten.adventofcode.day22gridcomputing

class StorageClusterBuilder {
    fun buildStorageClusterFromRawInput(rawInput: String): StorageCluster {
        val rawNodes = getRawNodesFromRawInput(rawInput)
        val grid = rawNodes.map { buildNodeFromRawNode(it) }.toMap()
        return StorageCluster(grid)
    }

    private fun buildNodeFromRawNode(rawNode: String): Pair<Coordinate, StorageNode> {
        val regex = Regex("""\s+""")
        val nodeComponents = rawNode.split(regex)
        val coordinate = buildCoordinateFromRawNodeComponent(nodeComponents[0])
        val size = getNumberFromRawNodeComponent(nodeComponents[1])
        val used = getNumberFromRawNodeComponent(nodeComponents[2])
        val available = getNumberFromRawNodeComponent(nodeComponents[3])
        return Pair(coordinate, StorageNode(coordinate, size,used,available))
    }

    private fun getNumberFromRawNodeComponent(nodeComponent: String): Int {
        return nodeComponent.substring(0, nodeComponent.indexOf('T')).toInt()
    }

    private fun getRawNodesFromRawInput(rawInput: String): List<String> {
        val split = rawInput.split("\n")
        return split.subList(2, split.size)
    }

    private fun buildCoordinateFromRawNodeComponent(nodeComponent: String): Coordinate {
        val indexOfX = nodeComponent.indexOf("-x")
        val indexOfY = nodeComponent.indexOf("-y")
        val xCoordinate = nodeComponent.substring(indexOfX + 2, indexOfY).toInt()
        val yCoordinate = nodeComponent.substring(indexOfY + 2).toInt()
        return Coordinate(xCoordinate, yCoordinate)
    }
}