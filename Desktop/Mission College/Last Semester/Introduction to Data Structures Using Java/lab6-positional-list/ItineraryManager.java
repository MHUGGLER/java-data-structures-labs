public class ItineraryManager {
    public static void main(String[] args) {
        LinkedPositionalList<String> itinerary = new LinkedPositionalList<>();

        LinkedPositionalList.Position<String> p1 = itinerary.addLast("Santa Clara, California");
        LinkedPositionalList.Position<String> p2 = itinerary.addLast("Los Angeles, California");
        LinkedPositionalList.Position<String> p3 = itinerary.addLast("Las Vegas, Nevada");
        itinerary.addLast("Grand Canyon, Arizona");

        itinerary.addAfter(p1, "San Francisco, California");

        System.out.println("Travel Itinerary:");
        for (String stop : itinerary) {
            System.out.println(stop);
        }
    }
}
