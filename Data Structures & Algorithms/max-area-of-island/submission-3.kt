class Solution {
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {

        if(grid.isEmpty()) return 0

        val rows = grid.size
        val cols = grid[0].size

        fun dfs(i: Int, j: Int): Int{

            if(i !in 0 until rows || j !in 0 until cols || grid[i][j] == 0){
                return 0
            }

            grid[i][j] = 0

            return 1 + 
                    dfs(i+1, j) +
                    dfs(i-1, j) +
                    dfs(i, j+1) +
                    dfs(i, j-1)


        }

        var max = 0
        for(i in 0 until rows){
            for(j in 0 until cols){
                if(grid[i][j] == 1){
                    max = maxOf(max, dfs(i, j))
                } 
            }
        }

        return max
    }
}
