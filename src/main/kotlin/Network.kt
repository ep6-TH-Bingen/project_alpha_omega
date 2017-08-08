class Network(val capacity : Int) {

    val listOfCars : MutableList<Car> = mutableListOf()
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
        val overCapacity = this.overCapacity()
        for (car in this.listOfCarsDriving) {
            car.delayed = overCapacity
        }
    }

}
