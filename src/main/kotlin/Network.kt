class Network(val capacity: Int, val listOfCars: MutableList<Car>) {

    fun requiredCapacity(): Int {
        var requiredCapacity = 0
        for (car in this.listOfCars) {
            if (car.wantsToDrive) {
                requiredCapacity += 1
            }
        }
        return requiredCapacity
    }

    fun analyzeNetwork() {
        val requiredCapacity = this.requiredCapacity()
        val carsDividedByCapacity = requiredCapacity / capacity.toDouble()
        val chanceOfDelay = chanceOfDelay(carsDividedByCapacity)

        for (car in listOfCars) {
            if (car.wantsToDrive) {
                val delayed = computingDelay(chanceOfDelay)
                car.isDelayed = delayed
            }
        }
    }

    fun chanceOfDelay(carsDividedByCapacity: Double): Double {
        var chanceOfDelay: Double = 0.0
        if (carsDividedByCapacity > 1.5) {
            chanceOfDelay = 0.9
        }
        if ((1.25 <= carsDividedByCapacity) && (carsDividedByCapacity <= 1.5)) {
            chanceOfDelay = 0.7
        }
        if ((1.1 <= carsDividedByCapacity) && (carsDividedByCapacity <= 1.25)) {
            chanceOfDelay = 0.5
        }
        if ((0.9 <= carsDividedByCapacity) && (carsDividedByCapacity <= 1.1)) {
            chanceOfDelay = 0.3
        }
        if ((0.7 <= carsDividedByCapacity) && (carsDividedByCapacity <= 0.9)) {
            chanceOfDelay = 0.2
        }
        if ((0.5 <= carsDividedByCapacity) && (carsDividedByCapacity <= 0.7)) {
            chanceOfDelay = 0.1
        }
        if (carsDividedByCapacity < 0.5) {
            chanceOfDelay = 0.05
        }
        return chanceOfDelay
    }

    fun computingDelay(chanceOfDelay: Double): Boolean {
        val randomNumber = Math.random()
        return chanceOfDelay > randomNumber
    }

}
