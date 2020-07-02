public record MyRecord(String name, int age) {

    public static void main(String[] args) {
        var record = new MyRecord("jigga", 33);
        System.out.println(record);
    }

}
