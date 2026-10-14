public class Scorecard {
    
    private boolean[] results;

    
    private int count;

    public Scorecard(int totalQuestions) {
        results = new boolean[totalQuestions];
        count = 0;
    }

    
    public void recordAnswer(boolean isCorrect) {
        if (count < results.length) {
            results[count] = isCorrect;
            count++;
        } else {
            System.out.println("Cannot record more answers. Limit reached.");
        }
    }

    
    public int getScore() {
        int score = 0;
        for (int i = 0; i < count; i++) {
            if (results[i]) {
                score++;
            }
        }
        return score;
    }

    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);

        sc.recordAnswer(true);   // correct
        sc.recordAnswer(true);   // correct
        sc.recordAnswer(false);  // wrong
        sc.recordAnswer(true);   // correct

        System.out.println("Final Score: " + sc.getScore()); // Output: 3
    }
}
