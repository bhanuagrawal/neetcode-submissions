class Solution {
    fun canJump(nums: IntArray): Boolean {
        var maxJump = 0
        for(i in 0 until nums.size){
            if(i > maxJump){
                return false
            }else{
                maxJump = maxOf(maxJump, i+nums[i])
            }
        }

        return true
    }
}
