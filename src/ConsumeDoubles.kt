public class ConsumeDoubles: Consumer<String> {
    override fun process(data: String): Response {
        try {
            java.lang.Double.valueOf(data)
        } catch (e: NumberFormatException) {
            return Response(Status.ERROR, "ConsumeDoubles: Wrong format.")
        }

        return Response(Status.CONSUMED)
    }

}