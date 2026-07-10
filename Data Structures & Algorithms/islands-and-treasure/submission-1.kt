class Solution {


    fun islandsAndTreasure(grid: Array<IntArray>) {

        if(grid.isEmpty()) return 
        val rows = grid.size
        val cols = grid[0].size
        val INF = Int.MAX_VALUE
        
        val queue = ArrayDeque<Pair<Int, Int>>()

        for(i in 0 until rows){
            for(j in 0 until cols){
                if(grid[i][j] == 0){
                    queue.addLast(i to j)
                } 
            }
        }

        val directions = listOf(
            0 to 1, 0 to -1, -1 to 0, 1 to 0
        )
    
        while(!queue.isEmpty()){
            val (ci, cj) = queue.removeFirst()
            for((i, j) in directions){
                val ni = ci + i
                val nj = cj + j

                if(ni in 0 until rows && 
                    nj in 0 until cols &&
                    grid[ni][nj] == INF){

                    grid[ni][nj] = grid[ci][cj] + 1
                    queue.addLast(ni to nj)
                }
            }
        }
    }

}
