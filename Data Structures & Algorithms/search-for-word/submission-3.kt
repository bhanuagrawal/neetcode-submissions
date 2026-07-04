class Solution {

    fun exist(board: Array<CharArray>, word: String): Boolean {

        if(board.isEmpty() || word.isEmpty()) return false

        val nextMoves = 
            arrayOf(intArrayOf(0,1), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(-1, 0))

        val row = board.size
        val column = board[0].size


        fun find(i: Int, j: Int, index: Int): Boolean{

            //println(board.map{it.joinToString()}.joinToString("\n"))

            if(index == word.length) return false

            if(word[index] == board[i][j]){

                if(index == word.length-1) return true
                board[i][j] = '0'
                for(move in nextMoves){
                    val nextI = i + move[0]
                    val nextJ = j + move[1]

                    if(nextI in 0 until row && nextJ in 0 until column){
                        val r = find(nextI, nextJ, index+1)
                        if(r) return true
                    }
                }
                board[i][j] = word[index]
            }

            return false
        }

        for(i in 0 until row){
            for(j in 0 until column){
                if(board[i][j] == word[0]){
                    val found = find(i, j, 0)
                    if(found) return true
                }
            }
        }

        return false



    }
}

// ["C","A","A"]
// ["A","A","A"]
// ["B","C","D"]


