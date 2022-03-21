
/**
* The modeMedianMean calculator finds the mode median and mean
* of a given txt file filled with numbers
*
* @author  Liam Csiffary
* @version 1.12
* @since   2022-03-11
*/

import java.io.File;
import java.util.*;

// main class
class modeMedianMean {
  // mean calculator
  public static float Mean(int[] arrayMean) {
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
  public static float Median(int[] sortedArrayMedian) {
    // define vars
    float median = 0;

    // finds the middle of the array and sets that/those number(s) to the median
    if (sortedArrayMedian.length % 2 == 0) {
      median = sortedArrayMedian[sortedArrayMedian.length / 2];
    } else {
      median = (sortedArrayMedian[(sortedArrayMedian.length / 2) - 1]
          + sortedArrayMedian[(sortedArrayMedian.length)]) / 2;
    }

    return median;
  }

  // mode calculator
  public static List<Integer> Mode(int[] sortedArrayMode) {
    // define vars
    List<Integer> modes = new ArrayList<Integer>();
    int currentCounter = 0;
    int highestCounter = 0;

    // set currentNum to count
    int currentNum = sortedArrayMode[0];

    // creates a new array one larger than the old one
    // populates it with the same numbers but with a -1 at the end
    int[] sortedArrayPlusOne = new int[sortedArrayMode.length + 1];
    for (int index = 0; index < sortedArrayMode.length; index++) {
      sortedArrayPlusOne[index] = sortedArrayMode[index];
    }
    sortedArrayPlusOne[sortedArrayMode.length] = -1;

    // counts how many of each number there is
    for (int index = 0; index < sortedArrayMode.length; index++) {

      // if the number its looking for is the number at that index then
      // add 1 to the counter
      if (currentNum == sortedArrayMode[index]) {
        currentCounter += 1;

      } else {
        // once not true we check if its the number that has appeared the most
        // if it is empty the old list and add the current num
        if (currentCounter > highestCounter) {
          highestCounter = currentCounter;
          modes.clear();
          modes.add(sortedArrayMode[index - 1]);
        }

        // if it appears the same number of times then
        // add it to the list only
        else if (currentCounter == highestCounter) {
          modes.add(sortedArrayMode[index - 1]);
        }

        // set the new num to count for
        currentNum = sortedArrayMode[index];

        // set the number of times that number has appeared to 1
        currentCounter = 1;
      }
    }
    return modes;
  }

  // seems to need the exception or the Scanner(file) complains
  public static void main(String[] args) throws Exception {
    // defining vars
    List<String> originalListString = new ArrayList<String>();
    String txtFileNum = "";
    // gets the file you want to run
    Scanner myObj = new Scanner(System.in);
    while (!txtFileNum.equals("1") && !txtFileNum.equals("2") && !txtFileNum.equals("3")) {
      System.out.println("Which txt file: 1, 2, or 3: ");
      txtFileNum = myObj.nextLine();
    }
    File file = new File(
        "C:/Users/s299776/ICS4U/Unit1/Java/Unit1-06-Java/set" + txtFileNum + ".txt");

    System.out.println(file);
    Scanner sc = new Scanner(file);

    // for my inificient code to sort
    int biggestInt = 0;

    // pass the path to the file as a parameter
    while (sc.hasNextLine()) {
      originalListString.add(sc.nextLine());
    }

    System.out.println(originalListString);

    // List<Integer> listInt = new ArrayList<Integer>();
    int[] arrayInt = new int[originalListString.size()];
    int[] sortedArray = new int[originalListString.size()];

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
    // finds the biggest number in the array
    for (int index = 0; index < arrayInt.length; index++) {
      if (arrayInt[index] > biggestInt) {
        biggestInt = arrayInt[index];
      }
    }

    // for the sorted array
    int numToLookFor = 0;
    int counter = 0;
    while (numToLookFor <= biggestInt) {
      for (int index = 0; index < arrayInt.length; index++) {
        if (numToLookFor == arrayInt[index]) {
          sortedArray[counter] = numToLookFor;
          counter += 1;
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
