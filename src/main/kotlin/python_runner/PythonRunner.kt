package python_runner

import jep.Interpreter
import jep.SharedInterpreter

class PythonRunner(val path : String) {
    fun runCode(): Any {
        val interpreter: Interpreter = SharedInterpreter()
        interpreter.runScript(path)
        interpreter.exec("change_home()")
        val home = interpreter.getValue("home")
        interpreter.close()
        return home
    }
}