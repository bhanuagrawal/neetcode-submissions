class Solution {


    fun validTree(n: Int, edges: Array<IntArray>): Boolean {

        if(n != edges.size+1) return false 
        
        val parent = IntArray(n){it}
        //val size = IntArray(n-1){1}

        fun find(i: Int): Int{

            if(i == parent[i]) return i

            return find(parent[i])

        }

        fun union(a: Int, b: Int): Boolean{
            val rootA = find(a)
            val rootB = find(b)

            if(rootA != rootB){
                parent[rootB] = rootA
            }

            //println(parent.joinToString())
            return rootA != rootB
        }


        for(edge in edges){
            if(!union(edge[0], edge[1])){
                return false
            }
        }

        return true 
    }
}