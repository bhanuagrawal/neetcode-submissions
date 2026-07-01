/**
 * Definition of Interval:
 * class Interval(var start: Int, var end: Int) {}
 */

class Solution {
    fun canAttendMeetings(_intervals: List<Interval>): Boolean {
        val intervals = _intervals.toMutableList().apply{sortBy{
            it.start
        }}

        for(i in 1 until intervals.size){
            if(intervals[i].start < intervals[i-1].end){
                return false
            }
        }

        return true
    }
}
