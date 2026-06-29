class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {

        val array = nums.mapIndexed{ index, element ->
            element to index
        }.toTypedArray()

        array.sortBy{
            it.first
        }

        var left = 0
        var right = array.size-1



        while(left < right){
            
            val sum = array[left].first + array[right].first
            
            if(sum == target){
                return intArrayOf(
                    minOf(array[left].second, array[right].second),
                    maxOf(array[left].second, array[right].second)
                    )
            }else if(sum > target){
                right--
            }else{
                left++
            }
        }

        return intArrayOf()
    }
}
