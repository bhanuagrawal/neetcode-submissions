/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {

        if(preorder.isEmpty() || inorder.isEmpty()) return null

        val root = TreeNode(preorder[0])
        val index = inorder.indexOf(preorder[0])
        root.left = buildTree(
            preorder.copyRange(1, 1+index),
            inorder.copyRange(0, index)
        )

        root.right = buildTree(
            preorder.copyRange(1+index, preorder.size),
            inorder.copyRange(index+1, inorder.size)
        )

        return root
    }

    fun IntArray.copyRange(start: Int, end: Int): IntArray{
        return if(start >= end){
            intArrayOf()
        }else{
            this.copyOfRange(start, end)
        }
    }
}

// 1 2 3 4 
// 2 1 3 4 

// 2  1  3 4 



