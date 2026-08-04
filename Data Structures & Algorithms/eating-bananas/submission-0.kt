class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var left = (piles.map{it.toLong()}.sum()/h).toInt()
        var right = piles.max()
        
        var ans = right
        while(left <= right){
            //println("left: $left, right: $right") 
            val mid = left + (right-left)/2
            val diff = check(piles, mid, h)
            if(diff >= 0){
                ans = mid
                right = mid - 1
            }else{
                left = mid + 1
            }

        }

        return ans
    }

    fun check(piles: IntArray, k: Int, h: Int): Int{
        var current = 0
        for(pile in piles){
            current += Math.ceil(pile.toDouble()/k).toInt()
        }
        return h - current
    }
}
