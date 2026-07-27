class Solution {

    val set = mutableSetOf<Int>()
    fun isHappy(n: Int): Boolean {

        
        if(set.contains(n)) return false
        set.add(n)

        var number = n
        var sum = 0
        while(number > 0){
            val digit = number%10
            number /= 10
            sum += digit*digit
        }

    

        return if(sum==1) true else isHappy(sum)
    }
}
