package main;

import java.util.ArrayList;
import java.util.List;

public class Icecream {

    private List<Flavor> flavors;
    private List<Integer> flavorsCount;
    private int scoops = 0;

    public Icecream() {
        this.flavors = new ArrayList<Flavor>();
        this.flavorsCount = new ArrayList<Integer>();
    }

    public void addScoop(Flavor flavor) {
        boolean found = false;
        for (int i = 0; i < flavors.size(); i++) {
            if (flavors.get(i).getName().equals(flavor.getName())) {
                flavorsCount.set(i, flavorsCount.get(i)+1);
                found = true;
                break;
            }
        }
        if (!found) {
            flavors.add(flavor);
            flavorsCount.add(1);
        }
        scoops++;
    }

    public void removeScoop(Flavor flavor) {
        for (int i = 0; i < flavors.size(); i++) {
            if (flavors.get(i).getName().equals(flavor.getName())) {
                flavorsCount.set(i, flavorsCount.get(i)-1);
                scoops--;
                if (flavorsCount.get(i) == 0) {
                    flavors.remove(i);
                    flavorsCount.remove(i);
                }
                break;
            }
        }
    }

    public int getScoopCount() {
        return scoops;
    }

    public boolean contains(String flavorName) {
        for (Flavor flavor: flavors)
            if (flavor.getName().equals(flavorName))
                return true;
        return false;
    }

    public int getFlavorCount() {
        return flavors.size();
    }
}
