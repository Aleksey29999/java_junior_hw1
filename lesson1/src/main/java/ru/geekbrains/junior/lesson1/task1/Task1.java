package ru.geekbrains.junior.lesson1.task1;


//package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.Long.sum;

public class Task1 {
        public static void main(String[] args) {


            int[] numbers = {1, 2, 5, 2,20, 14,8, 1, 2};
            int stream = (int) Arrays.stream(numbers)
                    .filter(x -> x % 2== 0)
                    .average().orElse(0);

            System.out.println(stream);
        }
    }
