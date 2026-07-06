class Solution {
    fun countSubstrings(s: String): Int {

        val memo = mutableMapOf<Pair<Int, Int>, Boolean>()
        
        fun isPalindrome(left: Int, right: Int): Boolean{

            if(left>=right) return true

            memo[left to right]?.let{return it}

            val result = if(s[left] == s[right]){
                isPalindrome(left+1, right-1)
            }else{
                false
            }

            memo[left to right] = result

            return result
        }

        var count = 0

        for(i in s.indices){
            for(j in i until s.length){
                if(isPalindrome(i, j)){
                    count++
                }
            }
        }


        return count

    }
}
