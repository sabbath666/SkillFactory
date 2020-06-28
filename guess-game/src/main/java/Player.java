public abstract class Player {
    public String name;

    public Player(String name) {
        this.name = name;
    }

    public void sayName(){
        System.out.print(name +": ");
    }

    public abstract void sayVictory();

    public abstract void sayDefeat();

}
