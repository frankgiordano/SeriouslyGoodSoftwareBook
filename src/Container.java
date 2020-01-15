import java.util.HashSet;
import java.util.Set;

/*
Water containers , all identical and equipped with a virtually unlimited capacity. At any given time, a
container holds a certain amount of liquid, and any two containers can be permanently connected by a pipe.
Instead of sending messages, you can pour water in or remove it from a container. Whenever two or more containers
are connected, they become communicating vessels and from that time on they split equally the liquid contained in them.
 */
public class Container {

    private Set<Container> group;
    private double amount;

    public Container() {
        group = new HashSet<Container>();
        group.add(this);
        amount = 0;
    }

    public double getAmount() {
        return amount;
    }

    public void addWater(double amount) {
        double amountPerContainer = amount / group.size();
        for (Container c: group) {
            c.amount += amountPerContainer;
        }
    }

    public void connectTo(Container other) {

        // If they are already connected, do nothing
        if (group == other.group) return;

        int size1 = group.size();
        int size2 = other.group.size();
        double tot1 = amount * size1;
        double tot2 = other.amount * size2;
        double newAmount = (tot1 + tot2) / (size1 + size2);

        // Merge the two groups
        group.addAll(other.group);

        for (Container c: other.group)
            c.group = group;
        for (Container c: group)
            c.amount = newAmount;

    }
}