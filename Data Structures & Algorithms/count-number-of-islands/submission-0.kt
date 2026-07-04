class Solution {
    

    fun numIslands(grid: Array<CharArray>): Int {

        if(grid.isEmpty()) return 0

        val nextMoves = 
            listOf(0 to 1, 0 to -1, 1 to 0, -1 to 0)

        val row = grid.size
        val column = grid[0].size
        
        val queue = ArrayDeque<Pair<Int, Int>>()

        fun dfs(i: Int, j: Int){

            queue.add(i to j)

            while(queue.isNotEmpty()){
                val current = queue.removeLast()
                grid[current.first][current.second] = '0'

                for(move in nextMoves){
                    val next = current.first + move.first to current.second + move.second
                    if(next.first in 0 until row && next.second in 0 until column){
                        if(grid[next.first][next.second] == '1'){
                            queue.addLast(next.first to next.second)
                        }   
                    }
                }
            }


        }

        var count = 0

        for(i in 0 until row){
            for(j in 0 until column){
                if(grid[i][j] == '1'){
                    dfs(i, j)
                    count++
                }
            }
        }

        return count
    }
}
