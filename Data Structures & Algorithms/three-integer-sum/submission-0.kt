class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {

        val list = mutableSetOf<List<Int>>()

        val mem = mutableSetOf<Int>()

        for(i in 0 until nums.size-2){
            
            for(j in i+1 until nums.size){

                if(mem.contains(-nums[i] - nums[j])){
                    list.add(listOf(nums[i], -nums[i]-nums[j], nums[j]).sorted())
                }
                mem.add(nums[j])
            }
            mem.clear()
        }

        return list.toList()
    }
}
