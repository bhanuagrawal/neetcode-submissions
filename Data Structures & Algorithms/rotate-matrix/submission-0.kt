class Solution {
    fun rotate(matrix: Array<IntArray>) {
        val rows = matrix.size
        val cols = matrix[0].size


        for(i in 0 until rows){
            for(j in i+1 until cols){
                val temp = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = temp
            }
        }

        for(i in 0 until rows){

            var start = 0
            var end = cols-1
            while(start < end){
                val temp = matrix[i][start]
                matrix[i][start] = matrix[i][end]
                matrix[i][end] = temp
                start++
                end--
            }
        }
    }
}


// 1 2 3      
// 4 5 6
// 7 8 9   


// 7 4 1  
// 8 5 2
// 9 6 3 


// 1 4 7
// 2 5 8
// 3 6 9