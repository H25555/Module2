package AnimalClassInterface;

public class Apple extends Fruit implements Edible{
    @Override
    public String howtoEat() {
        return "có thể bóc vỏ hoặc không dể sử dụng";
    }
}
