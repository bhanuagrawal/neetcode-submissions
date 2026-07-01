/**
 * Definition of Interval:
 * class Interval(var start: Int, var end: Int) {}
 */

class Solution {
    fun minMeetingRooms(_intervals: List<Interval>): Int {

        if(_intervals.isEmpty()) return 0
        
        val intervals = _intervals.sortedBy{
            it.start
        }

        val heap = PriorityQueue<Int>(){ a, b ->
            a - b
        }
        var max = 1
        heap.offer(intervals[0].end)

        for(i in 1 until intervals.size){

            while(heap.isNotEmpty() &&
            intervals[i].start >= heap.peek()){
                heap.poll()
            }


            heap.offer(intervals[i].end)

            max = maxOf(max, heap.size)

        }

        return max 

    }
}
