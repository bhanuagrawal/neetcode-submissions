class Solution {
    fun longestConsecutive(nums: IntArray): Int {

        val set = mutableSetOf<Int>()
        for(num in nums){
            set.add(num)
        }

        var max = 0

        for(num in set){

            if(!set.contains(num-1)){

                var start = num
                var current = 1
                while(set.contains(start+1)){
                    start++
                    current++
                }

                max = maxOf(max, current)
            }

        }

        return max
    }
}