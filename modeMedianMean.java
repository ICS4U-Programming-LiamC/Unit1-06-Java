import java.util.*;  
import java.io.File;


class modeMedianMean {   
    public static float Mean(List<Integer> arrayMean) {
        float mean;
        System.out.println(arrayMean);
        float total = 0;
        for (int index = 0; index < arrayMean.size(); index++) {
            total += arrayMean.get(index);
        }
        mean = total / arrayMean.size();
        System.out.println(mean);
        return mean;
    }

    public static float Median(List<Integer> arrayMedian) {
        float median = 0;
        return median;
    }

    public static float Mode(List<Integer> arrayMode) {
        float mode = 0;
        return mode;
    }
    
    public static void main(String[] args) throws Exception {
        List<String> originalListString = new ArrayList<String>();
        // pass the path to the file as a parameter
        File file = new File("./Unit1/Java/Unit1-06-Java/set1.txt");
        Scanner sc = new Scanner(file);
 
        while (sc.hasNextLine())
        {
            originalListString.add(sc.nextLine());
        }
        System.out.println(originalListString);

        List<Integer> listInt = new ArrayList<Integer>();

        float mean = Mean(listInt);
        System.out.println(mean);
        float median = Median(listInt);
        System.out.println(median);
        float mode = Mode(listInt);
        System.out.println(mode);
    }
}
