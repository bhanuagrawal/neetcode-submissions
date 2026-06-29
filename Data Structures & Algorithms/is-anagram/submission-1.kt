class Solution {
    fun isAnagram(s: String, t: String): Boolean {

        if(s.length != t.length) return false 
        
        val map = mutableMapOf<Char, Int>()

        for(i in 0 until s.length){

            if(s[i] != t[i]){
                map[s[i]] = map.getOrDefault(s[i], 0) + 1
                map[t[i]] = map.getOrDefault(t[i], 0) - 1
                if(map[t[i]] == 0){
                    map.remove(t[i])
                }
                if(map[s[i]] == 0){
                    map.remove(s[i])
                }
            }

        }

        return map.isEmpty()
    }
}
