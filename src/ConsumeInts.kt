public class ConsumeInts: Consumer<String> {
    override fun process(data: String): Response {
        try {
            Integer.valueOf(data)
        } catch (e: NumberFormatException) {
            return Response(Status.ERROR, "ConsumeInts: Wrong format.")
        }

        return Response(Status.CONSUMED)
    }

}