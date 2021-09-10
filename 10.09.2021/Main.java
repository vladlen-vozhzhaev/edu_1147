import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[]komb={"Мама","Мыла","Раму"};
        for(int i=0;i< komb.length;i++){
            for(int j=0;j< komb.length;j++){
                for(int l=0;l< komb.length;l++){
                    if(i!=j && j!=l && i!=l)
                        System.out.println(komb[i]+komb[j]+komb[l]);
                }
            }

        }

        /*int[] nums = {4,6,3,7,7,9,2};
        for (int i = 0; i < nums.length; i++) {
            if(i == nums.length-1){
                System.out.println("Нет");
            } else if(nums[i] == nums[i+1]){
                System.out.println("Да");
                break;
            }
        }*/

        /*while(true){
            System.out.println("Введите логин:");
            String login = scanner.nextLine();
            System.out.println("Введите пароль:");
            String pass = scanner.nextLine();
            *//*if(auth(login, pass))
                System.out.println("Вы успешно вошли в систему");
            else
                System.out.println("В доступе отказано");*//*

            // условие?что делать если true:что делать если false
            System.out.println(auth(login, pass)?"Вы успешно вошли в систему":"В доступе отказано");
        }*/
    }


    // Сколько символов * будет выведено на экран при вызове F(11)
    public static void F(int n){
        if(n>0)
            G(n-1);
    }
    public static void G(int n){
        System.out.print("*");
        if(n>1)
            F(n-3);
    }



    public static void getChange(int num){ // 39 (10 10 10 5 2 2)
        if(num>=10){
            System.out.println(10);
            getChange(num-10);
        }else if(num>=5){
            System.out.println(5);
            getChange(num-5);
        }else if(num>=2){
            System.out.println(2);
            getChange(num-2);
        }else if(num>=1){
            System.out.println(1);
            getChange(num-1);
        }else{
            System.out.println("Вся сдача выдана");
        }
    }

    public static boolean auth(String login, String pass){
        if(login.equals("admin") && pass.equals("123456"))
            return true;
        else
            return false;
    }

    public static int min(int a, int b){
        if(a<b) return a;
        else return b;
    }

    public static int f(int x){
        return x*x;
    }


    public static void sayHi(){
        System.out.println("Hello world");
    }
}
