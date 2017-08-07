import com.univocity.parsers.csv.CsvParser
import com.univocity.parsers.csv.CsvParserSettings
import com.univocity.parsers.csv.CsvWriter
import com.univocity.parsers.csv.CsvWriterSettings
import java.io.*

fun main(args: Array<String>) {
    readCsvInput1()
    readCsvInput2()
    writeCsvOutput()
}

fun readCsvInput1():Boolean {
    val settings = CsvParserSettings()
    settings.isHeaderExtractionEnabled = true
    val parser = CsvParser(settings)
    settings.format.setLineSeparator("\n")
    val csvParser = CsvParser(settings)
    val reader = FileAccess().getReader("/input.csv")
    val allRows = csvParser.parseAllRecords(reader)
    val road = Network(10)
    val car = Car(true, road)
    val wantsToDrive = car.wantsToDrive
    for (record in allRows){
        wantsToDrive.add(record.values.get(0).toBoolean())
    }
    return wantsToDrive
}
fun readCsvInput2():Boolean? {
    val settings = CsvParserSettings()
    settings.isHeaderExtractionEnabled = true
    val parser = CsvParser(settings)
    settings.format.setLineSeparator("\n")
    val csvParser = CsvParser(settings)
    val reader = FileAccess().getReader("/input.csv")
    val allRows = csvParser.parseAllRecords(reader)
    val road = Network(10)
    val car = Car(true, road)
    var delayed = car.delayed
    for (record in allRows){
        delayed.add(record.values.get(1).toBoolean())
    }
    return delayed
}
private fun writeCsvOutput() {
    val settings = CsvWriterSettings()
    settings.format.setLineSeparator("\n")
    val writer = FileAccess().getWriter("output.csv")
    val csvWriter = CsvWriter(writer, settings)
    csvWriter.writeHeaders("Wants to drive" , "Delay")

    val carRows: MutableList<Array<Any>> = mutableListOf()
    //need Car Class for that
    /*        for (car in bank.customers) {
            val name = customer.name

            val balance: lol.Balance = bank.balance(customer.defaultAccount)
            val balanceString = balanceToString(balance)
            val limit: lol.Balance = bank.limit(customer.defaultAccount)
            val limitString = balanceToString(limit)
            val row: Array<Any> = arrayOf(name, balanceString, limitString)
            carRows.add(row)
        }
        */

    csvWriter.writeRowsAndClose(carRows)
}
class FileAccess {

    fun getReader(path: String): Reader {
        return InputStreamReader(this.javaClass.getResourceAsStream(path), "UTF-8")
    }

    fun getWriter(path: String): Writer {
        val file = File(path)
        return FileWriter(file)
    }

}