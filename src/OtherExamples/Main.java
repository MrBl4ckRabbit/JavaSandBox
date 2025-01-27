package OtherExamples;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        IntStream.of(120, 140, 620, 32, 55)
                .filter(x -> x < 300)
                .map(x -> x + 11)
                .limit(4)
                .forEach(System.out::println);

        System.out.println("************");

        var list = List.of(1, 2, 13, 4, 5, 6, 7);

        var list2 = list.parallelStream()
                .filter(x -> x > 10)
                .map(x -> x * 2)
                .toList();

        for (Integer i : list2) {
            System.out.println(i);
        }
        System.out.println("************");
        var amount = IntStream.range(0, 10)
                .parallel()
                .map(x -> x * 10)
                .sum();
        System.out.println(amount);
        System.out.println("************");
        Stream.generate(() -> 7)
                .limit(7)
                .forEach(System.out::print);
        System.out.println("************");

        IntStream.range(-10, 10)
                .forEach(System.out::print);
        System.out.println("************");
        IntStream.rangeClosed(-10, 10)
                .forEach(System.out::print);
        System.out.println("************");
       Stream.of("1", "2", "abc")
                .map(x -> {
                    try {
                        return Integer.parseInt(x);
                    } catch (IllegalArgumentException e) {
                        System.out.println(" Invalid value " + x);
                    }
                    return null;
                })
                .filter(Objects::nonNull)
                .map(x -> x + 10)
                .map(String::valueOf)
                .collect(Collectors.joining(","));

        System.out.println("************");
        Stream.of("10", "11", "32")
                        .map(x -> Integer.parseInt(x, 16))
                        .forEach(System.out::println);
        System.out.println("************");
        List<String> sentences = Arrays.asList( "Hello world", "Stream API is powerful", "flatMap is useful" );
        List<String> words = sentences.stream()
                .flatMap(s->Arrays.stream(s.split(",")))
                .toList();
        words.forEach(System.out::print);
        System.out.println("************");
        IntStream.concat(
                IntStream.range(2,5),
                IntStream.range(0,4))
                .distinct()
                .forEach(System.out::println);

        System.out.println("************");

        Stream.of(0, 3, 0, 0, 5)
                .peek(x-> System.out.format("before distinct: %d%n",x))
                .distinct()
                .peek(x-> System.out.format("after distinct: %d%n",x))
                .map(x->x*x)
                .forEach(x-> System.out.format("after map: %d%n",x));
        System.out.println("************");

        var num=IntStream.range(0,10)
                .filter(x->x++%4==0)
                .reduce((acc,x)->acc*x)
                .getAsInt();
        System.out.println(num);

        Stream.of(120, 410, 86, 32, 314, 12)
                .noneMatch(x -> x % 2 == 1);
        boolean res= true;

      var list1=  Stream.of(1, 2, 3, 1, 9, 2, 5, 3, 4, 8, 2)
                .sorted()
                .distinct()
                .toList();
      list1.forEach(System.out::println);

        for (int i = 0; i < 5; i++) {
            for (char letter = 'a'; letter <= 'f'; letter++) {
                if (letter < 'f') {
                    continue;
                }
                System.out.println(letter);
            }
        }

    }
}