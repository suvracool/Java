import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    record Place (String name,int distance) {
        @Override
        public String toString(){
            return String.format("%s (%d)",name,distance);
        }
    }
    public static void main(String[] args) {
        LinkedList<Place> placesToVisit = new LinkedList<>();

        Place Adeleaide = new Place("Adelaide",1400);
        addPlace(placesToVisit,Adeleaide);
        addPlace(placesToVisit,new Place("adelaide",1400));
        addPlace(placesToVisit,new Place("Brisbane",917));
        addPlace(placesToVisit,new Place("Perth",3923));
        addPlace(placesToVisit,new Place("Darwin",3972));
        addPlace(placesToVisit,new Place("Sydney",0));
        System.out.println("Current content of the list " + placesToVisit);

        var iterator = placesToVisit.listIterator();
        Scanner scanner = new Scanner(System.in);
        boolean quitLoop= false;
        boolean forward=true;

        printMenu();
        while (!quitLoop){

            //To check if we are at the start of the list.
            //iterator.hasPrevious should be false if we are at the start of the list
            if(!iterator.hasPrevious()){
                System.out.println("Originating: " + iterator.hasNext());
                //Since we are at the start, we can only go forward and hence setting forward as true.
                forward=true;
            }

            if(!iterator.hasNext()){
                System.out.println("Ending: " + iterator.hasPrevious());
                //Since we are at the end, we can only go backward and hence setting forward as false.
                forward=false;
            }
            System.out.println("Enter a value:");

            String menuItem=scanner.nextLine().toUpperCase().substring(0,1);

            switch (menuItem) {
                case "F":
                    System.out.println("User wants to move forward");
                    if(!forward){           //Reversing Direction
                        forward=true;
                        if(iterator.hasNext()){
                            iterator.next();     //Adjust position forward
                        }
                    }

                    if(iterator.hasNext()){
                        System.out.println(iterator.next());
                    }


                    break;
                case "B":
                    System.out.println("User wants to move backward");

                    if(forward){           //Reversing Direction
                        forward=false;
                        if(iterator.hasPrevious()){
                            iterator.previous();     //Adjust position backward
                        }
                    }
                    if(iterator.hasPrevious()){
                        System.out.println(iterator.previous());
                    }
                    break;
                case "M":
                    printMenu();
                    break;
                case "L":
                    System.out.println(placesToVisit);
                    break;
                default:
                    quitLoop=true;
                    break;
            }
        }



    }

    private static void addPlace(LinkedList<Place> list, Place place){
        if(list.contains(place)){
            System.out.println("Duplicate place " + place);
            return;
        }

        for (Place p:list){
            if(p.name().equalsIgnoreCase(place.name())){
                System.out.println("Duplicate place " + place);
                return;
            }
        }

        int matchedIndex=0;
        for (var p1:list){
            if(place.distance()< p1.distance()){
                list.add(matchedIndex,place);
                return;
            }

            matchedIndex++;
        }

        list.add(place);

    }

    private static void printMenu(){
        System.out.println("""
                Available Actions (select word or letter):
                (F)orward
                (B)ackward
                (L)ist Places
                (M)enu
                (Q)uit """);
    }
}