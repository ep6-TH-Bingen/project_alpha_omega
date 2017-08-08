class Car(val wantsToDrive: Boolean, val roadNetwork : Network) {

    var isDelayed : Boolean = false
    // when a new car is initialized it is added to the listOfCars of the Network
    init {
        roadNetwork.listOfCars.add(this)
        if (wantsToDrive == true) {
            roadNetwork.listOfCarsDriving.add(this)
        }
    }
}
