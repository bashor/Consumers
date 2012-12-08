public class Logger: Consumer<String> {
    override fun process(data: String): Response {
        System.err.println("Logger: " + data);
        return Response(Status.UNCONSUMED)
    }
}