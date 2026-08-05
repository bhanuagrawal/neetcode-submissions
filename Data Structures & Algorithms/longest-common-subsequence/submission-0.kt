class Solution {

    lateinit var memo: Array<IntArray>

    fun longestCommonSubsequence(text1: String, text2: String): Int {
        memo =  Array(text1.length){IntArray(text2.length){-1}}
        return lcs(text1, text2, 0, 0)
    }

    fun lcs(text1: String, text2: String, i1: Int, i2: Int): Int {

        if(text1.length == i1 || text2.length == i2){
            return 0
        }
        
        if(memo[i1][i2] != -1){
            return memo[i1][i2]
        }

        val result = if(text1[i1] == text2[i2]){
            1 + lcs(text1, text2, i1+1, i2+1)
        }else{
            maxOf(
                lcs(text1, text2, i1+1, i2),
                lcs(text1, text2, i1, i2+1), 
            )
        }

        memo[i1][i2] = result
        return result
    }
}