class Solution {
    
    val memo = mutableMapOf<Pair<Int, Int>, String>()

    fun longestPalindrome(s: String): String {
        return lp(s, 0, s.length-1)
    }

    fun lp(s: String, start: Int, end: Int): String{

        if(start > end){
            return ""
        }

        if(start == end){
            return "${s[start]}"
        }

        if(memo.contains(start to end)){
            return memo[start to end]!!
        }

        var r: String? = null
        if(s[start] == s[end]){
            r = lp(s, start+1, end-1)
        }

        r = if(r!= null && r.length == end-start-1){
            s.substring(start, end+1)
        }else{
            val l1 = lp(s, start+1, end)
            val l2 = lp(s, start, end-1)
            if(l1.length > l2.length){
                l1
            }else{
                l2
            }
        }

        memo[start to end] = r
        return r

    }
}

