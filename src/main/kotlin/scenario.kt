fun scenario() {
    simulationStep(12,8)
}

fun simulationStep(numberOfCars : Int, capacity : Int) {
    val road = Network(capacity)
    val cars = 1..numberOfCars
    for (car in cars) {
        val car = Car(true, road)
        println("Does this car want to drive? " + car.wantsToDrive)
        road.overCapacity()
        println("Is this car ($car) delayed? " + road.analyzeNetwork())
    }
}