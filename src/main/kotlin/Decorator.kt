// Decorator means attaching a new behaviour to an object without altering existing code and overriding behaviour.

interface CoffeeMachine{
    fun makeSmallCoffee()
    fun makeLargeCoffee()
}

class NormalCoffeeMachine: CoffeeMachine{
    override fun makeSmallCoffee() {
        println("Normal coffee machine: Making small coffee")
    }

    override fun makeLargeCoffee(){
        println("Normal coffee machine: Making large coffee")
    }
}

// Decorator
// Delegation is used.
class EnhancedCoffeeMachine(private val coffeeMachine:CoffeeMachine): CoffeeMachine by coffeeMachine{

    override fun makeLargeCoffee() {
        println("Enhanced coffee machine: Making large coffee")
    }

    fun makeMilkCoffee(){
        println("Enhanced coffee machine : Making milk coffee")
        coffeeMachine.makeSmallCoffee()
        println("Enhanced coffee machine: Adding Milk")
    }
}

fun main(args:Array<String>){
    val normalMachine = NormalCoffeeMachine()
    val enhancedMachine = EnhancedCoffeeMachine(normalMachine)
    enhancedMachine.makeSmallCoffee()
    enhancedMachine.makeLargeCoffee()
    enhancedMachine.makeMilkCoffee()

}

