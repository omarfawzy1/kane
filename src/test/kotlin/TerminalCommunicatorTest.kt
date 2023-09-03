import kotlinx.coroutines.*
import org.junit.Test
import terminal.*
import java.util.logging.Logger

class TerminalCommunicatorTest{
//    @Test
//    fun test(){
//        runBlocking{
//            val inpt = TerminalInput({})
//            val output = TerminalOutput()
//            val terminal = Terminal(inpt, output)
//
//            println("Started")
//
//
//            terminal.start()
//
//
//            inpt.add("echo hello")
//            output.collect{
//                println(it)
//            }
//            //val v = Logger.getLogger("l1")
//            println("Waiting")
//            for (i in 1..50) {
////                v.info("Printing.isWaiting")
//                output.collect{
//                    println(it)
//                }
//                if (output.queue.isNotEmpty())
//                    println(output.queue.removeFirstOrNull())
//                Thread.sleep(1000)
//            }
//            println("End")
//            assert(true)
//        }
//    }

//    @Test
//    fun delgateTest(){
////        val arr = ObservableArrayList<String>{
////            println("hello")
////        }
////
////        arr.add("omar")
////
////        arr.onChange = {
////            println("something new")
////        }
////
////        arr.add("is it new")
//
//        Thread.sleep(2000)
//        assert(true)
//    }


    @Test
    fun nw(){
        runBlocking {
            val terminal = Terminal()
            launch {
                terminal.getTerminalOutputFlow().collect{ if(it != null) println(it) }
            }


            println("Main is Adding Command")
            terminal.addTerminalCommand("echo hellow")
            println("Main Thread Continued")
            delay(10_000)

            terminal.close()
            assert(true)
        }
    }
}