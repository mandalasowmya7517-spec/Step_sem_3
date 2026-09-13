class CardData {
    String name;
    int issued;
    boolean status;

    public static void main(String[] args) {
        CardData c = new CardData();

        System.out.println("Holder: " + c.name);
        System.out.println("Books Issued: " + c.issued);
        System.out.println("Active: " + c.status);
    }
}