fun main(args: Array<String>) {
    val provider = ConsumerProvider<String>(
            Logger(),
            ConsumeInts(),
            ConsumeDoubles()
    )

    while (true) {
        val data = readLine()
        if (data != null) {
            val resp = provider.process(data)
            println(resp)
            println()
        }
    }
}