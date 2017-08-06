/*
import com.univocity.parsers.csv.CsvParser
import com.univocity.parsers.csv.CsvParserSettings
import com.univocity.parsers.csv.CsvWriter
import com.univocity.parsers.csv.CsvWriterSettings
import java.io.*
import java.util.*
*/
fun main(args: Array<String>) {
    //readCsvInput()
    scenario(10)
    //writeCsvOutput()
}
/*
 private fun readCsvInput() {
    val settings = CsvParserSettings()
    settings.isHeaderExtractionEnabled = true
    val parser = CsvParser(settings)
    settings.format.setLineSeparator("\n")
    val csvParser = CsvParser(settings)
    val reader = FileAccess().getReader("/input.csv")
    val allRows = csvParser.parseAllRecords(reader)

    val car = Car()
    for (record in allRows){
        val carNumber = record.values.get(0).toInt()
        val intestToDrive = record.values.get(1).toInt()
        //TO DO: Zuweisung des "Interests to drive"

    }

}
private fun writeCsvOutput() {
        val settings = CsvWriterSettings()
        settings.format.setLineSeparator("\n")
        val writer = FileAccess().getWriter("output.csv")
        val csvWriter = CsvWriter(writer, settings)
        csvWriter.writeHeaders("Car Number", "Interest to drive(1=wants to drive,0=does not want to drive)", "Delay(0=not delayed,1=delayed)")

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
*/