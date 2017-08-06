class Car(val wantsToDrive: Boolean) {

    val listOfCars : MutableList<Car> = mutableListOf()
    val listOfCarsDriving : MutableList<Car> = mutableListOf()

    // when a new car is initialized it is added to the listOfCars
    init {
        listOfCars.add(this)
        if (wantsToDrive == true) {
            listOfCarsDriving.add(this)
        }
    }

    // I guess this is not necessary
    fun announce() : Boolean {
        if (wantsToDrive == true) {
            return true
        } else {
            return false
        }
    }
}