class Solution {
    fun evalRPN(tokens: Array<String>): Int {

        val stack = ArrayDeque<Int>()
        val operation = mutableMapOf<String, ((Int, Int) -> Int)>(
            "+" to {a, b -> a+b},
            "-" to {a, b -> a-b},
            "*" to {a, b -> a*b},
            "/" to {a, b -> a/b}
        )

        for(i in 0 until tokens.size){
            if(operation.contains(tokens[i])){
                val b = stack.removeLast()
                val a = stack.removeLast()
                stack.addLast(operation[tokens[i]]!!.invoke(a, b))
            }else{
                stack.addLast(tokens[i].toInt())
            }
        }

        return stack.last()
    }
}
