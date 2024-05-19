package first;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

// Демонстрация использования лямбда-выражения, принимающего два параметра.
interface NumericTest2 {
    boolean test(int n, int d);

    class LambdaDemo3 {


        public static void main(String[] args) {

            Stream.empty();
            List.of(1, 2, 3).stream();
            new HashMap<String, String>().entrySet().stream();
            String[] strings = {"aaa", "sss", "ddd"};
            Arrays.stream(strings);

            Stream.<Integer>of(1, 2, 3);
        }
    }
}