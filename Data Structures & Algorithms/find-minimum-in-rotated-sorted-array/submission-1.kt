class Solution {
    fun findMin(nums: IntArray): Int {
        var left = 0
        var right = nums.size-1

        while(left <= right){

            val mid = left + (right-left)/2

            if(nums[mid] < nums[left] || nums[mid] < nums[right]){
                right = mid
            }else{
                left = mid+1
            }

        }

        return nums[right]
    }
}

// 1 2 3 4 5 

// 4 5 1 2 3 

//1 2 3 4 5 

