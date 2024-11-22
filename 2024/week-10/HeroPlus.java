class HeroPlus extends Hero {
    private final String activePlus;
    
    public HeroPlus(String name, String activeSentence, String activePlus) {
        super(name, activeSentence);
        this.activePlus = activePlus;
    }

    @Override
    public void active() {
        super.active();
        System.out.println("then " + this.activePlus);
    }

    // testing
    public static void main(String[] args) {
        HeroPlus hero = new HeroPlus("Superman", "Active", "save the day!");
        hero.active();
    }
}