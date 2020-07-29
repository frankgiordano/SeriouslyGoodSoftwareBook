package com.seriouslygoodsoftware.chapter3.usecase.speed2.exercise2;

/**
 * Speed2
 *
 * A water container, optimized for speed of addWater and connectTo.
 *
 * Added the groupSize method - An instance method with no parameters that
 * returns the number of containers connected directly or indirectly to this one
 *
 * Add the flush method - An instance method with no parameters and no return value
 * that empties all containers connected directly or indirectly to this one
 */
public class Container {

    private Container next = this;
    private double amount;

    public void flush() {
        Container current = this;
        do {
            current.amount = 0;
            current = current.next;
        } while (current != this);
    }

    public int groupSize() {
        int groupSize = 1;  // start at 1 == this.. could use do.. while loop instead can start at 0 then
        Container current = this.next;
        while (current != this) {
            groupSize++;
            current = current.next;
        }
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
        Container current = this;
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

    public void connectTo(Container other) {
        Container oldNext = next;
        this.next = other;
        other.next = oldNext;
    }

}