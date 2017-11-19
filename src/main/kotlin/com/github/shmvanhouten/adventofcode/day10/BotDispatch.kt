package com.github.shmvanhouten.adventofcode.day10

class BotDispatch(    var bots: List<SortingBot> = emptyList(),
                      var outputs: List<Output> = emptyList()) {

    fun retrieveReceiver(destination: Destination): Receiver? = when (destination.destinationType) {
        DestinationType.BOT -> getBot(destination)
        else -> outputs.find { it.outputNumber == destination.number }
    }


    fun givePickupOrdersToBots(pickupOrders: List<PickupOrder>) {
        pickupOrders.forEach { callBotToTakeChip(it) }
    }


    private fun callBotToTakeChip(pickupOrder: PickupOrder) {
        getBot(pickupOrder.destination)?.takeChip(pickupOrder.chip)
    }

    private fun getBot(destination: Destination) =
            bots.find { it.botNumber == destination.number }
}