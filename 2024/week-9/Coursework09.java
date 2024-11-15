/*
Coursework 1 #9
 */
public class Coursework09 {
    private final String name;
    private final boolean ifMale;

    public Coursework09(String name, boolean ifMale) {
        this.name = name;
        this.ifMale = ifMale;
    }

    // # 9.1
    public Coursework09(String name) {
        this(name, true);
    }

    // # 9.3
    public String count(Coursework09 other) {
        int sum = this.ifMale ? 0 : 1;
        if (!other.ifMale) {
            sum++;
        }
        return sum + " Female";
    }

    public static void main(String[] args) {
        Coursework09 person1 = new Coursework09("Alice", false);
        Coursework09 person2 = new Coursework09("Bob", false);
        Coursework09 person3 = new Coursework09("Charlie");
        Coursework09 person4 = new Coursework09("David", true);

        System.out.println(person1.count(person2));
        System.out.println(person1.count(person3));
        System.out.println(person2.count(person3));
        System.out.println(person3.count(person4));

    }
}
