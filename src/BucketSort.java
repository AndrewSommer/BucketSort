/**
 * This abstract class contains static methods to sort an array using the bucket sort method
 * @author Andrew Sommer
 * @version 1.0.0 06 February 2018
 */
public abstract class BucketSort {

    /**
     * Inputs an unsorted array, and uses the bucket sort method to return a sorted array
     * This method calls the private method bucketIndex to help
     * @param arrayToBeSorted
     * @return int[] sortedArray
     */
    public final static int[] sort(int[] arrayToBeSorted) {
        int[][] arrayOfBuckets = new int[10][arrayToBeSorted.length];
        int[] bucketContains = new int[10];

        int digitWanted = 1;
        boolean changesMade = true;
        while (changesMade) {
            changesMade = false;
            //Set to all entries to -1 for flagging
            for (int rowCount = 0; rowCount < arrayOfBuckets.length; rowCount++) {
                for (int colCount = 0; colCount < arrayOfBuckets[rowCount].length; colCount++) {
                    arrayOfBuckets[rowCount][colCount] = -1;
                }
            }
            for (int bucketReset = 0; bucketReset < bucketContains.length; bucketReset++) {
                bucketContains[bucketReset] = 0;
            }

            //DistributionPass
            for (int dPassCount = 0; dPassCount < arrayToBeSorted.length; dPassCount++) {
                int bucketIndex = bucketIndex(arrayToBeSorted[dPassCount], digitWanted);
                arrayOfBuckets[bucketIndex][bucketContains[bucketIndex]] = arrayToBeSorted[dPassCount];
                bucketContains[bucketIndex]++;
            }

            //Gathering Pass
            int gatheringPassIndex = 0;
            for (int rowCount = 0; rowCount < arrayOfBuckets.length; rowCount++) {
                for (int colCount = 0; colCount < arrayOfBuckets[rowCount].length; colCount++) {
                    if (arrayOfBuckets[rowCount][colCount] != -1) {
                        if (arrayToBeSorted[gatheringPassIndex] != arrayOfBuckets[rowCount][colCount]) {
                            changesMade = true;
                        }
                        arrayToBeSorted[gatheringPassIndex] = arrayOfBuckets[rowCount][colCount];
                        gatheringPassIndex++;
                    }
                }
            }
            digitWanted++;
        }
        return arrayToBeSorted;
    }

    /**
     * This is a helper method for sort. It takes in a number and and index, and returns the value at the
     * tens place of that index
     * @param num   value wanted the tens place from
     * @param digitWanted   what tens place is wanted to return
     * @return int number at that location of the input value
     */
    private static int bucketIndex(int num, int digitWanted) {
        String numString = Integer.toString(num);
        if (numString.length() < digitWanted) {
            return 0;
        } else {
            return Character.getNumericValue(numString.toCharArray()[numString.length() - (digitWanted)]);
        }
    }
}
