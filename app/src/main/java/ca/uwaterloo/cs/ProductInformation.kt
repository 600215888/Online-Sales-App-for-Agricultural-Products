package ca.uwaterloo.cs

import android.content.Context
import java.io.File
import java.io.FileOutputStream
import java.io.ObjectOutputStream
import java.io.Serializable

data class ProductInformation(
    val id: Int = 1, // Internal id number of product, should we store this?
    var name: String = "",
    var description: String = "",
    var price: Int = 0,
    var amount: Long = 0,
    val images: ArrayList<String> = arrayListOf()
) : Serializable {

    fun exportData(context: Context) {
        // TODO: platform compatibility
        // TODO: save to platform
        println(context.filesDir)
        println("${context.filesDir}/out.txt")
        val dir = File("${context.filesDir}/out")
        if (!dir.exists()) {
            dir.mkdir()
        }
        val file = File(dir, "$id.txt")
        println(file.absolutePath)
        if (file.exists())
        {
            file.delete()
        }
        file.createNewFile()
        val fileOS = FileOutputStream(file)
        val outStream = ObjectOutputStream(fileOS)
        outStream.writeObject(this)
        outStream.close()
        fileOS.close()
    }
}
// TODO: FIX images to image array
// TODO: load data
