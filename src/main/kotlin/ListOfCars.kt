class ListOfCars() {

    val listOfCars : MutableList<Car> = mutableListOf()

    fun addCar(car: Car) {
        this.listOfCars.add(car)
    }
}
