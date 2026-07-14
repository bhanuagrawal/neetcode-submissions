class Solution {
    fun missingNumber(nums: IntArray): Int {
        var _xor = 0
        for(i in 0 until nums.size){
            _xor = _xor xor nums[i]
        }

        for(i in 0..nums.size){
            _xor = _xor xor i
        }

        return _xor
    }
}
