package TaskManager;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

public class TaskOptionsOperation {
    public class ArrayUtilsSample {

        public static void main(String[] args) {
            String[] firstNames = {"Abigail", "Alexandra", "Alison", "Amanda"}; // tworzymy tablicę
            System.out.println(Arrays.toString(firstNames)); // wyświetlamy testowo jej elementy
            firstNames = ArrayUtils.remove(firstNames, 0); //
            System.out.println(Arrays.toString(firstNames));
        }
    }

}
