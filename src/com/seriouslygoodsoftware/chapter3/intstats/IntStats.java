package com.seriouslygoodsoftware.chapter3.intstats;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Fast insertion
 *
 * Design the class IntStats so that insert and getAverage take constant time.
 */
public class IntStats {

    private List<Integer> arrayOfNums = new ArrayList<Integer>();
    private int sumOfAllNums = 0;

    public void insert(int n) {
        arrayOfNums.add(n);
        sumOfAllNums += n;
    }

    public double getAverage() {
        return (sumOfAllNums * 1.0 / arrayOfNums.size() * 1.0);
    }

    public double getMedian() {
        Collections.sort(arrayOfNums);
        int size = arrayOfNums.size();

        if (size % 2 != 0) {
            int index = (size / 2);
            return arrayOfNums.get(index);
        }

        int index1 = (size / 2) - 1;
        int index2 = index1 + 1;
        return (arrayOfNums.get(index1) + arrayOfNums.get(index2)) / 2.0;
    }

    public static void main(String[] args) {
        IntStats stats = new IntStats();
        stats.insert(2);
        stats.insert(3);
        stats.insert(4);
        stats.insert(5);
        stats.insert(12);
        System.out.println(stats.getAverage());
        System.out.println(stats.getMedian());
    }

}
