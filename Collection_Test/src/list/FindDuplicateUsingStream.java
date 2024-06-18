package test;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindDuplicateUsingStream {
    public static void main(String[] args) {
    	Integer[] array = {1, 2, 3, 4, 5, 2, 3, 6,6, 7, 8, 4};

        // Convert array to a list
        List<Integer> list = Arrays.asList(array);

        // Find duplicates using Stream API
        List<Integer> duplicates = list.stream()
                .filter(i -> list.indexOf(i) != list.lastIndexOf(i))
                .distinct()
                .collect(Collectors.toList());

        // Print duplicate elements
        System.out.println("Duplicate elements: " + duplicates);
    }
}
