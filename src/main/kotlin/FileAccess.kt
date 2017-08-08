import java.io.*

/**
 * Created by Ralf on 08.08.2017.
 */
class FileAccess {

    fun getReader(path: String): Reader {
        return InputStreamReader(this.javaClass.getResourceAsStream(path), "UTF-8")
    }

    fun getWriter(path: String): Writer {
        val file = File(path)
        return FileWriter(file)
    }
}