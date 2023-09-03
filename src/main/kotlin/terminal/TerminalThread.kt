package terminal

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import java.io.*

class TerminalThread(val list : ArrayList<String>, val mutex : Mutex, var end : Boolean = false) : Thread() {
    val cmds = arrayOf("cmd")
    val runtime : Process = Runtime.getRuntime().exec(cmds)
    val input = BufferedReader(InputStreamReader(runtime.inputStream))
    val output = PrintWriter(BufferedWriter(OutputStreamWriter(runtime.outputStream)), true)

    override fun run() {
        super.run()
        try {
            runBlocking(Dispatchers.IO) {
                println("Thread Started")
                readLines()
                println("Thread Ended")
            }
        } catch (e : InterruptedException){
            println("Thread Closed Peacefully")
        }
    }

    override fun interrupt() {
        println("Thread Interrupted")
        end = true
        super.interrupt()
    }

    suspend fun readLines() = withContext(Dispatchers.IO){
        try {
            var line = ""
            while (!end) {
                if (!input.ready()) {
                    delay(500)
                    continue
                }
                line = input.readLine()
                mutex.withLock {
                    list.add(line)
                }
            }
        }
        catch (e : InterruptedException){
            println("Thread Interrupted")
        }
    }

//
//    fun getOutput() = flow {
//        val mut = Mutex()
//        val n = TerminalThread(arrayListOf(), mut)
//        println("calling Tread start")
//        try {
//            n.start()
//            delay(100)
//        }
//        catch(e : Exception) {
//            println(e.message)
//        }
//        println("called done")
//
//
//        while (n.isAlive){
//            mut.withLock{
//                emit(n.list.removeFirstOrNull())
//            }
//            delay(500)
//        }
//    }.flowOn(Dispatchers.IO)
}