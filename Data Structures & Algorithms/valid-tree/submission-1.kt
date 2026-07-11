class Solution {


    fun validTree(n: Int, edges: Array<IntArray>): Boolean {

        if(n != edges.size+1) return false 
        
        val parent = IntArray(n){it}
        val size = IntArray(n){1}

        fun find(i: Int): Int{

            if(parent[i] != i){
                parent[i] = find(parent[i])
            }
            return parent[i]
        }

        fun union(a: Int, b: Int): Boolean{
            var rootA = find(a)
            var rootB = find(b)

            if(rootA == rootB) return false

            if(size[rootB] > size[rootA]){
                val temp = rootA 
                rootA = rootB
                rootB = temp
            }
            
            parent[rootB] = rootA
            size[rootA] += size[rootB]
            //println(parent.joinToString())

            return true
        }


        for(edge in edges){
            if(!union(edge[0], edge[1])){
                return false
            }
        }

        return true 
    }
}