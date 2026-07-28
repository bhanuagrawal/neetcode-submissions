class Solution {
    //2: 35
    fun checkInclusion(s1: String, s2: String): Boolean {
        if(s1.length > s2.length) return false


        val ref = IntArray(26)
        for(char in s1){
            ref[char - 'a']++
        }

        val window = IntArray(26)
        for(i in 0 until s2.length){

            window[s2[i]-'a']++

            if(i >= s1.length){
                window[s2[i-s1.length]-'a']--
            }

            if(window.contentEquals(ref)) return true
        }

        return false


    }
}
