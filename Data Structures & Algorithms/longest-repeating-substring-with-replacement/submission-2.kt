class Solution {
    fun characterReplacement(s: String, k: Int): Int {

        val count = IntArray(26){0}

        var left = 0

        var result = 0

        for(right in s.indices){

            count[s[right]-'A']++

            while(true){

                var maxFreq = 0
                for(c in count){
                    maxFreq = maxOf(maxFreq, c)
                }

                if(right-left+1 - maxFreq > k){
                    count[s[left]-'A']--
                    left++
                }else{
                    break
                }


            }

            result = maxOf(result, right-left+1)

        }
        return result
    }
}
