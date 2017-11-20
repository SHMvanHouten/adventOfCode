package com.github.shmvanhouten.adventofcode.day11

class ChipAndGeneratorDistributor (var elevatorLvl: Int = 1){

    private val AMOUNT_OF_STEPS_IT_TAKES_TO_MOVE_FIRST_TWO_SETS_OF_COMPONENTS_UP_ONE_FLOOR = 5
    private val STEPS_PER_SET_OF_COMPONENTS = 4

    fun findQuickestWayToTop(floors: Map<Int, Pair<List<Chip>, List<Generator>>>): Int {
        var stepCounter = 0

        while(floors.count { it.value.first.isNotEmpty() || it.value.second.isNotEmpty() } > 1){
            if(elevatorLvl - 1 > 0 && floors[elevatorLvl - 1]!!.isNotEmpty()){
                //go down to fetch next component
                val unconnectedComponents: List<Component> = floors[elevatorLvl]!!.findUnmatchedComponents()
                if(unconnectedComponents.isEmpty()){
                    // move down the first generator
                }else {
                    //check if the components counterpart is down, otherwise is not relevant
                }

                elevatorLvl--
            }else{
                // bring up 2 components

                elevatorLvl++
            }
            stepCounter++
        }
        val floorAllComponentsAreOn: Int? = floors.keys.find { floors[it]!!.isNotEmpty() }
        val amountOfElementTypes = floors[floorAllComponentsAreOn]!!.first.size

        val amountOfStepsToTheTop = 4 - floorAllComponentsAreOn!!


        return stepCounter + (AMOUNT_OF_STEPS_IT_TAKES_TO_MOVE_FIRST_TWO_SETS_OF_COMPONENTS_UP_ONE_FLOOR
        + STEPS_PER_SET_OF_COMPONENTS * (amountOfElementTypes - 2)) * amountOfStepsToTheTop
    }
}

private fun Pair<List<Component>, List<Component>>.findUnmatchedComponents(): List<Component> {
    val unpairedChips = this.first.filterNot { isLinkedComponentOnSameFloor(it, this.second) }
    val unpairedGenerators = this.second.filterNot { isLinkedComponentOnSameFloor(it, this.first) }
    return unpairedChips.union(unpairedGenerators).toList()
}

fun isLinkedComponentOnSameFloor(component: Component, otherComponents: List<Component>): Boolean {
    return otherComponents.any { it.elementType == component.elementType }
}

private fun Pair<List<Component>, List<Component>>.isNotEmpty(): Boolean =
        this.first.isNotEmpty() || this.second.isNotEmpty()
