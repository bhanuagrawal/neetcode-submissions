class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = mutableMapOf<String, MutableList<String>>()

        for(str in strs){
            val key = getKey(str)
            //println("$str: key: $key")
            map[key] = map.getOrDefault(key, mutableListOf()).apply{
                add(str)
            }
        }

        return map.values.map{it.toList()}.toList()
    }

    fun getKey(s: String): String{

        val map = IntArray(26){0}

        for(char in s){
            map[char-'a']++
        }

        return map.mapIndexed{ index, item ->
            if(item > 0){
                val char = ('a'.toInt() + index).toChar()
                "$char$item"
            }else{
                ""
            }

        }.joinToString("")

    }
}
