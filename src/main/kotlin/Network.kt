class Network(val capacity: Int, val listOfCars: MutableList<Car>) {

    val listOfCarsDriving: MutableList<Car> = mutableListOf()

    fun overCapacity(): Boolean {
        // tallies up the number of cars on the road
        val numberOfCarsDriving = listOfCarsDriving.size
        // compares it to its own capacity
        if (this.capacity >= numberOfCarsDriving) {
            return false
        } else {
            return true
        }
    }

    fun analyzeNetwork() {
        for (car in this.listOfCars) {
            if (car.wantsToDrive == true) {
                this.listOfCarsDriving.add(car)
            }
        }
        val overCapacity = this.overCapacity()
        for (car in listOfCars) {
            car.isDelayed = overCapacity
        }
    }
    fun carsDividedByCapacity():Double{
        val carsDividedByCapacity = (listOfCars.size / capacity).toDouble()
        return carsDividedByCapacity
    }
    fun switchCase(carsDividedByCapacity:Double):Double {
        var chanceOfDelay :Double = 0.0
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
    fun applyingDelay(ListOfInterest:MutableList<Boolean>,chanceOfDelay:Double):MutableList<Boolean>{
        var ListOfCarsAfterDelay:MutableList<Boolean> = mutableListOf()
        for (car in ListOfInterest){
            if (car==true) {
                val RandomNumber = Math.random()
                var value = true
                if (chanceOfDelay > RandomNumber) {
                    value = false
                }
                ListOfCarsAfterDelay.add(value)
            }
            if (car==false){
                ListOfCarsAfterDelay.add(false)
            }
        }
        return ListOfCarsAfterDelay
    }
}