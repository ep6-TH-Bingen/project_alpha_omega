class Car(val id: Int, var wantsToDrive: Boolean) {

    var isDelayed: Boolean = false
    val isDelayedAtHour : MutableList<Int> = mutableListOf()
    val wantsToDriveAtHour : MutableList<Int> = mutableListOf()

}
