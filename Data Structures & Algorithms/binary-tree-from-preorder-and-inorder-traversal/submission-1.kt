/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {

    var preorderIndex = 0

    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        val map = mutableMapOf<Int, Int>()

        for(i in 0 until inorder.size){
            map[inorder[i]] = i
        }

        return build(
            preorder,
            0,
            inorder.size-1,
            map
        )

    }

    fun build(preorder: IntArray, left: Int, right: Int, map: Map<Int, Int>): TreeNode? {

        if(left>right) return null
        
        val root = preorder[preorderIndex++]
        val node = TreeNode(root)
        val mid = map[root]!!

        node.left = build(preorder, left, mid-1, map)
        node.right = build(preorder, mid+1, right, map)


        return node

    }
}
