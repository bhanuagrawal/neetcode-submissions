class Solution {
    fun orangesRotting(grid: Array<IntArray>): Int {


        if(grid.isEmpty()) return -1
        val rows = grid.size
        val cols = grid[0].size
        
        val queue = ArrayDeque<Pair<Int, Int>>()

        for(i in 0 until rows){
            for(j in 0 until cols){
                if(grid[i][j] == 2){
                    queue.addLast(i to j)
                } 
            }
        }

        val directions = listOf(
            0 to 1, 0 to -1, -1 to 0, 1 to 0
        )

        var min = 0
        while(!queue.isEmpty()){

            val n = queue.size
            var rotten = false
            repeat(n){
                val (ci, cj) = queue.removeFirst()
                for((i, j) in directions){
                    val ni = ci + i
                    val nj = cj + j

                    if(ni in 0 until rows && 
                        nj in 0 until cols &&
                        grid[ni][nj] == 1){
                        
                        rotten = true
                        grid[ni][nj] = 2
                        queue.addLast(ni to nj)
                    }
                }
            }

            if(rotten) min++

        }

        for(i in 0 until rows){
            for(j in 0 until cols){
                if(grid[i][j] == 1){
                    return -1
                } 
            }
        }

        return min
    }
}

