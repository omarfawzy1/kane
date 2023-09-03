package terminal

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import java.io.*
import java.util.logging.Logger
import kotlin.concurrent.thread

class Terminal {
    private val mutex = Mutex()
    private val thread = TerminalThread(arrayListOf(), mutex)
    fun addTerminalCommand(command: String){
        thread.output.println(command)
        println("Command Added")

    }
    fun getTerminalOutputFlow() = flow {

        thread.start()

        println("Continued")
        while(thread.isAlive && !thread.end){
            mutex.withLock{
                emit(thread.list.removeFirstOrNull())
            }
            delay(500)
        }
    }.flowOn(Dispatchers.Default)

    fun close(){
        thread.end = true
        thread.interrupt()
        println("Thread Should Be Closed")

    }
}