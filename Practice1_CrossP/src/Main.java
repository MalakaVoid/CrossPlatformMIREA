import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        String[] firstArrayString = inputString.split("_")[0].split(" ");
        String[] secondArrayString = inputString.split("_")[1].split(" ");

        Set<Integer> firstSet = new HashSet<>();
        for (String num : firstArrayString) {
            firstSet.add(Integer.parseInt(num));
        }

        Set<Integer> commonValues = new HashSet<>();
        for (String num : secondArrayString) {
            int number = Integer.parseInt(num);
            if (firstSet.contains(number)) {
                commonValues.add(number);
            }
        }

        Integer[] resultArray = commonValues.toArray(new Integer[0]);
        Arrays.sort(resultArray);

        printResult(resultArray);

    }

    public static void printResult(Integer[] result){

        StringBuilder output = new StringBuilder();

        for (Integer integer : result) {
            output.append(integer);
            output.append(" ");
        }

        System.out.println(output.toString().trim());

    }

}