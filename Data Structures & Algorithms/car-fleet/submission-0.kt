class Solution {
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        val time = position.mapIndexed{ index, value ->
            val time = (target - position[index]).toDouble() / speed[index]
            Pair(position[index], time)
        }.sortedBy{
            -it.first
        }.map{
            it.second
        }



        var stack = ArrayDeque<Double>()
        stack.add(time[0])
        for(i in 1 until time.size){
        
            if(time[i] > stack.last()){
                stack.addLast(time[i])
            }
        }

        //println(time.joinToString())
        return stack.size
    }
}
