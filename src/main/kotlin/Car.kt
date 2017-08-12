import java.util.*

class Car(val id: Int, var wantsToDrive: Boolean = true) {

    var isDelayed: Boolean = false
    val isDelayedAtHour : MutableList<Int> = mutableListOf()
    val wantsToDriveAtHour : MutableList<Int> = mutableListOf()

    fun wantsToDriveAtHour(hour: Int): Boolean {
        return wantsToDriveAtHour.contains(hour)
    }

    fun isDelayedAtHour(hour: Int): Boolean {
        return isDelayedAtHour.contains(hour)
    }
}
