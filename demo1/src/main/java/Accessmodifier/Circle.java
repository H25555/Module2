package Accessmodifier;

public class Circle {
    private double radius;
    private String color = "Red";

    public Circle(){}
    public Circle(double radius){
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
    public double getArea(){
        return this.radius*this.radius*Math.PI;
    }

    public static void main(String[] args) {
        Circle c1 = new Circle(4);
        System.out.println("Area: " + c1.getArea());
    }

}
