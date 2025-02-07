package com.lld.basics.mergesort;

import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Sorter implements Callable<List<Integer>> {

    private List<Integer> arrayToSort;
    private ExecutorService executorService;

    public Sorter(List<Integer> arrayToSort, ExecutorService executorService) {
        this.arrayToSort = arrayToSort;
        this.executorService = executorService;
    }

    @Override
    public List<Integer> call() throws Exception {
        if(arrayToSort.size() <= 1) {
            return arrayToSort;
        }

        List<Integer> leftArray = new ArrayList<>();
        List<Integer> rightArray = new ArrayList<>();

        int mid = arrayToSort.size() / 2;
        for(int i = 0; i < mid; i++) {
            leftArray.add(arrayToSort.get(i));
        }

        for(int i = mid; i < arrayToSort.size(); i++) {
            rightArray.add(arrayToSort.get(i));
        }

        // Create a task for left and right

        Sorter leftSorter = new Sorter(leftArray, executorService);
        Sorter rightSorter = new Sorter(rightArray, executorService);

        Future<List<Integer>> leftSortedArrayFuture =  executorService.submit(leftSorter);




        Future<List<Integer>> rightSortedArrayFuture =  executorService.submit(rightSorter);

//        System.out.println("We are sorting");
//        System.out.println("We are sorting");
//
//        System.out.println("We are sorting");
//
//        System.out.println("We are sorting");

        List<Integer> sortedArray = new ArrayList<>();
        // At this point this thread has to wait for the data in leftSortedArrayFuture
        // and rightSortedArrayFuture

        // start waiting here
        List<Integer> leftSortedData = leftSortedArrayFuture.get();
        List<Integer> rightSortedData = rightSortedArrayFuture.get();


        // merging the data
        int i = 0; int j = 0;

        while(i<leftSortedData.size() && j < rightSortedData.size()) {
            if(leftSortedData.get(i) <= rightSortedData.get(j)) {
                sortedArray.add(leftSortedData.get(i));
                i++;
            } else {
                sortedArray.add(rightSortedData.get(j));
                j++;
            }
        }

        while(i<leftSortedData.size()) {
            sortedArray.add(leftSortedData.get(i));
            i++;
        }

        while(j<rightSortedData.size()) {
            sortedArray.add(rightSortedData.get(j));
            j++;
        }

    return sortedArray;

    }
}

// mergerSort
// If array length is <= 1 : return array
// calculate mid
// sort the left array
// sort the right array
// merge left and right
