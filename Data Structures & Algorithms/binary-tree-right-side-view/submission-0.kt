/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun rightSideView(root: TreeNode?): List<Int> {

        if(root == null) return emptyList()

        val result = mutableListOf<Int>()
        val queue = ArrayDeque<TreeNode>()
        queue.addLast(root)

        while(queue.isNotEmpty()){
            val n = queue.size
            result.add(queue.last().`val`)
            repeat(n){
                val current = queue.removeFirst()
                if(current.left != null){
                    queue.addLast(current.left)
                }
                if(current.right != null){
                    queue.addLast(current.right)
                }
            }
        }

        return result
    }
}
