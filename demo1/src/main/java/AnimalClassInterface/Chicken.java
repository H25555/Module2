package AnimalClassInterface;

public class Chicken extends Animal implements Edible{
    @Override
    public String makeSound(){
        return "Bock bock Ò Ó O";
    }
    @Override
    public String howtoEat(){
        return "Fried";
    }
}
