import java.io.*;
import java.util.*;

public class DietPlanReader {

    public static List<String[]> readAll() {
        List<String[]> meals = new ArrayList<>();
        try {
            InputStream is = DietPlanReader.class.getResourceAsStream("/diet_plan.txt");
            if (is == null) {
                System.out.println("diet_plan.txt not found!");
                return meals;
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            br.readLine(); // skip header
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    meals.add(line.split("\\|"));
                }
            }
            br.close();
            System.out.println("Rows loaded: " + meals.size()); // debug
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return meals;
    }

    // Simple filter — only disease + mealType
    public static List<String[]> filter(String disease, String mealType) {
        List<String[]> result = new ArrayList<>();
        for (String[] meal : readAll()) {
            if (meal.length < 4) continue;
            if (!meal[0].trim().equalsIgnoreCase(disease)) continue;
            if (!meal[1].trim().equalsIgnoreCase(mealType)) continue;
            result.add(meal);
        }
        return result;
    }
}