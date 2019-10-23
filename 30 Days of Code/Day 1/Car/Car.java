import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Car{
    //Primitive DataTypes
    int jMaxSpeed = 100;
    int jMinSpeed = 0;
    double jWeight = 4070;
    boolean isCarOn = false;
    char cCondition = 'A';
    String sName = "Gladiator";
    //Reference Type
    int[] arr;
    Queue objQueue;
    LinkedList objLinkedList;
    Stack objStack;

    public void printVariables(){
        System.out.println("Car Name : " + sName);
        System.out.println("This is car's Max Speed : " + jMaxSpeed);
        System.out.println("This is car's Min Speed : " + jMinSpeed);
        System.out.println("This is car's weight : " + jWeight);
        System.out.println("This is if car's on : " + isCarOn);
        System.out.println("This is character on car : " + cCondition);
    }
    public void wreckCar(){
        cCondition = 'B';
    }
    public static void main(String[] args) {
        Car objFamilyCar = new Car();

        System.out.println("Family's Car : ");
        objFamilyCar.printVariables();

        Car objAmitCar = objFamilyCar;
        
        objFamilyCar.wreckCar();
        System.out.println("Amit's Car : ");
        objAmitCar.printVariables();
    }
}