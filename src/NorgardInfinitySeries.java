

public class NorgardInfinitySeries {

    private final int sZero = 0;

    /**
     * <h>Purpose:</h>
     * <p>Generate the sequence of set length starting from the passed in index</p>
     * @param startingIndex
     * @param length
     * @return
     */
    public int[] generateSequence(int startingIndex, int length){
        int[] sequence = new int[length];
        for(int i = 0; i < length; i++){
            int rawValue = calculateRawValue(startingIndex + i);
            sequence[i] = calculateDigit(rawValue);
        }
        return sequence;
    }

    /**
     * <h>Purpose:</h>
     * <p>Recursively establish the raw sequence value for the passed in int</p>
     * <p>Time complexity: O(log(n))</p>
     * @param index
     * @return
     */
    private int calculateRawValue(int index){
        if(index == 0){
            return 0;
        }
        else if(index%2 == 0){
            return -calculateRawValue(index/2);
        }
        else{
            return calculateRawValue(((index-1)/2) +1);
        }
    }

    /**
     * <h>Purpose:</h>
     * <p>Use modulo arithmetic to ensure that all digits stay between 0-9.
     * Digit  = (rawValue%10+10)%10</p>
     *
     * <ul>Examples:
     * <li>Raw value: 4 --> (4%10 + 10)%10 = 4</li>
     * <li>Raw value: 22 --> (22%10 + 10)%10 = 2</li>
     * <li>Raw value:2345 --> (2345%10 + 10)%10 = 5</li>
     * <li>Raw value: -33 --> (-33%10 + 10)%10 = 7</li>
     * <li>Raw value: -6789 --> (-6789%10 + 10)%10 = 1</li>
     *
     * <p>Time Complexity: O(1)</p>
     *
     * @param rawValue
     * @return digit
     */
    private int calculateDigit(int rawValue){
        return (rawValue%10+10)%10;
    }

}
