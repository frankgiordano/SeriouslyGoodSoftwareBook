
/*
Water containers, all identical and equipped with a virtually unlimited capacity. At any given time, a
container holds a certain amount of liquid, and any two containers can be permanently connected by a pipe.
Instead of sending messages, you can pour water in or remove it from a container. Whenever two or more containers
are connected, they become communicating vessels and from that time on they split equally the liquid contained in them.
 */
public class Container {

    private Container next = this;
    private double amount;

    public double getAmount() {
        updateGroup();
        return amount;
    }

    public void addWater(double amount) {
        this.amount += amount;
    }

    public void updateGroup() {
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