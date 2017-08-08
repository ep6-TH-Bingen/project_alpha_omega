class Network(val capacity : Int, val listOfCars: ListOfCars) {

    val listOfCarsDriving : MutableList<Car> = mutableListOf()

    fun overCapacity() : Boolean {
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
        for (car in listOfCars.listOfCars) {
            if (car.wantsToDrive == true) {
                this.listOfCarsDriving.add(car)
            }
        }
        val overCapacity = this.overCapacity()
        for (car in listOfCars.listOfCars) {
            car.isDelayed = overCapacity
        }
    }

}
