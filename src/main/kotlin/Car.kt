import com.univocity.parsers.csv.CsvParser
import com.univocity.parsers.csv.CsvParserSettings

class Car() {
    var inputCarNumberCSV : MutableList<Int> = mutableListOf()
    var inputInterestToDriveCSV : MutableList<Int> = mutableListOf()


    fun interestOfDriving(numberOfCars: Int): MutableList<Int> {
        var ListOfInterestToDrive: MutableList<Int> = mutableListOf()
        var interestToDrive = 0
        for (car in 1..numberOfCars) {
            val z = Math.random()
            if ((0 <= z) && (z <= 0.5)) {
                interestToDrive = 1
            }
            if ((0.5 < z) && (z <= 1.0)) {
                interestToDrive = 0
            }
            ListOfInterestToDrive.add(interestToDrive)
        }
        return ListOfInterestToDrive
    }

    fun announceDriving(ListOfInterestToDrive: MutableList<Int>) {
        for (interestToDrive in ListOfInterestToDrive){
            if (interestToDrive == 1) {
                println("I want to drive!")
            }
            if (interestToDrive == 0) {
                println("I don't want to drive!")
            }
        }
    }

}