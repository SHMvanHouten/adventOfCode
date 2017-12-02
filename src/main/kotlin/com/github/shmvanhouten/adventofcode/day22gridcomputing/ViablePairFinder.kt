package com.github.shmvanhouten.adventofcode.day22gridcomputing

class ViablePairFinder(val storageClusterBuilder: StorageClusterBuilder = StorageClusterBuilder()) {

    fun countViablePairsFromRawInput(rawInput: String): Int {
        val storageCluster = storageClusterBuilder.buildStorageClusterFromRawInput(rawInput)
        return storageCluster.grid.values
                .sumBy { node -> storageCluster.grid.values.count { otherNode ->  areNodesValidPairs(node, otherNode)} }
    }

    private fun areNodesValidPairs(node: StorageNode, otherNode: StorageNode): Boolean {
        if (node == otherNode){
            return false
        }
        if(node.used == 0){
            return false
        }
        if (otherNode.available >= node.used){
            return true
        }
        return false
    }
}