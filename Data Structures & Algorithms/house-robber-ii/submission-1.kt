class Solution {

    val memo = mutableMapOf<Int, Int>()

    fun rob(nums: IntArray): Int {

        if(nums.size < 3){
            return robUtil(nums, 0, -1)
        }

        val r1 = robUtil(nums, 0, 0)
        memo.clear()
       val r2 = robUtil(nums, 0, nums.size-1)
        return maxOf(r1, r2)
    }

    fun robUtil(nums: IntArray, current: Int, except: Int): Int{

        if(current >= nums.size) return 0

        if(memo.contains(current)) return memo[current]!!

        val result = if(current == except){
            robUtil(nums, current+1, except)
        }else{
            maxOf(
                robUtil(nums, current+2, except) + nums[current],
                robUtil(nums, current+1, except)
            )
        }

        memo[current] = result

        return result

    }
}
