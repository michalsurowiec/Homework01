package pl.coderslab.collection;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main1 {

    public static void main(String[] args) {
        File file = new File("src/pl/coderslab/collection/earnings.txt");
        try {
            Scanner scanner = new Scanner(file);
            int index = 1;
            Map<Integer, String> mapOfEmployees = new HashMap<>();

            while (scanner.hasNextLine()) {
                String lineFromEarnings = scanner.nextLine();
                if (!(Pattern.matches(".*Kowalsk.*", lineFromEarnings))) {
                    mapOfEmployees.put(index, lineFromEarnings);
                    index++;
                }
            }

            index = 1;
            Map<Integer, Integer> mapOfSalaries = new HashMap<>();
            while (mapOfEmployees.containsKey(index)){
                String lineToExamine = mapOfEmployees.get(index);
                Pattern pattern = Pattern.compile("\\d+\\.");
                Matcher matcher = pattern.matcher(lineToExamine);
                int startSubstring = -1;
                int endSubstring = -1;

                while (matcher.find()) {
                    startSubstring = matcher.start();
                    endSubstring = matcher.end();
                }

                if (startSubstring > -1 && endSubstring > -1) {
                    String foundValue = lineToExamine.substring(startSubstring, endSubstring-1);
                    int foundValueParsed = Integer.parseInt(foundValue);
                    mapOfSalaries.put(index, foundValueParsed);
                }
                index++;
            }

            int[] tableOfBiggestSalaries = new int[3];
            Set<Integer> keySet = mapOfSalaries.keySet();
            Iterator<Integer> iterator = keySet.iterator();
            for (int i = 0; i < tableOfBiggestSalaries.length; i ++) {
                if (iterator.hasNext()) {
                    tableOfBiggestSalaries[i] = iterator.next();
                }
            }

            while (iterator.hasNext()) {
                int iteratorValue = iterator.next();
                for (int i = 0; i < tableOfBiggestSalaries.length; i++) {
                    if (mapOfSalaries.get(tableOfBiggestSalaries[i]) < mapOfSalaries.get(iteratorValue)){
                        tableOfBiggestSalaries[i] = iteratorValue;
                        break;
                    }
                }
            }

            System.out.println("Pracownicy o najwyższej pensji do zwolnienia:");
            for (int mapIndex : tableOfBiggestSalaries) {
                System.out.println(mapOfEmployees.get(mapIndex));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
