/*
Exercise 9: Hero Class
 */
public class Hero {
    private final String name;
    private final String activeSentence;

    // #9.1 A constructor that takes a name of the hero
    public Hero(String name) {
        this.name = name;
        this.activeSentence = "Active";
    }

    // #9.2 A second constructor that takes a name of the hero and a sentence that the hero says when they are active
    public Hero(String name, String activeSentence) {
        this.name = name;
        this.activeSentence = activeSentence;
    }

    // #9.3 A method called active that prints out the name of the hero and the sentence that the hero says when they are active
    public void active() {
        System.out.println(this.name + " said " + this.activeSentence);
    }

    // testing
    public static void main(String[] args) {
        Hero hero = new Hero("Superman");
        hero.active();

        Hero anotherHero = new Hero("Batman", "I'm Batman");
        anotherHero.active();
    }
}
