class Solution {

    fun encode(strs: List<String>): String {
        
        return strs.map{if(it.isEmpty()) "EMPTY" else it}.joinToString("leetcode")
    }

    fun decode(str: String): List<String> {
        if(str.isEmpty()) return emptyList<String>()
        return str.split("leetcode").map{if(it == "EMPTY") "" else it}
    }
}
