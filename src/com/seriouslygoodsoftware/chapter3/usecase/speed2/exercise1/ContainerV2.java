package com.seriouslygoodsoftware.chapter3.usecase.speed2.exercise1;

/**
 * Speed2
 *
 * A water container, optimized for speed of addWater and connectTo.
 *
 * Added the groupSize method - An instance method with no parameters that
 * returns the number of containers connected directly or indirectly to this one
 *
 * Can you modify Speed2 so that groupSize takes constant time, without increasing
 * the asymptotic complexity of the other methods
 */
public class ContainerV2 {

    private ContainerV2 next = this;
    private double amount;
    private static int groupSize = 1;

    public int groupSize() {
        return groupSize;
    }

    public double getAmount() {
        updateGroup();
        return amount;
    }

    public void addWater(double amount) {
        this.amount += amount;
    }

    private void updateGroup() {
        ContainerV2 current = this;
        double totalAmount = 0;
        int groupSize = 0;

        do {
            totalAmount += current.amount;
            groupSize++;
            current = current.next;
        } while (current != this); // because it is circular
        double newAmount = totalAmount / groupSize;

        current = this;
        do {
            current.amount = newAmount;
            current = current.next;
        } while (current != this);
    }

    public void connectTo(ContainerV2 other) {
        ContainerV2 oldNext = next;
        this.next = other;
        other.next = oldNext;
        this.groupSize++;
    }

}
