public class ConsumeInts: Consumer<String> {
    override fun process(data: String): Response {
        if (!data.startsWith('N') && !data.startsWith('I'))
            return Response(Status.UNCONSUMED)

        try {
            data.substring(1).toInt()
        } catch (e: NumberFormatException) {
            return Response(Status.ERROR, "ConsumeInts: Wrong format.")
        }

        return Response(Status.CONSUMED)
    }

}