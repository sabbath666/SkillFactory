public class Human extends Player {

    public Human(String name) {
        super(name);
    }

    @Override
    public void sayVictory() {
        System.out.println("Еееееееее");
    }

    @Override
    public void sayDefeat() {
        System.out.println("Игра - говно");
    }
}
