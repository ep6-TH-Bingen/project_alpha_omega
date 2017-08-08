
import com.univocity.parsers.common.record.Record
import com.univocity.parsers.csv.CsvParser
import com.univocity.parsers.csv.CsvParserSettings
import com.univocity.parsers.csv.CsvWriter
import com.univocity.parsers.csv.CsvWriterSettings

fun main(args: Array<String>) {



        }


    private fun readCarFromCsv(fileName: String): Network {
    //Changed the return "Car" into "Network", because there is the "listOfCars" ...?? is that the right way?

        val settings = CsvParserSettings()
        settings.format.setLineSeparator("\n")
        settings.isHeaderExtractionEnabled = true

        val csvParser = CsvParser(settings)
        val reader = FileAccess().getReader(fileName)
        val carRows: MutableList<Record> = csvParser.parseAllRecords(reader)

    // same here with "Network()"
        val car = Network()

        for (record in carRows) {
            val carID = record.values.get(0)
            val carStatus = record.values.get(1)


        }
