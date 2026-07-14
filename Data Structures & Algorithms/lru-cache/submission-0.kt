class LRUCache(val capacity: Int) {

    class Node(
        val key: Int,
        val value: Int,
        var next: Node ? = null,
        var prev: Node ? = null
    ) 

    var head: Node ? = null
    var tail : Node ? = null
    val map = mutableMapOf<Int, Node>()

    fun get(key: Int): Int {
        //println("get")
        val node = map[key]
        if(node != null){
            remove(node)
            addToStart(node)
            return node.value
        }

        return -1
    }

    fun put(key: Int, value: Int) {
        //println("put")
        val node = map[key]
        val newNode = Node(key, value)
        
        if(node != null){
            remove(node)
        }else if(map.size >= capacity){
            if(tail != null){
                map.remove(tail!!.key)
                remove(tail!!)
            }


        }
        map[key] = newNode
        addToStart(newNode)

    }

    fun addToStart(node: Node){
        //println("addToStart: ${node.value}")
        if(head == null){
            head = node 
            tail = node 
            return 
        }

        head?.prev = node
        node?.next = head 
        head = node
    }

    fun remove(node: Node){
        //println("remove: ${node.value}")
        if(node == tail){
            tail = node?.prev
        }

        if(head == node){
            head = node?.next
        }

        node?.prev?.next = node?.next
        node?.next?.prev = node?.prev

        node?.next = null
        node?.prev = null

    }


}

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */