class Solution {
    val memo = mutableMapOf<Int, Int>()

    fun climbStairs(n: Int): Int {

        if(n ==0) return 1

        if(n < 0) return 0

        if(memo.contains(n)){
            return memo[n]!!
        }

        val result =  climbStairs(n-1) + climbStairs(n-2)
        memo[n] = result
        return result
    }
}
