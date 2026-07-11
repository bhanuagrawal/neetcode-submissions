class Solution {
    fun countComponents(n: Int, edges: Array<IntArray>): Int {
        
        val parent = IntArray(n){it}
        val size = IntArray(n){1}
    

        fun find(i: Int): Int{

            if(parent[i] != i){
                parent[i] = find(parent[i])
            }
            return parent[i]
        }

        fun union(a: Int, b: Int){
            var rootA = find(a)
            var rootB = find(b)

            if(rootA != rootB){

                if(size[rootB] > size[rootA]){
                    val temp = rootA 
                    rootA = rootB
                    rootB = temp
                }
                
                parent[rootB] = rootA
                size[rootA] += size[rootB]

            }
        }



        for(edge in edges){
            union(edge[0], edge[1])
        }

        var result = 0
        for(i in 0 until n){
            if(parent[i] == i){
                result++
            }
        }


        return result 
    }
}