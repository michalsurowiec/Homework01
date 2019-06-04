package pl.coderslab.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class GenerateRandom {

    public static void main(String[] args) {
        int amount = 5;
        int interval = 10;

        Map map = checkRand(amount, interval);
        Set <Integer> keys = map.keySet();
        for (int key : keys) {
            System.out.println(key + " " + map.get(key));
        }


    }

    public static Map<Integer, Integer> checkRand(int amount, int interval) {
        Random rng = new Random();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i <=amount; i++) {
            int randomNumber = rng.nextInt(interval);
            if (!(map.containsKey(randomNumber))) {
                map.put(randomNumber, 1);
            } else {
                int keyValue = map.get(randomNumber);
                keyValue++;
                map.put(randomNumber, keyValue);
            }
        }
        return map;
    }

}
