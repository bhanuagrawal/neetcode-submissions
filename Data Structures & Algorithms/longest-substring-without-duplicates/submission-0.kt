class Solution {
    fun lengthOfLongestSubstring(s: String): Int {

        val map = mutableMapOf<Char, Int>()

        var left = 0
        var max = 0
        for(right in 0 until s.length){

            if(map.contains(s[right])){
                left = maxOf(map[s[right]]!! + 1, left)
            }

            max = maxOf(max, right-left+1)

            map[s[right]] = right
        }

        return max
    }
}
