import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class can be used to process a list of numbers to generate a set of
 * pairs that adds up to a specific target (sum).
 *
 */
public class MatchMaking {

    /**
     * Used to run the main application with unit tests.
     * 
     * @param args: list of strings passed externally to this application.
     */
    public static void main(String[] args) {
        int target = 10;

        ArrayList<Integer[]> resultStore = new ArrayList<Integer[]>();

        // Case 1
        resultStore = getMatchingPairs(new int[] { 6, 6, 6, 4, 4, 4, 4, 6, 6}, target);
        displayResult(resultStore);
        
        // Case 2
        resultStore = getMatchingPairs(new int[] { 6, 6, 6, 4, 4, 4, 5 }, target);
        displayResult(resultStore);
        
        // Case 3
        resultStore = getMatchingPairs(new int[] { 3, 7, 5, 5, 2, 8, 9 }, target);
        displayResult(resultStore);
        
        // Case 4
        resultStore = getMatchingPairs(new int[] { 6, 7, 4, 3, 4, 5, 6 }, target);
        displayResult(resultStore);
    }

    /**
     * This method will process an array of integers and will generate pairs that
     * will add up to a specific sum.
     * 
     * For Example: If the input is: {6, 7, 4, 3, 4, 5, 6} Then the output would be:
     * [[6,4], [7,3], [4,6]]
     * 
     * Note: The order of numbers inside each pair doesn't matter. For Example: This
     * [[6,4], [7,3], [4,6]] can be represented as [[4,6], [3,7], [6,4]]
     * 
     * @param inputArray: Collection of numbers.
     * @param targetSum:  Number that would be acquired by adding up a pair.
     * @return An ArrayList of Array (2 elements) that will look something like:
     *         [[6,4], [7,3], [4,6]]
     */
    public static ArrayList<Integer[]> getMatchingPairs(int[] inputArray, int targetSum) {
        /*
         * This will remember the previous states, so we know which part of
         * pair has been traversed already.
         * */
        HashMap<Integer, Integer> stateMap = new HashMap<Integer, Integer>();
        
        // Used to store every generated pair.
        ArrayList<Integer[]> resultStore = new ArrayList<Integer[]>();

        for (int index = 0; index < inputArray.length; index++) {
            int partOfPair = targetSum - inputArray[index];
            Integer usageCountOfPart = stateMap.get(partOfPair);

            // Here we found a pair.
            if (stateMap.containsKey(partOfPair) && usageCountOfPart >= 1) {
                resultStore.add(
                    new Integer[] {inputArray[index], partOfPair}
                );
                
                // Get existing usage count and decrease it by 1 for the first part of the pair
                int usageCount = stateMap.get(partOfPair);
                stateMap.put(partOfPair, usageCount - 1);
                
                // Get existing usage count and decrease it by 1 for the second part of the pair
                if (stateMap.containsKey(inputArray[index])) {
                    usageCount = stateMap.get(inputArray[index]);
                    stateMap.put(inputArray[index], usageCount - 1);
                }
                else {
                    /*
                     * In case we already used the new part of pair with an existing part
                     * Then we should set the usage to -1 so it balances out.
                     * */
                    stateMap.put(inputArray[index], -1);
                }
            }
            
            // If something is new, we can put it with allowed usage to 1 time.
            // 6, 6, 6, 4, 4, 4
            if (!stateMap.containsKey(inputArray[index])) {
                stateMap.put(inputArray[index], 1);  // 1 is the allowed usage count.
            }
            else {
                // Get existing usage count and update the counter by 1
                int usageCount = stateMap.get(inputArray[index]);
                stateMap.put(inputArray[index], usageCount + 1);
            }
        }
        
        return resultStore;
    }
    
    private static void displayResult(ArrayList<Integer[]> inputArray) {
        for (Integer[] currentPair: inputArray) {
            System.out.println(currentPair[0] + " - " + currentPair[1]);
        }
        System.out.println();
    }
}
