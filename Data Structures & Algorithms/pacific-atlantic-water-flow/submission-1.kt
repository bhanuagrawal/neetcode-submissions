class Solution {
    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {

        val result = mutableListOf<List<Int>>()

        val moves = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(0, -1),
            intArrayOf(1, 0),
            intArrayOf(-1, 0)
        )

        val row = heights.size
        val column = heights[0].size

        val pacific = Array(row){
            BooleanArray(column)
        }


        val atlantic = Array(row){
            BooleanArray(column)
        }

        fun dfs(i: Int, j: Int, visited: Array<BooleanArray>){
            visited[i][j] = true

            for(move in moves){
                val ni = i + move[0]
                val nj = j + move[1]

                if(ni in 0 until row &&
                nj in 0 until column && 
                !visited[ni][nj] &&
                heights[ni][nj] >= heights[i][j]){
                    dfs(ni, nj, visited)
                }
            }

        }

        for(j in 0 until column){
            dfs(0, j, pacific)
        }

        for(i in 0 until row){
            dfs(i, 0, pacific)
        }

        for(j in 0 until column){
            dfs(row-1, j, atlantic)
        }

        for(i in 0 until row){
            dfs(i, column-1, atlantic)
        }


        for(i in 0 until row){
            for(j in 0 until column){
                if(pacific[i][j] && atlantic[i][j]){
                    result.add(listOf(i, j))
                }
            }
        }

        return result
    }
}
