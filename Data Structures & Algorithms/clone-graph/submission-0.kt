/*
Definition for a Node.
class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList()
}
*/

class Solution {

    val visited = mutableMapOf<Node?, Node>()

    fun cloneGraph(node: Node?): Node? {

        if(node == null) return null
        val newNode = Node(node.`val`)

        node.neighbors = arrayListOf<Node?>()
        visited[node] = newNode


        for(neighbor in node.neighbors){
            if(visited.contains(neighbor)){
                node.neighbors.add(visited[neighbor]!!)
            }else{
                node.neighbors.add(cloneGraph(neighbor))
            }
        }
        return newNode
    }
}
