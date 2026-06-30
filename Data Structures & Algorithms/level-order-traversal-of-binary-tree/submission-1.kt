/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {

        val queue = ArrayDeque<TreeNode>()
        val traversal = mutableListOf<List<Int>>()

        if(root == null)(
            return traversal
        )

        queue.offer(root)

        while(queue.isNotEmpty()){
            
            val level = queue.toList().map{it.`val`}
            traversal.add(level)

            repeat(level.size){
                
                val node = queue.poll()

                if(node.left != null){
                    queue.offer(node.left)
                }

                if(node.right != null){
                    queue.offer(node.right)
                }


            }
        }

        return traversal


    }

}
