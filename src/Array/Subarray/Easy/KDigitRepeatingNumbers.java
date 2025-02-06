package Array.Subarray.Easy;

import java.util.HashMap;
import java.util.Map;

public class KDigitRepeatingNumbers {
    public static void printKDigit(String str, int K){
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i <= str.length() - K ; i++) {
            String a = str.substring(i, i+K);
            map.put(a, map.getOrDefault(a, 0) +1);
        }

        for(Map.Entry<String, Integer> entry: map.entrySet()){
            if(entry.getValue() > 1){
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
        }
    }
    public static void main(String[] args) {
        String str = "123412345123456";
        int K = 4;
        printKDigit(str, K);
    }
}
