public trait Consumer<T> {
    fun process(data: T): Response
}