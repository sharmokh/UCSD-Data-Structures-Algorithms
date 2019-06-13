import java.util.Scanner;

public class FractionalKnapsack {

    private static class Item {
        Double cost;
        int weight;
        int value;
        public Item(int value, int weight){
            this.weight = weight;
            this.value = value;
            this.cost = (double) value / weight;
        }
    }

    public static double getOptimalValue(int capacity, int[] values, int[] weights) {

        Item[] items = new Item[values.length];
        for (int i = 0; i < values.length; i++)
            items[i] = new Item(values[i], weights[i]);

        Arrays.sort(items, new Comparator<Item>(){
            public int compare(Item A, Item B) {
                return B.cost.compareTo(A.cost) ;
            }});

        double value = 0; int i = 0;
        while (capacity > 0 && i < items.length) {
            if (items[i].weight < capacity) {
                value += items[i].value;
                capacity -= items[i].weight;
            } else {
                value += (double) items[i].value * capacity / items[i].weight;
                capacity = 0;
            }
            i++;
        }
        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
}
