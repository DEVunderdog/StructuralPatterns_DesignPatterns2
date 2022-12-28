// Bridge is way of connecting things.
// Suppose

/*
           -> BlueCircle
ShapeColor -> RedCircle
           -> RedSquare
           -> BlueSquare

We have created a ShapeColor classes and we are enhancing that class characteristics. Each time we are changing the
characteristics then we have plenty of subclasses.

Better solution is that to separate the characteristics and connect them.

        -> Circle
        |
Shape --|
  |     |
  |     -> Square
Connected To
  |
  |      -> Red
  |      |
Color -- |
         -> Blue

Eventually as characteristics increases then sub classes will increase independently

But here's the problem with this approach.

Having classes with multiple orthogonal traits exponentially increases the size of the inheritance tree. Orthogonal traits
means interconnected.

So the bridge is way of splitting things into multiple interface and connect them.

 */

interface Device{
    var volume: Int
    fun getName(): String
}

class Radio: Device{
    override var volume = 0
    override fun getName() = "Radio $this"
}

class TV:Device{
    override var volume = 0
    override fun getName() = "TV $this"
}

interface Remote{
    fun volumeUp()
    fun volumeDown()
}

class BasicRemote(val device: Device): Remote{
    override fun volumeUp(){
        device.volume++
        println("${device.getName()} volume up : ${device.volume}")
    }
    override fun volumeDown(){
        device.volume--
        println("${device.getName()} volume down: ${device.volume}")
    }
}

fun main(args:Array<String>){
    val tv = TV()
    val radio = Radio()

    val tvRemote = BasicRemote(tv)
    val radioRemote = BasicRemote(radio)

    tvRemote.volumeUp()
    tvRemote.volumeUp()
    tvRemote.volumeDown()

    radioRemote.volumeUp()
    radioRemote.volumeUp()
    radioRemote.volumeUp()
    radioRemote.volumeDown()
}

