class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {

        val map = mutableMapOf<Int, Int>()

        for(i in 0 until nums.size){

            if(map.contains(target - nums[i])){
                return intArrayOf(map[target-nums[i]]!!, i)
            }

            map[nums[i]] = i

        }

        return intArrayOf()
    }
}
