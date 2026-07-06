class Solution {

    val memo = mutableMapOf<Int, Int>()
    fun numDecodings(s: String): Int {

        return numDecodingUtil(s, 0)
    }

    fun numDecodingUtil(s: String, before: Int): Int{

        //println("index: $before")
        if(before == s.length) return 1 
        if(before > s.length) return 0

        memo[before]?.let{return it}
        
        val r = if(s[before] == '0'){
            0
        }else if(before+2 <= s.length && 
                s.substring(before, before+2).toInt() <=26
                ){
            numDecodingUtil(s, before + 1) + numDecodingUtil(s, before + 2)
        }else{
            numDecodingUtil(s, before + 1)
        }

        memo[before] = r
        
        return r
        

    }
}
