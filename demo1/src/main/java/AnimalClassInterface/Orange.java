package AnimalClassInterface;

public class Orange extends Fruit implements Edible{
    @Override
    public String howtoEat() {
        return "Bóc vỏ và sử dụng";
    }
}
