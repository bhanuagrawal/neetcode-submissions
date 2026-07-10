class Solution {


    fun islandsAndTreasure(grid: Array<IntArray>) {

        if(grid.isEmpty()) return 
        val rows = grid.size
        val cols = grid[0].size

        fun dfs(i: Int, j: Int, d: Int){

            if(i !in 0 until rows || j !in 0 until cols || grid[i][j] == -1 || grid[i][j] < d){
                return
            }

            grid[i][j] = minOf(grid[i][j], d)

            dfs(i+1, j, d+1)
            dfs(i-1, j, d+1)
            dfs(i, j+1, d+1)
            dfs(i, j-1, d+1)


        }

        for(i in 0 until rows){
            for(j in 0 until cols){
                if(grid[i][j] == 0){
                    dfs(i, j, 0)
                } 
            }
        }
    }

}
