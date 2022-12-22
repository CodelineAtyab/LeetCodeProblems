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
        int[] arrayOfNumbers = new int[] { 6, 7, 4, 3, 4, 5, 6 };
        int target = 10;

        ArrayList<Integer[]> resultStore = new ArrayList<Integer[]>();

        resultStore = getMatchingPairs(arrayOfNumbers, target);
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
     * @param targetSum:  Number that would e acquired by adding up a pair.
     * @return
     */
    public static ArrayList<Integer[]> getMatchingPairs(int[] inputArray, int targetSum) {
        /*
         * {6, 7, 4, 3, 4, 5, 6} targetSum is 10 1. 
         * Subtract the first element from target to get 
         * Other part of the pair.
         */

        HashMap<Integer, Integer> stateMap = new HashMap<Integer, Integer>();

        for (int index = 0; index < inputArray.length; index++) {
            int partOfPair = targetSum - inputArray[index];

            if (stateMap.containsKey(partOfPair)) {
                // We found a pair
                System.out.println(inputArray[index] + " - " + partOfPair);
            }

            stateMap.put(inputArray[index], 0);

        }

        return new ArrayList<Integer[]>();
    }

}
