package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.Long.sum;

public class Main {
    public static void main(String[] args) {


        int[] numbers = {1, 2, 5, 7,20};
        int stream = (int) Arrays.stream(numbers)
                .average().orElse(0);

        System.out.println(stream);
    }
}