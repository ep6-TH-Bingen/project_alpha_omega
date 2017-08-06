fun scenario(numberOfCars:Int) {
    val car = Car()
    val a = car.interestOfDriving(numberOfCars)
    println(a)
    println(car.announceDriving(a))
    val network = Network()
    val capacity = network.capacity
    val b = network.tallyUpCars(a)
    val c = network.compareCapacity(b)
    println("The number of cars that want to drive is: $b")
    println("The capacity of the network is: $capacity")
    println("Therefor the cars that are allowed to drive are: $c")
    /*val numberOfCarsThatWantToDrive = numberOfCars * valueOfCarsThatWantToDrive
    val x = numberOfCarsThatWantToDrive / capacity
    val y = switchCase(x)
    val z = applyingDelay(y)*/
}
    /*
    less than at 50% capacity: 5% chance of delay
    less than at 70% capacity: 10% chance of delay
    less than at 90% capacity: 20% chance of delay
    less than at 110% capacity: 30% chance of delay
    less than at 125% capacity: 50% chance of delay
    less than at 150% capacity: 70% chance of delay
    above 150% capacity: 90% chance of delay
    x > 1.5 -> y = 0.9
    1.25 <= x <= 1.5 -> y = 0.7
    1.1 <= x < 1.25 -> y = 0.5
    0.9 <= x < 1.1 -> y = 0.3
    0.7 <= x < 0.9 -> y = 0.2
    0.5 <= x < 0.7 -> y = 0.1
    x < 0.5 -> y= 0.05
*/
/*
    fun switchCase(x:Double):Double {
        var y :Double = 0.0
        if (x > 1.5) {
            y = 0.9
        }
        if ((1.25 <= x) && (x <= 1.5)) {
            y = 0.7
        }
        if ((1.1 <= x) && (x <= 1.25)) {
            y = 0.5
        }
        if ((0.9 <= x) && (x <= 1.1)) {
            y = 0.3
        }
        if ((0.7 <= x) && (x <= 0.9)) {
            y = 0.2
        }
        if ((0.5 <= x) && (x <= 0.7)) {
            y = 0.1
        }
        if (x < 0.5) {
            y = 0.05
        }
        return y
    }
 fun applyingDelay(y:Double):Double{
     //for (car in cars){
         val z = Math.random()
         if (y > z) {
            //apply delay for every car that fulfils this specific criteria and substract the ones that were delayed from the cars that want to drive
             //newvalue = 0
             //
         }
     //}
     return 0.0
 }
*/