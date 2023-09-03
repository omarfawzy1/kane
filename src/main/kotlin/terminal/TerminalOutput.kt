package terminal

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector

class TerminalOutput (val queue : ArrayList<String> = arrayListOf()) : Flow<String> {
    override suspend fun collect(collector: FlowCollector<String>) {
        if(queue.isNotEmpty()) {
            collector.emit(queue.first())
            queue.removeFirst()
        }
    }

    fun add(element : String) : Boolean{
        return queue.add(element)
    }

}