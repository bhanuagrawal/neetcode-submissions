class Solution {
    fun missingNumber(nums: IntArray): Int {
        
        var _xor = nums.size
        for(i in 0 until nums.size){
            _xor = _xor xor nums[i] xor i
        }


        return _xor
    }
}
