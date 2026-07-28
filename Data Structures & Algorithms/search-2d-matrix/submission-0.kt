class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val rows = matrix.size
        val cols = matrix[0].size
        var left = 0
        var right = rows*cols-1

        while(left <= right){
            val mid = left + (right-left)/2
            val i = mid/cols 
            val j = mid - i*cols

            if(matrix[i][j] == target){
                return true
            }else if(matrix[i][j] > target){
                right = mid - 1
            }else {
                left = mid + 1
            }
        }

        return false
    }
}
