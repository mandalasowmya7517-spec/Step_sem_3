class SubjectData {
    String subjectCode;
    String subjectName;

    SubjectData(String code, String name) {
        subjectCode = code;
        subjectName = name;
    }

    public static void main(String[] args) {
        SubjectData s = new SubjectData("21CSC201J", "Data Structures");

        System.out.println(s.subjectCode + " - " + s.subjectName);
    }
}