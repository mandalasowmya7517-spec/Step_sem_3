import java.util.Scanner;

interface Question {
    double grade(String studentAnswer);
    String getType();
}

class Mcq implements Question {
    private String correct;
    private double points;
    public Mcq(String correct, double points) { this.correct = correct; this.points = points; }
    public double grade(String studentAnswer) {
        return studentAnswer.equalsIgnoreCase(correct) ? points : 0;
    }
    public String getType() { return "MCQ"; }
}

class Tf implements Question {
    private String correct;
    private double points;
    public Tf(String correct, double points) { this.correct = correct; this.points = points; }
    public double grade(String studentAnswer) {
        return studentAnswer.equalsIgnoreCase(correct) ? points : 0;
    }
    public String getType() { return "TF"; }
}

class Essay implements Question {
    private String[] keywords;
    private double points;
    public Essay(String correct, double points) {
        this.keywords = correct.split(",");
        this.points = points;
    }
    public double grade(String studentAnswer) {
        int count = 0;
        for (String k : keywords) {
            if (studentAnswer.toLowerCase().contains(k.trim().toLowerCase())) count++;
        }
        if (count >= 2) return points * 0.75;
        if (count == 1) return points * 0.5;
        return 0;
    }
    public String getType() { return "ESSAY"; }
}

public class ExamSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split("\"");
            String type = parts[0].trim().split(" ")[0];
            String correct = parts[2].trim();
            String student = parts[4].trim();
            double points = Double.parseDouble(parts[5].trim());
            Question q;
            switch (type) {
                case "MCQ": q = new Mcq(correct, points); break;
                case "TF": q = new Tf(correct, points); break;
                default: q = new Essay(correct, points); break;
            }
            double score = q.grade(student);
            System.out.printf("%s: %.2f%n", q.getType(), score);
            total += score;
        }
        System.out.printf("Total Score: %.2f", total);
        sc.close();
    }
}
