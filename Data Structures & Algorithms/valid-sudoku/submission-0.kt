class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {

        val rows = board.size-1
        val columns = board[0].size-1
        val map = mutableMapOf<String, MutableSet<Char>>()
        for(i in 0..rows){

            for(j in 0..columns){

                if(board[i][j] == '.') continue

                val (rowKey, columnKey, boxKey) = getKey(i, j)

                val rowSet = map.getOrPut(rowKey){
                     mutableSetOf<Char>()
                }
                val columnSet = map.getOrPut(columnKey){
                     mutableSetOf<Char>()
                }
                val boxSet = map.getOrPut(boxKey){
                     mutableSetOf<Char>()
                }

                if(rowSet.contains(board[i][j]) || columnSet.contains(board[i][j]) || boxSet.contains(board[i][j])){
                    return false
                }

                rowSet.add(board[i][j])
                columnSet.add(board[i][j])
                boxSet.add(board[i][j])

                //println("$rowKey, $columnKey, $boxKey")

            }
        }

        return true

    }

    fun getKey(i: Int, j: Int): Triple<String, String, String>{

        val rowKey = "row$i"
        val columnKey = "column$j"

        val boxI = i/3
        val boxJ = j/3

        val boxKey = "box$boxI$boxJ"

        return Triple(rowKey , columnKey , boxKey)

    }
}