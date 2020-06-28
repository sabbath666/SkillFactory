public class Robot extends Player{

    public Robot(String name) {
        super(name);
    }

    @Override
    public void sayVictory() {
        System.out.println("бип бип");
    }

    @Override
    public void sayDefeat() {
        System.out.println("пыщ пыщ");
    }
}
