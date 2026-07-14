class Solution {
    fun reverseBits(n: Int): Int {
        var num = n
        var r = 0
        repeat(32){
            r = r shl 1
            r = r or (num and 1)
            num = num ushr 1 
        }

        return r
    }
}
