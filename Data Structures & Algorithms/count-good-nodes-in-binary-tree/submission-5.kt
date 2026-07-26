/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {

    var count = 0
    fun goodNodes(root: TreeNode?): Int {
        traverse(root, Int.MIN_VALUE)
        return count
    }

    fun traverse(root: TreeNode?, min: Int){

        if(root == null) return 

        if(root.`val` >= min){
            count++
        }

        val newMin = maxOf(root.`val`, min)
        traverse(root.left, newMin)
        traverse(root.right, newMin)

    }
}
