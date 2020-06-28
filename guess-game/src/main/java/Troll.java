public class Troll extends Player{

    public Troll(String name) {
        super(name);
    }

    @Override
    public void sayVictory() {
        System.out.println("Агггррр");
    }

    @Override
    public void sayDefeat() {
        System.out.println("Моя крушить!!");
    }


}
