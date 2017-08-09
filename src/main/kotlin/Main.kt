import com.univocity.parsers.common.record.Record
import com.univocity.parsers.csv.CsvParser
import com.univocity.parsers.csv.CsvParserSettings
import com.univocity.parsers.csv.CsvWriter
import com.univocity.parsers.csv.CsvWriterSettings

fun main(args: Array<String>) {
    val roadNetwork = readNetworkFromCsv("/cars.csv")
    var ListOfInterest:MutableList<Boolean> = mutableListOf()
    for (car in roadNetwork.listOfCars) {
        ListOfInterest.add(car.wantsToDrive)
    }
        roadNetwork.analyzeNetwork()
        var numberOfCarsInComparisonToCapacity = roadNetwork.CarsDevidedByCapacity()
        var chanceOfDelay = roadNetwork.switchCase(numberOfCarsInComparisonToCapacity)
        val ListOfCarsAfterDelayHasBeenApplied = revertBackToBoolean(roadNetwork.applyingDelay(ListOfInterestInteger(ListOfInterest),chanceOfDelay))
        writeNetworkToCsv(roadNetwork, "ResultingData.csv")
    }

private fun readNetworkFromCsv(fileName: String): Network {
    //Changed the return "Car" into "Network", because there is the "listOfCars"
    val capacity = 20
    val settings = CsvParserSettings()
    settings.format.setLineSeparator("\n")
    settings.isHeaderExtractionEnabled = true
    val csvParser = CsvParser(settings)
    val reader = FileAccess().getReader(fileName)
    val carRows: MutableList<Record> = csvParser.parseAllRecords(reader)

    val listOfCars: MutableList<Car> = mutableListOf()
    for (car in carRows) {
        val carID = car.values.get(0)
        val id = carID.toInt()

        val carStatus = car.values.get(1)
        val status = carStatus.toBoolean()

        val newCar = Car(id, status)
        listOfCars.add(newCar)
    }

    return Network(capacity, listOfCars)
}

private fun writeNetworkToCsv(network: Network, fileName: String) {
    val settings = CsvWriterSettings()
    settings.format.setLineSeparator("\n")

    val writer = FileAccess().getWriter(fileName)
    val csvWriter = CsvWriter(writer, settings)
    csvWriter.writeHeaders("Car-ID", "status", "delayed")

    val carRows: MutableList<Array<Any>> = mutableListOf()
    for (car in network.listOfCars) {
        val id = car.id
        val status = car.wantsToDrive
        //This needs to be changed so that the actual delay gets written into the output file and not the default Boolean from the Car class
        val delayed = car.isDelayed
        //This needs to be changed so that the actual delay gets written into the output file and not the default Boolean from the Car class
        val row: Array<Any> = arrayOf(id, status, delayed)
        carRows.add(row)
    }

    csvWriter.writeRowsAndClose(carRows)
}

fun scenario(numberOfCars: Int, capacity: Int) {
    /*
    * Creates a given a number of cars, every other car wants to drive
    * A road network is created with the given capacity
    * The road network is analyzed and it is printed whether a car is delayed or not
    */
    val listOfCars: MutableList<Car> = mutableListOf()
    for (i in 1..numberOfCars) {
        val newCar = Car(i, i % 2 == 0)
        listOfCars.add(newCar)
    }

    val road = Network(capacity, listOfCars)
    road.analyzeNetwork()
    for (car in road.listOfCars) {
        println("Does car #" + car.id + " want to drive? " + car.wantsToDrive)
        if (car.wantsToDrive == true) {
            println("Is car #" + car.id + " delayed? " + car.isDelayed)
        }
    }
}
fun ListOfInterestInteger(ListOfInterest:MutableList<Boolean>):MutableList<Int>{
    var ListOfCarInterestToDriveInteger:MutableList<Int> = mutableListOf()
    var carInterestToDrive : Int = 0
    for (car in ListOfInterest){
        if (car==true){
            carInterestToDrive = 1
        }
        if (car==false){
            carInterestToDrive = 0
        }
        ListOfCarInterestToDriveInteger.add(carInterestToDrive)
    }
    return ListOfCarInterestToDriveInteger
}

fun revertBackToBoolean(ListOfCarsAfterDelay:MutableList<Int>):MutableList<Boolean>{
    var ListOfCarsAfterDelayBoolean: MutableList<Boolean> = mutableListOf()
    var trueOrFalse:Boolean = true
    for (car in ListOfCarsAfterDelay){
        if (car==1){
            trueOrFalse = true
        }
        if (car==0){
            trueOrFalse = false
        }
        ListOfCarsAfterDelayBoolean.add(trueOrFalse)
    }
    return ListOfCarsAfterDelayBoolean
}