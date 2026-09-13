class RoomData {
    String number;
    int count;

    public static void main(String[] args) {
        RoomData room1 = new RoomData();
        RoomData room2 = new RoomData();

        room1.number = "C-101";
        room2.number = "C-102";

        room1.count++;
        room1.count++;
        room1.count++;

        System.out.println(room1.number + " occupied: " + room1.count);
        System.out.println(room2.number + " occupied: " + room2.count);
    }
}