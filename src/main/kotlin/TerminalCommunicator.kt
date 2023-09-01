import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import java.io.*
import kotlin.properties.Delegates

class TerminalCommunicator {
    class TerminalOutput(val queue : ArrayList<String> = arrayListOf()) : Flow<String> {
        override suspend fun collect(collector: FlowCollector<String>) {
            if(queue.isNotEmpty()) {
                collector.emit(queue.last())
                queue.removeLast()
            }
        }
    }

    class TerminalInput(){
        var onChange : () -> Unit = { println("maybe!")}
        var queue : ArrayList<String> by Delegates.observable(arrayListOf(""), {_, _, _ -> onChange() })
    }
//        val address = "E:\\Projects\\Compose\\Kane\\src\\test\\resources\\code.cpp"
//        val outAddress = "E:\\Projects\\Compose\\Kane\\src\\test\\resources"
//val cmd = "g++ $address -o $outAddress"
    class Terminal(val terminalInput: TerminalInput, val terminalOutput: TerminalOutput) {
        var end = false
        val cmds = arrayOf("cmd")
        var runtime : Process = Runtime.getRuntime().exec(cmds)
        val inpt = BufferedReader(InputStreamReader(runtime.inputStream))
        val out = PrintWriter(BufferedWriter(OutputStreamWriter(runtime.outputStream)), true)


        suspend fun start() {
            terminalInput.onChange = {
                println("some thing changed")
                out.println(terminalInput.queue.last())
                terminalInput.queue.removeLast()
            }
            susReading()
        }

        suspend fun susReading() = withContext(Dispatchers.IO){
            var line = ""
            while (!end && inpt.ready() && inpt.readLine().also { line = it } != null) {
                terminalOutput.queue.add(line)
                delay(500)
            }
        }
    }
}