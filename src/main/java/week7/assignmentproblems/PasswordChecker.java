public final class PasswordChecker {
    private final String password;

    public PasswordChecker(String password) {
        this.password = password;
    }

    public String getStrength() {
        int length = password.length();
        boolean hasDigit = password.matches(".*\\d.*");

        if (length < 6) {
            return "Weak";
        } else if (length <= 9) {
            return hasDigit ? "Medium+" : "Medium";
        } else {
            return hasDigit ? "Strong+" : "Strong";
        }
    }

    public static void main(String[] args) {
        PasswordChecker pc1 = new PasswordChecker("abcd");
        System.out.println(pc1.getStrength()); // Weak

        PasswordChecker pc2 = new PasswordChecker("abcdefgh");
        System.out.println(pc2.getStrength()); // Medium

        PasswordChecker pc3 = new PasswordChecker("abcdefghij1");
        System.out.println(pc3.getStrength()); // Strong+
    }
}
