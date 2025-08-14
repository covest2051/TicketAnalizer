import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd.MM.yy H:mm");


    public static void main(String[] args) throws IOException {

        if (args.length < 1) {
            return;
        }
        String filePath = args[0];

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(new File(filePath));
        JsonNode tickets = root.get("tickets");

        Map<String, Long> minFlightTimes = new HashMap<>();
        List<Integer> prices = new ArrayList<>();

        for (JsonNode ticket : tickets) {
            String origin = ticket.get("origin").asText();
            String destination = ticket.get("destination").asText();

            if (origin.equals("VVO") && destination.equals("TLV")) {
                String carrier = ticket.get("carrier").asText();
                int price = ticket.get("price").asInt();
                prices.add(price);

                LocalDateTime departure = LocalDateTime.parse(
                        ticket.get("departure_date").asText() + " " + ticket.get("departure_time").asText(),
                        DATE_FORMAT
                );
                LocalDateTime arrival = LocalDateTime.parse(
                        ticket.get("arrival_date").asText() + " " + ticket.get("arrival_time").asText(),
                        DATE_FORMAT
                );

                long flightMinutes = Duration.between(departure, arrival).toMinutes();
                minFlightTimes.merge(carrier, flightMinutes, Math::min);
            }
        }

        System.out.println("Min flight time (in hours and minutes) for each carrier:");
        for (Map.Entry<String, Long> entry : minFlightTimes.entrySet()) {
            long hours = entry.getValue() / 60;
            long minutes = entry.getValue() % 60;
            System.out.printf("Carrier %s: %dh %dm%n", entry.getKey(), hours, minutes);
        }

        double avgPrice = prices.stream().mapToInt(Integer::intValue).average().orElse(0);
        double medianPrice = calculateMedian(prices);

        System.out.printf("The difference between the average price and the median: %.2f%n", avgPrice - medianPrice);
    }

    private static double calculateMedian(List<Integer> prices) {
        List<Integer> sorted = prices.stream().sorted().toList();
        int size = sorted.size();
        if (size % 2 == 0) {
            return (sorted.get(size / 2 - 1) + sorted.get(size / 2)) / 2.0;
        } else {
            return sorted.get(size / 2);
        }

    }
}
