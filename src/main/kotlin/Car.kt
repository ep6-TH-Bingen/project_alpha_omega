class Car(val id : Int, val wantsToDrive: Boolean, listOfCars: MutableList<Car>) {

    var isDelayed : Boolean = false

    // when a new car is initialized it is added to the listOfCars
    init {
        listOfCars.add(this)
    }
}