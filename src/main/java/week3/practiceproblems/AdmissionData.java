class AdmissionData {
    static int total = 0;

    AdmissionData() {
        total++;
    }

    public static void main(String[] args) {
        AdmissionData a1 = new AdmissionData();
        AdmissionData a2 = new AdmissionData();
        AdmissionData a3 = new AdmissionData();

        System.out.println("Total applicants: " + AdmissionData.total);
    }
}