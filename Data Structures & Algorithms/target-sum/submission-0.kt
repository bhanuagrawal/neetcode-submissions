class Solution {

    lateinit var  memo: Array<MutableMap<Int, Int>>

    fun findTargetSumWays(nums: IntArray, target: Int): Int {
        memo = Array(nums.size){mutableMapOf<Int, Int>()}
        return fts(nums, target, 0)
    }

    fun fts(nums: IntArray, target: Int, index: Int): Int{

        if(index == nums.size){
            return if(target == 0) 1 else 0
        }

        memo[index][target]?.let{
            return it 
        }

        val r1 =  fts(nums, target+nums[index], index+1)
        val r2 =  fts(nums, target-nums[index], index+1)

        val result =  r1 + r2
        memo[index][target] = result
        return result
    }
}