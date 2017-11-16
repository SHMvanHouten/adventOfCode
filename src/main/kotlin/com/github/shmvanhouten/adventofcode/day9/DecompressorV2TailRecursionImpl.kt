package com.github.shmvanhouten.adventofcode.day9

class DecompressorV2TailRecursionImpl {

    fun getDecompressionSize(compressedInput: String): Int {
        return decompressTailRec(compressedInput)
    }

    private tailrec fun decompressTailRec(compressedInput: String, factor: Int = 1, size: Int = 0): Int {
        var tempSize = size
        var tempCompressedInput = compressedInput
        val indexOfMarker = tempCompressedInput.indexOf('(')
        //if there are no more markers we can just multiply the amount of chars with the factor
        if(indexOfMarker == -1){
            return tempCompressedInput.length * factor
        }
        //if there is compressed chars in pos 0 add to size
        if(indexOfMarker > 0){
            tempSize += indexOfMarker * factor
            tempCompressedInput = tempCompressedInput.substring(indexOfMarker)
        }
        val stringAfterMarkerAndNewFactor = getStringAfterMarkerAndNewFactor(tempCompressedInput, factor)
        val newFactor = stringAfterMarkerAndNewFactor.second
        //if there is marker in pos 0 and th marker doesn't span the entire input
        if(stringAfterMarkerAndNewFactor.first.length < tempCompressedInput.length - (tempCompressedInput.indexOf(')') + 1)){
            
        }

        //if there is Marker in pos 0 and the marker spans the entire input
        return decompressTailRec(stringAfterMarkerAndNewFactor.first, newFactor, size)
    }

    private fun getStringAfterMarkerAndNewFactor(tempCompressedInput: String, parentFactor: Int): Pair<String, Int> {
        val indexOfEndOfMarker = tempCompressedInput.indexOf(')')
        val spanAndFactor = tempCompressedInput.substring(1, indexOfEndOfMarker).split('x').map { it.toInt() }
        val inputCoveredByMarker = tempCompressedInput.substring(indexOfEndOfMarker + 1, indexOfEndOfMarker + 1 + spanAndFactor[0])
        println(inputCoveredByMarker)
        return Pair(inputCoveredByMarker, spanAndFactor[1] * parentFactor)
    }
}

