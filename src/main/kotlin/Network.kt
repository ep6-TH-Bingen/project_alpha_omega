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
    fun CarsDevidedByCapacity():Double{
        val x = (listOfCars.size / capacity).toDouble()
        return x
    }
fun switchCase(x:Double):Double {
    var y :Double = 0.0
    if (x > 1.5) {
        y = 0.9
    }
    if ((1.25 <= x) && (x <= 1.5)) {
        y = 0.7
    }
    if ((1.1 <= x) && (x <= 1.25)) {
        y = 0.5
    }
    if ((0.9 <= x) && (x <= 1.1)) {
        y = 0.3
    }
    if ((0.7 <= x) && (x <= 0.9)) {
        y = 0.2
    }
    if ((0.5 <= x) && (x <= 0.7)) {
        y = 0.1
    }
    if (x < 0.5) {
        y = 0.05
    }
    return y
}
    fun applyingDelay(ListOfCarsInterestToDriveInteger:MutableList<Int>,y:Double):MutableList<Int>{
        var ListOfCarsAfterDelay:MutableList<Int> = mutableListOf()
        for (car in ListOfCarsInterestToDriveInteger){
            if (car==1) {
                val z = Math.random()
                var value = 1
                if (y > z) {
                    value = 0
                }
                ListOfCarsAfterDelay.add(ListOfCarsInterestToDriveInteger.get(car) * value)
            }
            if (car==0){
                ListOfCarsAfterDelay.add(ListOfCarsInterestToDriveInteger.get(car) * 0)
            }
        }
        return ListOfCarsAfterDelay
    }
}
