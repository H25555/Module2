package BaiTapHuongDoiTuong;

public class Fan {
    private int SLOW = 1;
    private int MEDIUM = 2;
    private int FAST = 3;
    private int speed = SLOW;
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";
    public void setSpeed(int speed){
        if (speed > 0 && speed < 4){
            this.speed = speed;
        }
    }
    public int getSpeed(){
        return speed;
    }
    public void setOn(boolean on){
        this.on = on;
    }
    public boolean isOn() {
        return on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius > 0){
            this.radius = radius;
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        if (isOn()) {
            return "fan is: on, speed = " + getSpeed() + ", color: " + getColor() + ", radius: " +getRadius();
        }
        else {
            return "fan is: on, color: " + getColor() + ", radius: " +getRadius();
        }
    }

    public static void main(String[] args) {
        Fan Fan1 = new Fan();
        Fan Fan2 = new Fan();
        Fan1.setSpeed(3);
        Fan1.setRadius(10);
        Fan1.setColor("yellow");
        Fan1.setOn(true);
        Fan2.setSpeed(2);
        System.out.println(Fan1.toString());
        System.out.println(Fan2.toString());
    }
}
