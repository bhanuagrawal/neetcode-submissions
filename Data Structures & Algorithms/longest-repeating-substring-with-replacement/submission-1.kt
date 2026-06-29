class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        var list = mutableListOf<Int>()

        val chars = mutableSetOf<Char>()

        for(char in s){
            chars.add(char)
        }
        var max = 0

        for(char in chars){
            
            list.clear()
            
            var left = -1
            var r = 0
            var currentChar = char

            for(right in 0 until s.length){

                if(currentChar != s[right]){

                    list.add(right)


                    if(list.size > k){
                        left = list.removeFirst()
                    }
                    
                }

                max = maxOf(max, right-left)
            }
        }
        

        return max

    }
}
