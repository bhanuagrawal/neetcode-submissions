class Solution {

    fun lengthOfLongestSubstring(s: String): Int {
        var left = -1
        val recent = mutableMapOf<Char, Int>()

        var max = 0 
        for(right in 0 until s.length){

            val lastSeen = recent[s[right]]

            if(lastSeen != null && lastSeen >= left){
                left = lastSeen
            }

            recent[s[right]] = right

            max = maxOf(max, right-left)
        }

        return max
    }
}
