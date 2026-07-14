class Solution {

    fun countBits(n: Int): IntArray {
        val result = IntArray(n+1){it}

        for(i in 2..n){
            val lastDigit = i and 1
            result[i] = lastDigit  + result[i ushr 1]
        }

        return result
    }
}


// 0000
// 0001
// 0010
// 0011
// 0100

// 0
// 1 
// 10
// 11
// 100
// 10


// 0 
// 1 
// 10 
// 11
// 100 
// 101

// 10 
