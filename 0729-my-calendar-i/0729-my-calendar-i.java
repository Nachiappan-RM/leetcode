class MyCalendar {

    private TreeMap<Integer, Integer> bookings; //start: end <- sorted by start time
    public MyCalendar() {
        this.bookings = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        
        if(start>= end) {
            return false;
        }

        Map.Entry<Integer, Integer> prev = bookings.floorEntry(start); //map_start<= our_start

        if(prev!=null && prev.getValue() > start){
            return false;
        }

        Map.Entry<Integer, Integer> next = bookings.ceilingEntry(start); //map_start>= our_start
        
        if(next!=null && next.getKey() < end){
            return false;
        }

        bookings.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */