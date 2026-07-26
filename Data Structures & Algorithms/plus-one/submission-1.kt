class Solution {
    fun plusOne(digits: IntArray): IntArray {
        var carry = 1
        var i = digits.size-1
        while(i >= 0 && carry > 0){
            digits[i] += carry
            carry = digits[i]/10
            digits[i] %= 10
            i--
        }

        return if(carry == 1){
            digits.toMutableList().apply{addFirst(1)}.toIntArray()
        }else{
            digits
        }
    }
}

