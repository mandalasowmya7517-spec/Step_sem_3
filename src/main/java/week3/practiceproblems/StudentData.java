class StudentData {
    String studentName;
    int studentMarks;

    public static void main(String[] args) {
        StudentData s = new StudentData();

        s.studentName = "Divya";
        s.studentMarks = 88;

        System.out.println("Name: " + s.studentName + " | Marks: " + s.studentMarks);
    }
}