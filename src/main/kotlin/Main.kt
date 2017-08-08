import com.univocity.parsers.common.record.Record
import com.univocity.parsers.csv.CsvParser
import com.univocity.parsers.csv.CsvParserSettings
import com.univocity.parsers.csv.CsvWriter
import com.univocity.parsers.csv.CsvWriterSettings

fun main(args: Array<String>) {

    val cars = readNetworkFromCsv("/cars.csv")

    println(cars)
/*
    val car1 = cars.listOfCars.get(0)
    val car2 = cars.listOfCars.get(1)
    val car3 = cars.listOfCars.get(2)
    val car4 = cars.listOfCars.get(3)
    val car5 = cars.listOfCars.get(4)
    val car6 = cars.listOfCars.get(5)
    val car7 = cars.listOfCars.get(6)
    val car8 = cars.listOfCars.get(7)
    val car9 = cars.listOfCars.get(8)
    val car10 = cars.listOfCars.get(9)
    val car11 = cars.listOfCars.get(10)
    val car12 = cars.listOfCars.get(11)
    val car13 = cars.listOfCars.get(12)
    val car14 = cars.listOfCars.get(13)
    val car15 = cars.listOfCars.get(14)
*/

}


private fun readNetworkFromCsv(fileName: String): Network {
    //Changed the return "Car" into "Network", because there is the "listOfCars" ...?? is that the right way?

    val settings = CsvParserSettings()
    settings.format.setLineSeparator("\n")
    settings.isHeaderExtractionEnabled = true

    val csvParser = CsvParser(settings)
    val reader = FileAccess().getReader(fileName)
    val carRows: MutableList<Record> = csvParser.parseAllRecords(reader)

    // same here with "Network()"
    // The closing bracket after "Network" is still underlined...
    val car = Network()

    for (record in carRows) {
        val carID = record.values.get(0)
        val carStatus = record.values.get(1)


    }

    return car
}