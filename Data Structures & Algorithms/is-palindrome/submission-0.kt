class Solution {
    fun isPalindrome(s: String): Boolean {

        var left = 0
        var right = s.length -1

        while(left < right){
            //println("left: ${s[left]}, right: ${s[right]}")
            if(!s[left].isLetterOrDigit()){
                left++
                continue
            }

            if(!s[right].isLetterOrDigit()){
                right--
                continue
            }

            if(s[left].lowercaseChar() == s[right].lowercaseChar()){
                left++
                right--
            }else{
                return false
            }
        }

        return true
    }

}