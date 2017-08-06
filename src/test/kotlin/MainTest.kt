import org.junit.Test
import org.junit.Assert.assertEquals

class MainTest {

    @Test
    fun testCsvReading1Entry1() {
        //SETUP
        //EXECUTE
        val f = readCsvInput1().get(0)
        //ASSERT
        assertEquals(1,f)

    }
    @Test
    fun testCsvReading1Entry5() {
        //SETUP
        //EXECUTE
        val f = readCsvInput1().get(4)
        //ASSERT
        assertEquals(5,f)

    }
    @Test
    fun testCsvReading1Entry10() {
        //SETUP
        //EXECUTE
        val f = readCsvInput1().get(9)
        //ASSERT
        assertEquals(10,f)

    }
    @Test
    fun testCsvReading2Entry1() {
        //SETUP
        //EXECUTE
        val f = readCsvInput2().get(0)
        //ASSERT
        assertEquals(1,f)

    }
    @Test
    fun testCsvReading2Entry5() {
        //SETUP
        //EXECUTE
        val f = readCsvInput2().get(4)
        //ASSERT
        assertEquals(0,f)

    }
    @Test
    fun testCsvReading2Entry10() {
        //SETUP
        //EXECUTE
        val f = readCsvInput2().get(9)
        //ASSERT
        assertEquals(1,f)

    }
}
