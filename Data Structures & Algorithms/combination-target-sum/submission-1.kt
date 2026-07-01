class Solution {

    fun combinationSum(nums: IntArray, target: Int): List<List<Int>> {
        nums.sort()
        return cs(nums, 0, target)
        

    }

    fun cs(nums: IntArray, si: Int, target: Int): List<MutableList<Int>>{

        if(target <= 0) return emptyList()

        val list = mutableListOf<MutableList<Int>>() 

        for(i in si until nums.size){
            val num = nums[i]
            if(num == target){
                list.add(mutableListOf(num))
                return list
            }

            val r = cs(nums, i, target-num)
            for(item in r){
                item.add(num)
                list.add(item)
            }
        }

        return list
    }
}

// 2 2 5 

// 2 2 4 1 