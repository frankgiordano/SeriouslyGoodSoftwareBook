package com.seriouslygoodsoftware.chapter3.intstats;

import java.util.ArrayList;
import java.util.List;

/**
 * Fast queries
 *
 * Design the class IntStats so that getAverage and getMedian take constant time.
 */
public class IntStatsV2 {

    private List<Integer> arrayOfNums = new ArrayList<Integer>();
    private int sumOfAllNums = 0;

    public void insert(int n) {
        sumOfAllNums += n;
        // instead of performing Collections.sort(arrayOfNums) here which will iterate over the entire
        // list, do a manuel check and insert it in position so in average cases we wont iterate over
        // the entire list
        int index = 0;
        for (Integer i: arrayOfNums) {
            if (n > i) {
               break;
            }
            index++;
        }
        arrayOfNums.add(index, n);
    }

    public double getAverage() {
        return ( (double) sumOfAllNums * 1.0 / (double) arrayOfNums.size() * 1.0);
    }

    public double getMedian() {
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
        IntStatsV2 stats = new IntStatsV2();
        stats.insert(2);
        stats.insert(5);
        stats.insert(3);
        stats.insert(4);
        stats.insert(6);
        stats.insert(12);
        System.out.println(stats.getAverage());
        System.out.println(stats.getMedian());
    }

}
