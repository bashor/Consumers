public class ConsumerProvider<T>(vararg consumers: Consumer<T>){
    val consumers = arrayList<Consumer<T>>(*consumers)

    fun process(data: T): Response {
        val responses = consumers.map { it.process(data) }
        val error = responses.find { it.status == Status.ERROR }
        if (error != null) {
            return error
        }

        val consumed = responses.find { it.status == Status.CONSUMED }
        if (consumed != null) {
            return consumed
        }

        return Response(Status.ERROR, "Message was not prcessed.")
    }
}

//public trait ConsumerRegistrator<T> {
//    fun registration(consumer: Consumer<T>)
//}
