package python_runner

import jep.Interpreter
import jep.SharedInterpreter
import org.junit.Test

import org.junit.Assert.*

class PythonRunnerTest {

    @Test
    fun runCode() {
        val interpreter: Interpreter = SharedInterpreter()
        interpreter.runScript("src/main/python/script1.py")
        assert(interpreter.getValue("Home") == "this is home")
    }
}