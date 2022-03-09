import java.util.*;
import java.io.File;

// main class
class modeMedianMean {   
    // mean calculator
    public static float Mean(int arrayMean[]) {
        // define vars
        float mean;
        float total = 0;
        // adds up all the number in the file
        for (int index = 0; index < arrayMean.length; index++) {
            total += arrayMean[index];
        }
        // Divide by the number of numbers
        mean = total / arrayMean.length;
        return mean;
    }

    // median calculator
    public static float Median(List<Integer> sortedArrayMedian) {
        // define vars
        float median = 0;

        // continues to remove the outsides until theres 1 or 2 numbers left
        while (sortedArrayMedian.size() > 2) {
            sortedArrayMedian.remove(0);
            sortedArrayMedian.remove(sortedArrayMedian.size()-1);
        }
        // System.out.println(sortedArray + " Median");

        // if theres two medians calculate the average of the two
        if (sortedArrayMedian.size() == 2) {
            median = (sortedArrayMedian.get(0) + sortedArrayMedian.get(1)) / 2;
        }

        return median;
    }

    // mode calculator
    public static List<Integer> Mode(List<Integer> sortedArrayMode) {
        // define vars
        List<Integer> modes = new ArrayList<Integer>();
        int currentCounter = 0;
        int highestCounter = 0;
        // set currentNum to count
        int currentNum = sortedArrayMode.get(0);

        // counts how many of each number there is
        for (int index = 0; index < sortedArrayMode.size(); index++) {
            // if the number its looking for is the number at that index then
            // add 1 to the counter 
            if (currentNum == sortedArrayMode.get(index)) {
                currentCounter += 1;
            } else {
                // once not true we check if its the number that has appeared the most
                // if it is empty the old list and add the current num
                if (currentCounter > highestCounter) {
                    highestCounter = currentCounter;
                    modes.clear();
                    modes.add(sortedArrayMode.get(index - 1));
                }
                // if it appears the same number of times then
                // add it to the list only 
                else if (currentCounter == highestCounter) {
                    modes.add(sortedArrayMode.get(index - 1));
                }
                // set the new num to count for
                currentNum =  sortedArrayMode.get(index);
                // set the number of times that number has appeared to 1
                currentCounter = 1;
            }
        }
        return modes;
    }
    
    public static void main(String[] args) throws Exception {
        // defining vars
        List<String> originalListString = new ArrayList<String>();
        File file = new File("./Unit1/Java/Unit1-06-Java/set3.txt");
        Scanner sc = new Scanner(file);

        // for the sorted array
        int numToLookFor = 0;

        // for my inificient code to sort
        int biggestInt = 0;

        // pass the path to the file as a parameter
        while (sc.hasNextLine())
        {
            originalListString.add(sc.nextLine());
        }

        System.out.println(originalListString);

        // List<Integer> listInt = new ArrayList<Integer>();
        int arrayInt[] = new int [originalListString.size()];

        List<Integer> sortedArray = new ArrayList<Integer>();

        // converts files list to a list of ints and checks for errors
        for (int index = 0; index < originalListString.size(); index++) {
            try {
                int convertedInt = Integer.parseInt(originalListString.get(index));
                arrayInt[index] = convertedInt;
            } catch (NumberFormatException e) {
                System.out.println("Something in the file was not an integer");
            }
        }

        // these two sort the list
        for (int index = 0; index < arrayInt.length; index++) {
            if (arrayInt[index] > biggestInt) {
                biggestInt = arrayInt[index];
            }
        }

        while (numToLookFor <= biggestInt) {
            for (int index = 0; index < arrayInt.length; index++) {
                if (numToLookFor == arrayInt[index]) {
                    sortedArray.add(numToLookFor);
                }
            }
            numToLookFor += 1;
        }

        // calls the functions to get the three
        float mean = Mean(arrayInt);
        List<Integer> mode = Mode(sortedArray);
        float median = Median(sortedArray);

        // prints them
        System.out.println("The mean is " + mean);
        System.out.println("The median is " + median);
        System.out.println("The mode(s) is/are " + mode);
    }
}
