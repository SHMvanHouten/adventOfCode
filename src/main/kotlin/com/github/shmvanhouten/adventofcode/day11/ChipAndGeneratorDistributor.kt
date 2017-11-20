package com.github.shmvanhouten.adventofcode.day11

class ChipAndGeneratorDistributor (var elevatorLvl: Int = 1){

    private val AMOUNT_OF_STEPS_IT_TAKES_TO_MOVE_FIRST_TWO_SETS_OF_COMPONENTS_UP_ONE_FLOOR = 5
    private val STEPS_PER_SET_OF_COMPONENTS = 4

    fun findQuickestWayToTop(floorsInput: Map<Int, Pair<List<Chip>, List<Generator>>>): Int {
        var stepCounter = 0
        var floors = floorsInput

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
                moveUpComponent(floors, elevatorLvl)

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

    private fun moveUpComponent(floors: Map<Int, Pair<List<Chip>, List<Generator>>>, elevatorLvl: Int) {
        val componentsWithCounterPartsOnNextLvl = floors[elevatorLvl]!!.getComponentsPairedWithOtherLvl(floors[elevatorLvl + 1]!!)
        when {
            componentsWithCounterPartsOnNextLvl.size >= 2 -> {/*move the first 2 of these up*/}
            componentsWithCounterPartsOnNextLvl.size == 1 -> {}
            else -> {}
        }
    }
}

private fun Pair<List<Component>, List<Component>>.getComponentsPairedWithOtherLvl(other: Pair<List<Component>, List<Component>>): List<Component> {
    val pairedChips = this.first.filter { isLinkedComponentInOtherList(it, other.second) }
    val pairedGenerator = this.second.filter { isLinkedComponentInOtherList(it, other.first) }
    return pairedChips.union(pairedGenerator).toList()
}

private fun Pair<List<Component>, List<Component>>.findUnmatchedComponents(): List<Component> {
    val unpairedChips = this.first.filterNot { isLinkedComponentInOtherList(it, this.second) }
    val unpairedGenerators = this.second.filterNot { isLinkedComponentInOtherList(it, this.first) }
    return unpairedChips.union(unpairedGenerators).toList()
}

fun isLinkedComponentInOtherList(component: Component, otherComponents: List<Component>): Boolean =
        otherComponents.any { it.elementType == component.elementType }

private fun Pair<List<Component>, List<Component>>.isNotEmpty(): Boolean =
        this.first.isNotEmpty() || this.second.isNotEmpty()
