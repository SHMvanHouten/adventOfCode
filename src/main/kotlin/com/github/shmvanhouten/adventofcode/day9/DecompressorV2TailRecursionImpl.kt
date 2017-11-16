package com.github.shmvanhouten.adventofcode.day9

class DecompressorV2TailRecursionImpl {

    fun getDecompressionSize(compressedInput: String): Long {
        return decompressTailRec(compressedInput)
    }

    private tailrec fun decompressTailRec(compressedInput: String, factor: Int = 1, size: Long = 0): Long {
        var tempSize = size
        var tempCompressedInput = compressedInput
        val indexOfMarker = tempCompressedInput.indexOf('(')
        //if there are no more markers we can just multiply the amount of chars with the factor
        if(indexOfMarker == -1){
            return (tempCompressedInput.length * factor).toLong()
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
            return processNonOverlappingMarkers(tempCompressedInput, factor)
        }
        //if there is Marker in pos 0 and the marker spans the entire input
        return decompressTailRec(stringAfterMarkerAndNewFactor.first, newFactor, tempSize)
    }

    private fun processNonOverlappingMarkers(section: String, parentFactor: Int): Long {
        val markerSections = mutableListOf<String>()

        var tempSection = section
        var indexOfMarker = tempSection.indexOf('(')
        while(indexOfMarker != -1){
            if(indexOfMarker > 0){
                markerSections.add(tempSection.substring(0, indexOfMarker))
                tempSection = tempSection.substring(indexOfMarker)
            }
            val markerSection = getMarkerSection(tempSection)
            markerSections.add(markerSection)
            tempSection = tempSection.substring(markerSection.length)
            indexOfMarker = tempSection.indexOf('(')
        }
        var size: Long = 0
        markerSections.forEach { size += decompressTailRec(it) }
        return ( size * parentFactor)
    }

    private fun getMarkerSection(tempSection: String): String{
        val indexOfX = tempSection.indexOf('x')
        val span = tempSection.substring(1, indexOfX).toInt()

        val indexOfStartOfContent = tempSection.indexOf(')') + 1

        return tempSection.substring(0, indexOfStartOfContent + span)
    }

    private fun getStringAfterMarkerAndNewFactor(tempCompressedInput: String, parentFactor: Int): Pair<String, Int> {
        val indexOfEndOfMarker = tempCompressedInput.indexOf(')')
        val spanAndFactor = tempCompressedInput.substring(1, indexOfEndOfMarker).split('x').map { it.toInt() }
        val inputCoveredByMarker = tempCompressedInput.substring(indexOfEndOfMarker + 1, indexOfEndOfMarker + 1 + spanAndFactor[0])
        return Pair(inputCoveredByMarker, spanAndFactor[1] * parentFactor)
    }
}

