import com.univocity.parsers.common.record.Record
import com.univocity.parsers.csv.CsvParser
import com.univocity.parsers.csv.CsvParserSettings
import com.univocity.parsers.csv.CsvWriter
import com.univocity.parsers.csv.CsvWriterSettings
import java.util.*

fun main(args: Array<String>) {
    val roadNetwork = readNetworkFromCsv("/cars.csv")
    roadNetwork.analyzeNetwork()
    writeNetworkToCsv(roadNetwork, "ResultingData.csv")
}

private fun readNetworkFromCsv(fileName: String): Network {
    val capacity = 5
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

        val carWantsToDriveAtHour = car.values.get(1)
        val wannaDriveAt = carWantsToDriveAtHour.toInt()
        // "wannaDriveAt" is Type Int...probably we have to change in class "Car" Type Boolean to Int ???
        val newCar = Car(id, wannaDriveAt)
        listOfCars.add(newCar)
    }

    return Network(capacity, listOfCars)
}

private fun writeNetworkToCsv(network: Network, fileName: String) {
    val settings = CsvWriterSettings()
    settings.format.setLineSeparator("\n")

    val writer = FileAccess().getWriter(fileName)
    val csvWriter = CsvWriter(writer, settings)
    csvWriter.writeHeaders("Car-ID", "wantsToDriveAtHour", "delayed")

    val carRows: MutableList<Array<Any>> = mutableListOf()
    for (car in network.listOfCars) {
        val id = car.id
        val status = car.wantsToDrive
        val delayed = car.isDelayed
        val row: Array<Any> = arrayOf(id, status, delayed)
        carRows.add(row)
    }

    csvWriter.writeRowsAndClose(carRows)
}

fun scenario(numberOfCars: Int, capacity: Int) {
    /*
    * Creates a given a number of cars
    * A road network is created with the given capacity
    * Simulating 24 hours and prints for each hour which cars want to drive and which cars are delayed
    */
    val listOfCars: MutableList<Car> = mutableListOf()
    val road = Network(capacity, listOfCars)
    for (i in 1..numberOfCars) {
        val newCar = Car(i)
        listOfCars.add(newCar)
        for (hour in 1..24) {
            if (Random().nextBoolean()) {
                newCar.wantsToDriveAtHour.add(hour)
            }
        }
    }
    road.analyzeNetwork()
    for (hour in 1..24){
        println("Hour: $hour")
        var wantToDrive = "  Cars that want to drive: "
        var delayed =  "  Car that are delayed:    "
        for (car in listOfCars) {
            if (car.wantsToDriveAtHour(hour)) {
                wantToDrive += "${car.id}, "
            }
            if (car.isDelayedAtHour(hour)) {
                delayed += "${car.id}, "
            }
        }
        // removes the trailing comma
        println(wantToDrive.dropLast(2))
        println(delayed.dropLast(2))
    }
}
