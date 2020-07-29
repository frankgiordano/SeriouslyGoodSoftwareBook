package com.seriouslygoodsoftware.chapter3.usecase.speed1.exercise2;

import java.util.HashSet;
import java.util.Set;

/**
 * Add the groupSize method to the three water container implementations from this chapter without adding fields
 * or modifying any other method.
 *
 * groupSize — An instance method with no parameters that returns the number of containers connected directly
 * or indirectly to this one
 *
 * Add the flush method - An instance method with no parameters and no return value that empties all containers
 * connected directly or indirectly to this one
 */
public class Container {

    private Group group = new Group(this);

    private static class Group {
        double amountPerContainer;
        Set<Container> members;

        Group(Container c) {
            members = new HashSet<>();
            members.add(c);
        }
    }

    public void flush() {
        this.group.amountPerContainer = 0;
    }

    public int groupSize() {
        return this.group.members.size();
    }

    public double getAmount() {
        return group.amountPerContainer;
    }

    public void addWater(double amount) {
        double amountPerContainer = amount / group.members.size();
        group.amountPerContainer += amountPerContainer;
    }

    public void connectTo(Container other) {
        if (group == other.group) return;

        int size1 = group.members.size();
        int size2 = other.group.members.size();
        double tot1 = group.amountPerContainer * size1;
        double tot2 = other.group.amountPerContainer * size2;
        double newAmount = (tot1 + tot2) / (size1 + size2);

        group.members.addAll(other.group.members);
        group.amountPerContainer = newAmount;
        for (Container x : other.group.members) x.group = group;
    }

}
