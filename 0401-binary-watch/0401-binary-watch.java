class Solution {
    /**
    Initial thought process,
    To store all possible hh:mm and number of light turned on but - It takes a lot of time to create the map - no flexibile
    
    Instead of storing just loop through,
    4 LED for hh (0-11)
    6 LEDs for MM (0-59)
    
    - Need to find all combinations of hrs and mins where all total number of 1s equal to turnedOn
    
    we can iterate through all check possible turnedOn == 1's in the binary
    format as asked.
     */
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();

        if (turnedOn < 0 || turnedOn > 10)
            return result;

        //Trying all possible hours and min combinations
        for (int hour = 0; hour < 12; hour++) {
            for (int min = 0; min < 60; min++) {

                int hourBits = Integer.bitCount(hour);
                if (hourBits > turnedOn)
                    continue;
                int minuteBits = Integer.bitCount(min);

                if (hourBits + minuteBits == turnedOn) {
                    String time = hour + ":" + ((min < 10) ? "0" + min : min);
                    result.add(time);
                }
            }
        }
        return result;
    }

    //Implementing bitCount implementation as user defined method - Without using Integer.bitCount()
    private int countBits(int num) {
        int count = 0;
        while (num > 0) {
            count += (num & 1);
            num >>= 1;
        }
        return count;
    }
}
