class Solution {

    val memo = mutableMapOf<Int, Int>()

    fun rob(nums: IntArray): Int {
        return robUtil(nums, 0)
    }

    fun robUtil(nums: IntArray, current: Int): Int{

        if(current >= nums.size) return 0

        if(memo.contains(current)) return memo[current]!!

        val result = maxOf(
            robUtil(nums, current+2) + nums[current],
            robUtil(nums, current+1)
            )

        memo[current] = result

        return result

    }
}
