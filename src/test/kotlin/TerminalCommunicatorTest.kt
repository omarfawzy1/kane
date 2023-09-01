import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.properties.Delegates

class TerminalCommunicatorTest{
    @Test
    fun test(){
        val inpt = TerminalCommunicator.TerminalInput()
        val output = TerminalCommunicator.TerminalOutput()
        val terminal = TerminalCommunicator.Terminal(inpt, output)
        runBlocking {
            launch {
                coroutineScope{
                    println("Started")
                    terminal.start()
                }
            }
            launch {
                coroutineScope {
                    inpt.queue.add("echo hello")

                    println("Waiting")
                    for (i in 1..50){
                        if(output.queue.isNotEmpty())
                            println(output.queue.removeFirstOrNull())
                        Thread.sleep(1000)
                    }
                    println("End")
                }
            }


            assert(true)
        }


    }
    class ObservableArrayList<T>(var onChange : () -> Unit) : ArrayList<T>(){
        override fun add(element: T): Boolean {
            onChange()
            return super.add(element)
        }
    }
    @Test
    fun delgateTest(){
        val queue : MutableList<String> by Delegates.observable(mutableListOf())
        { _, _, _ -> println("Something changed") }

        val arr = ObservableArrayList<String>{
            println("hello")
        }

        arr.add("omar")

        arr.onChange = {
            println("something new")
        }

        arr.add("is it new")

        Thread.sleep(2000)
        assert(true)

    }
}