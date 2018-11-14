import java.io.FileWriter
import java.io.IOException
import java.util.*

fun main(args: Array<String>){

    var allClinitiansList = arrayListOf<Clinitian>()

    //create clinitian
    var clinitian1 = Clinitian("Yahya Borislav, NP", "Arron Alfhard", "237-8034", "42172", "Los Angeles East")
    var clinitian2 = Clinitian("Uzoma Petra , MD", "Gunter Viktoria", "237-8802", "4200", "Miami west")
    var clinitian3 = Clinitian("Slavica Kamal, NP", "Edison Sladjana", "237-8629", "41537", "Albuquerque")
    var clinitian4 = Clinitian("Silvius Laurentine , NP", "Sidonie Maja", "237-8835", "42099", "New York")
    var clinitian5 = Clinitian("Govinda Eminee , NP", "Ambrogio Gianpiero", "237-3860", "40206", "Las Vegas")
    //add all to a list then filter and add to another list
    allClinitiansList.addAll(listOf(clinitian1, clinitian2, clinitian3, clinitian4, clinitian5))



    Collections.sort(allClinitiansList, { s1: Clinitian, s2: Clinitian -> s1.clinitianName.compareTo(s2.clinitianName, ignoreCase = true)  })
    for (data in allClinitiansList){
        println("DL" + data.clinitianName + "\t\t" + data.location)
    }

    val CSV_HEADER = "Location, Clinitian Name, MA Name, MA Phone#, Flowcast #"

    var fileWriter: FileWriter? = null
    try {
        fileWriter = FileWriter("Clinitians.csv")


        fileWriter.append(CSV_HEADER)
        fileWriter.append('\n')

        for (customer in allClinitiansList) {
            fileWriter.append(customer.location)
            fileWriter.append(',')
            fileWriter.append(customer.clinitianName)
            fileWriter.append(',')
            fileWriter.append(customer.medicalAssistantName)
            fileWriter.append(',')
            fileWriter.append(customer.medicalAssistantPhoneNumber)
            fileWriter.append(',')
            fileWriter.append(customer.flowCastNumber)
            fileWriter.append('\n')
        }

        println("Write CSV successfully!" )
    } catch (e: Exception) {
        println("Writing CSV error!")
        e.printStackTrace()
    } finally {
        try {
            fileWriter!!.flush()
            fileWriter.close()
        } catch (e: IOException) {
            println("Flushing/closing error!")
            e.printStackTrace()
        }
    }
}