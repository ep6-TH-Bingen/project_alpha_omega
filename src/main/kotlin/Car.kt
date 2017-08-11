class Car(val id: Int, val wantsToDrive: Boolean) {

    var isDelayed: Boolean = false
    val isDelayedAtHour : MutableList<Int> = mutableListOf()
    val wantsToDriveAtHour : MutableList<Int> = mutableListOf()

}
