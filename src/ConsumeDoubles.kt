public class ConsumeDoubles: Consumer<String> {
    override fun process(data: String): Response {
        if (!data.startsWith('N') && !data.startsWith('D'))
            return Response(Status.UNCONSUMED)

        try {
            data.substring(1).toDouble()
        } catch (e: NumberFormatException) {
            return Response(Status.ERROR, "ConsumeDoubles: Wrong format.")
        }

        return Response(Status.CONSUMED)
    }

}