import java.util.*;

public class DutyRoster {
    public static List<String> rotateRoster(List<String> names, int k) {
        int n = names.size();
        k = k % n; 
        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(names.get((i - k + n) % n));
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> names = Arrays.asList("A", "B", "C", "D", "E");
        System.out.println(rotateRoster(names, 2)); // [D, E, A, B, C]
        System.out.println(rotateRoster(names, 7)); // [D, E, A, B, C]
    }
}
