class Network() {
val capacity = 5
    fun tallyUpCars(ListOfInterestToDrive:MutableList<Int>) : Int {
        var ListOfCarsThatWantToDrive:MutableList<Int> = mutableListOf()
        for (interestToDrive in ListOfInterestToDrive){
            if (interestToDrive==1){
                ListOfCarsThatWantToDrive.add(0)
            }

        }
        val numberOfCarsThatWantToDrive = ListOfCarsThatWantToDrive.size
        return numberOfCarsThatWantToDrive
    }

    fun compareCapacity(numberOfCarsThatWantToDrive:Int) : Int {
        var CarsThatAreAllowedToDrive = 0
        if (numberOfCarsThatWantToDrive<=capacity){
            CarsThatAreAllowedToDrive = numberOfCarsThatWantToDrive
        }
        if (numberOfCarsThatWantToDrive>capacity){
            CarsThatAreAllowedToDrive = 0
        }
        return CarsThatAreAllowedToDrive
        //less than or equal to capacity ~> all can drive
        //over capacity ~> all are delayed

    }

}