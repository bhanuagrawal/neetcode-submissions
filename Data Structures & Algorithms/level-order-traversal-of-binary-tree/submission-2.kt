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

        queue.addLast(root)

        while(queue.isNotEmpty()){
            val level = mutableListOf<Int>()
            traversal.add(level)
            val size = queue.size

            repeat(size){
                
                val node = queue.removeFirst()
                level.add(node.`val`)

                if(node.left != null){
                    queue.addLast(node.left)
                }

                if(node.right != null){
                    queue.addLast(node.right)
                }


            }
        }

        return traversal


    }

}
