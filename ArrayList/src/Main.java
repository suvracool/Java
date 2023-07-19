import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

record GroceryItem(String name, String type, int qty) {
}

public class Main {
    public static void main(String[] args) {

        ArrayList<GroceryItem> groceryItems = new ArrayList<>();

        //Adds new item into ArrayList.
        groceryItems.add(new GroceryItem("Orange", "Fruit", 2));
        groceryItems.add(new GroceryItem("Apple", "Fruit", 3));
        System.out.println(groceryItems);

        //If you specify an index in add method it will write the record in the index and adjust the rest of the elements if the index is already
        // used by other element.

        groceryItems.add(1, new GroceryItem("Milk", "Diary", 1));
        System.out.println(groceryItems);

        //Replaces the element at the specified position in this list with the specified element.
        groceryItems.set(1, new GroceryItem("Milk", "Diary", 2));
        System.out.println(groceryItems);


        ////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("#".repeat(100));
        String[] items = {"apples", "oranges", "guava", "milk"};
        List<String> list = List.of(items);

        ArrayList<String> groceries = new ArrayList<>(list);
        groceries.add("yogurt");
        System.out.println(groceries);

        ArrayList<String> nextList = new ArrayList<>(List.of("pickles", "mustard", "cheese"));
        System.out.println(nextList);
        groceries.addAll(nextList);
        System.out.println(groceries);

        //////Retrieving elements from ArrayList
        //get the 3rd item (or 2nd index)
        System.out.println("Third Item = " + groceries.get(2));

        //check if an ArrayList contains an element
        if (groceries.contains("mustard")) {
            System.out.println("List contains mustard");
        }

        //Use of indexof in ArrayList
        groceries.add("yogurt");
        System.out.println("first = " + groceries.indexOf("yogurt"));
        System.out.println("last =" + groceries.lastIndexOf("yogurt"));

        //removing elements

        System.out.println(groceries);
        groceries.remove(1);
        System.out.println(groceries);
        groceries.remove("yogurt");
        System.out.println(groceries);

        groceries.removeAll(List.of("apples", "eggs"));
        System.out.println(groceries);

        groceries.retainAll(List.of("apples", "milk", "mustard", "cheese"));
        System.out.println(groceries);

        groceries.clear();
        System.out.println(groceries);
        System.out.println("isEmpty = " + groceries.isEmpty());

        groceries.addAll(List.of("apples", "milk", "mustard", "cheese"));
        groceries.addAll(Arrays.asList("eggs", "pickles", "mustard", "ham"));

        //Sorts this list according to the order induced by the specified Comparator.
        System.out.println(groceries);
        groceries.sort(Comparator.naturalOrder());
        System.out.println(groceries);

        //Sorts this list according to the order induced by the specified Comparator.
        groceries.sort(Comparator.reverseOrder());
        System.out.println(groceries);

        //Returns an array containing all of the elements in this list in proper sequence (from first to last element);
        var groceryArray = groceries.toArray(new String[groceries.size()]);
        System.out.println(Arrays.toString(groceryArray));


    }
}