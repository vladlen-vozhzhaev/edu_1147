import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();

        if(num%2 != 0){
            System.out.println("Число "+num+" нечётное");
        }

        /*System.out.println("Введите логин:");
        String login = scanner.nextLine();
        System.out.println("Введите пароль:");
        String pass = scanner.nextLine();

        if(login.equals("admin") && pass.equals("123456")){
            System.out.println("Доступ разрешен для ADMIN");
        }else if(login.equals("user") && pass.equals("654321")){
            System.out.println("Доступ разрешен для USER");
        }else{
            System.out.println("Доступ запрещен");
        }*/


        /*System.out.println("Введите число: ");
        int num1 = scanner.nextInt();
        System.out.println("Введите число: ");
        int num2 = scanner.nextInt();

        if(num1 > num2){
            System.out.println("Число "+num1+" больше чем число "+num2);
        }else{
            System.out.println("Число "+num1+" меньше, либо равно числу "+num2);
        }*/

        /*float num1 = 17;
        float num2 = 5;
        System.out.println((num1+num2)*3);
        System.out.println(num1-num2);
        System.out.println(num1*num2);
        System.out.println(num1/num2);
        System.out.println(num1%num2);
        System.out.println(num1==num2);
        System.out.println(num1>num2);
        System.out.println(num1>=num2);*/

        /*String name = "Ivan";
        System.out.println("Hello "+name);*/
    }
}
