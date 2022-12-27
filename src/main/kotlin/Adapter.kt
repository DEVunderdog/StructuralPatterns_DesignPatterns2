// We use adapter to connect the some other thing to something.
// For example, we have 3rd party functionality and we have to use in our local code. Here's the importing doesn't work.
// And you have to use that functionality in your local code. Hence, adapter is going to connect both of them.

data class DisplayDataType(val index: Float, val data:String)

class DataDisplay{
    fun displayData(data: DisplayDataType){
        println("Data is Displayed: ${data.index} - ${data.data}")
    }
}

data class DatabaseData(val position: Int, val amount:Int)

class DatabaseDataGenerator{
    fun generateData():List<DatabaseData>{
        val list = arrayListOf<DatabaseData>()
        list.add(DatabaseData(2,2))
        list.add(DatabaseData(3,7))
        list.add(DatabaseData(5,23))
        return list
    }
}

interface DatabaseDataConverter{
    fun convertData(data: List<DatabaseData>): List<DisplayDataType>
}

class DataDisplayAdapter(val display: DataDisplay): DatabaseDataConverter{
    override fun convertData(data: List<DatabaseData>): List<DisplayDataType> {
        val returnList = arrayListOf<DisplayDataType>()
        for(dataum in data){
            val ddt = DisplayDataType(dataum.position.toFloat(),dataum.amount.toString())
            display.displayData(ddt)
            returnList.add(ddt)
        }
        return returnList
    }
}