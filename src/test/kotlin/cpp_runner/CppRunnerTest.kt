package cpp_runner

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import org.junit.Test
import java.io.*


class CppRunnerTest {
    class flow : Flow<String>{
        override suspend fun collect(collector: FlowCollector<String>) {
            collector.emit("")
        }

    }
    @Test
    fun test1(){
        val address = "E:\\Projects\\Compose\\Kane\\src\\test\\resources\\code.cpp"
        val outAddress = "E:\\Projects\\Compose\\Kane\\src\\test\\resources"
        val cmd = "g++ $address -o $outAddress"
        val cmds = arrayOf("cmd")
        val p = Runtime.getRuntime().exec(cmds) ?: return

        val inpt = BufferedReader(InputStreamReader(p.inputStream))
        val out = PrintWriter(BufferedWriter(OutputStreamWriter(p.outputStream)), true)
        var line = ""

        while (inpt.readLine().also { line = it } != null) {
            if (line.contains("E1E5E6E7")) {
                inpt.readLine()
                break
            }
        }
        out.println("echo omar")
        out.println("echo E1E5E6E7")


        while (inpt.readLine().also { line = it } != null && !line.contains("E1E5E6E7")) {
            println("-- $line")
        }

        p.destroy()

        assert(true)
    }


}