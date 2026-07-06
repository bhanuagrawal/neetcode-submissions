class Solution {

    val memo = mutableMapOf<Int, Int>()

    fun coinChange(coins: IntArray, amount: Int): Int {
        val result = coinChangeUtil(coins, amount)

        return if(result == Int.MAX_VALUE){
            -1 
        }else{
            result
        }
    }

    fun coinChangeUtil(coins: IntArray, amount: Int): Int {

        if(amount == 0) return 0
        if(amount < 0) return Int.MAX_VALUE


        memo[amount]?.let{return it}

        var answer: Long = Int.MAX_VALUE.toLong()

        for(coin in coins){
            answer = min(answer, 1+coinChangeUtil(coins, amount-coin).toLong())
        }
        memo[amount] = answer.toInt()
        return answer.toInt()
    }


}
