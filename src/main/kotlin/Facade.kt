// Provides a simple interface to a complex functionality.
// Removes the need for complex object / memory management
// Simplifies client implementation.

class ComplexSystemStore(private val filePath: String){
    private val cache: HashMap<String, String>

    init{
        println("reading data from the file: $filePath")
        cache = HashMap()
        // Read properties from file and put to cache.
    }

    fun store(key:String, value:String){
        cache[key] = value
    }

    fun read(key:String) = cache[key] ?: ""

    fun commit() = println("Storing cached data to file $filePath")


}

data class User(val login:String)

// Facade
// It does simple task. Just made a complex class into working by using just two classes.

class UserRepository{
    private val systemPreference = ComplexSystemStore("/data/default.prefs")

    fun save(user:User){
        systemPreference.store("USER_KEY", user.login)
        systemPreference.commit()
    }

    fun findFirst() : User = User(systemPreference.read("USER_KEY"))
}

fun main(args:Array<String>){

    val userRepo = UserRepository()
    val user = User("Join")
    userRepo.save(user)

    val retrieved = userRepo.findFirst()

}