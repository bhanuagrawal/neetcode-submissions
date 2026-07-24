class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {

        val stack = ArrayDeque<Int>()
        stack.addLast(0)

        val result = IntArray(temperatures.size)
        for(i in 1 until temperatures.size){

            while(stack.isNotEmpty()){
                val last = stack.last()
                if(temperatures[last] < temperatures[i]){
                    result[last] = i - last
                    stack.removeLast()
                }else{
                    break
                }
            }
            stack.add(i)
        }

        return result
    }
}
