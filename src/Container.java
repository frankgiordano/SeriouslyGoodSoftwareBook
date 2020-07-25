import java.util.HashSet;
import java.util.Set;

/*
Water containers, all identical and equipped with a virtually unlimited capacity. At any given time, a
container holds a certain amount of liquid, and any two containers can be permanently connected by a pipe.
Instead of sending messages, you can pour water in or remove it from a container. Whenever two or more containers
are connected, they become communicating vessels and from that time on they split equally the liquid contained in them.
 */
public class Container {

    private Group group = new Group(this);

    private static class Group {
        double amountPerContainer;
        Set<Container> members; // #1 The set of all connected containers

        public Group(Container c) {
            members = new HashSet<Container>();
            members.add(c);
        }
    }

    public double getAmount() {
        return group.amountPerContainer;
    }

    public void addWater(double amount) {
        double amountPerContainer = amount / group.members.size();
        group.amountPerContainer = amountPerContainer;
    }

    public void connectTo(Container other) {

        // If they are already connected, do nothing
        if (group == other.group) return;

        int size1 = group.members.size();
        int size2 = other.group.members.size();
        double tot1 = group.amountPerContainer * size1;
        double tot2 = other.group.amountPerContainer * size2;
        double newAmount = (tot1 + tot2) / (size1 + size2);

        // Merge the two groups
        group.members.addAll(other.group.members);
        group.amountPerContainer = newAmount;

        for (Container x: other.group.members)
            x.group = group;
    }
}