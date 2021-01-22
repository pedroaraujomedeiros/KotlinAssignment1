package work.nbcc.kotlinassignment1

data class Counter(var counter: Int = 0){

    override fun toString(): String {
        return counter.toString()
    }
}