class MinStack() {
    //3: 00
    val primary = ArrayDeque<Int>()
    val min = ArrayDeque<Int>()

    fun push(`val`: Int) {
        primary.addLast(`val`)
        if(min.isEmpty() || min.last() > `val`){
            min.addLast(`val`)
        }else{
            min.addLast(min.last())
        }
    }

    fun pop() {
        primary.removeLast()
        min.removeLast()
    }

    fun top(): Int {
        return primary.last()
    }

    fun getMin(): Int {
        return min.last()
    }
}