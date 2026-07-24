class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {

        val stack = ArrayDeque<Int>()
        stack.addLast(0)

        for(i in 1 until temperatures.size){

            while(stack.isNotEmpty()){
                val last = stack.last()
                if(temperatures[last] < temperatures[i]){
                    temperatures[last] = i - last
                    stack.removeLast()
                }else{
                    break
                }
            }
            stack.add(i)
        }


        while(stack.isNotEmpty()){
            temperatures[stack.removeLast()] = 0
        }
        return temperatures
    }
}
