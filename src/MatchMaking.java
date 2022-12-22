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

        resultStore = getMatchingPairs(new int[] { 6, 7, 4, 3, 4, 5, 6 }, target);
        displayResult(resultStore);
        
        resultStore = getMatchingPairs(new int[] { 6, 6, 6, 4, 4, 4, 5 }, target);
        displayResult(resultStore);
        
        resultStore = getMatchingPairs(new int[] { 3, 7, 5, 5, 2, 8, 9 }, target);
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

            if (stateMap.containsKey(partOfPair)) {
                resultStore.add(
                    new Integer[] {inputArray[index], partOfPair}
                );
            }
            stateMap.put(inputArray[index], 0);
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
