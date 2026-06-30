/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {

        if(root == null) return listOf<List<Int>>()

        val list = mutableListOf<MutableList<TreeNode>>()
        list.add(mutableListOf(root))
        levelOrderUtil(list)
        return list.map{it.map{node -> node.`val`}}
    }

    fun levelOrderUtil(list: MutableList<MutableList<TreeNode>>) {

        val prev = list.last()

        val currentLevel = mutableListOf<TreeNode>()
        for(node in prev){

            if(node.left != null){
                currentLevel.add(node.left!!)
            }
            if(node.right != null){
                currentLevel.add(node.right!!)
            }
  
        }
        if(currentLevel.isNotEmpty()){
            list.add(currentLevel)
            levelOrderUtil(list)
        }

    }
}
