fun main() {
val banker = Banker("Nancy",24,56.0)
    println(banker.name)
    banker.talk("Hello customer!")
    banker.eat()
    banker.sleep()
    println( banker.countMoney(arrayOf(100,100,100,100)))

    var doctor = Doctor("Purity",28,8.0,6.1)
    println(doctor.name)
    doctor.eat()
    println(doctor.countMoney(arrayOf(45,34,42)))
    doctor.sleep()
    doctor.talk("Hi")
    doctor.treatPatient("Kimani","malaria")

    var farmer = Farmer("John",30)
    println(farmer.name)
    farmer.eat()
    farmer.talk("New crops")
    farmer.sleep()
    farmer.cultivateLand()

    val doctor1 = Doctor("June",45,5.3,5.6)
    doctor1.introduction()

    val farmer1 = Farmer("Jose",65)
    farmer1.introduction()

    val banker1 = Banker("Sam",43,4.5)
    banker1.eat()

}
//In the context of a class, the : says inheritance from another class
//main class with all the properties
//helps to define all the common activities that will be done in the children classes
//this is by opening up the base class and make children classes to implement the methods of the parent or more
//super class in Person(we inherit from) we use [open] keyword to allow parent to be inherited from. Banker becomes sub-class
open class Person(var name: String,var age:Int){
    fun talk(words: String) {
        println(words)
    }
    open fun eat() {
        println("Yum")
    }
    fun sleep() {
        println("Zzzzzz")
    }
    open fun introduction (){
        println("Hi, my name is $name")
    }
}
//make the parent class = Person open
//remove var in defining parameters
//when the child class is created in the base class, it collects the same properties and prompts to override
open class Banker(name:String,age: Int, var weight:Double):Person(name, age){

    fun countMoney(notes:Array<Int>):Int{
        return notes.sum()
    }
}
//another class outside
//the doctor is able to inherit methods from banker and from person at the same time
//one class cannot to link to more than one class but can inherit from a lineage of classes
class Doctor(name: String,age:Int,weight: Double,height:Double):Banker(name, age, weight){
    fun treatPatient (patientName:String,disease:String){
        println("Treat $patientName for $disease")
        }

    override fun introduction() {
        
        println("Hi, my name is Dr.$name")
    }
}
//another class with same properties
class Farmer(name: String,age:Int):Person(name,age) {
    fun cultivateLand(){
        println("dig dig dig")
    }
    override fun eat(){   //let's us ignore the function eat from base person
        super.eat()   //let's us modify the function that existed in person, the parent class. And ignore it too
        println("I am eating the beans from my farm")
    }
}
