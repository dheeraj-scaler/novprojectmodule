package com.lld.basics.mergesort;

import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.concurrent.*;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> arrayToSort = List.of(
                10,2,8,11,4,3,9
        );

        ExecutorService es = Executors.newCachedThreadPool();
        // Create an object of the task

        Sorter sorter = new Sorter(arrayToSort, es);

        Future<List<Integer>> sortedData = es.submit(sorter);

        List<Integer> sortedList = sortedData.get();

        for(Integer in: sortedList){
            System.out.println(in);
        }

        es.shutdown();

    }
}
