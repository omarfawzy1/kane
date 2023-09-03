package terminal

import kotlin.properties.Delegates
/*
*   Acts as a queue for the Terminal to execute
 */
class TerminalInput(var onChange : () -> Unit) : ArrayList<String>() {
    /*
    * adds the element to the queue and calls the onChange function
    */
    override fun add(element: String): Boolean {
        if(super.add(element)) {
            onChange()
            return true
        }
        return false
    }
    /*
    * returns first element in the queue or null and deletes it
     */
    fun take() : String? {
        return this.removeFirstOrNull()
    }
}