class Solution {

    val list = mutableListOf<List<Int>>() 
    val path = mutableListOf<Int>()
    fun combinationSum(nums: IntArray, target: Int): List<List<Int>> {
        nums.sort()
        dfs(nums, 0, target)
        return list
        

    }

    fun dfs(nums: IntArray, si: Int, target: Int){

        if(target == 0){
            list.add(path.toList())
            return 
        }

        val list = mutableListOf<MutableList<Int>>() 

        for(i in si until nums.size){
            val num = nums[i]
            if(num > target){
                return 
            }
            path.add(num)
            dfs(nums, i, target-num)
            path.removeAt(path.lastIndex)
        }
    }
}

// 2 2 5 

// 2 2 4 1 