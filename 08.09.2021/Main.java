import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[10];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = scanner.nextInt();
        }


        /*String str = "Hello world";
        String result = str.substring(6, 11);
        System.out.println(result);*/

        /*for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println("Переменная i="+i+"; переменная j="+j);
            }
            System.out.println("-------------");
        }*/

        /*String str = "КЛМНП";
        // Вывести на экран все возможные 4х буквенные сочетания в алфавитном порядке
        // 1) КККК
        // 2) КККЛ
        // 3) КККМ
        // 4) КККН
        // 5) КККП
        // 6) ККЛК
        // 7) ККЛЛ
        // ...
        // Узнать какой порядковый номер у слова ЛМПК
        int count = 0;
        int searchIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < str.length(); j++) {
                for (int k = 0; k < str.length(); k++) {
                    for (int l = 0; l < str.length(); l++) {
                        String word = str.substring(i, i+1)+
                                str.substring(j, j+1)+
                                str.substring(k, k+1)+
                                str.substring(l, l+1);
                        System.out.println((++count)+") "+word);
                        if(word.equals("ЛМПК")){
                            searchIndex = count;
                        }
                    }
                }
            }
        }
        System.out.println("Последовательность ЛМПК находится на позиции "+searchIndex);*/



        /*int count = 0;
        int searchIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < str.length(); j++) {
                for (int k = 0; k < str.length(); k++) {
                    for (int l = 0; l < str.length(); l++) {
                        String word = String.valueOf(str.charAt(i))+
                                String.valueOf(str.charAt(j))+
                                String.valueOf(str.charAt(k))+
                                String.valueOf(str.charAt(l));
                        System.out.println((++count)+") "+word);
                        if(word.equals("ЛМПК")){
                            searchIndex = count;
                        }
                    }
                }
            }
        }
        System.out.println("Последовательность ЛМПК находится на позиции "+searchIndex);*/

        // Нужно максимальное нечетное число
        /*int[] nums = {-340,-45,-23,-75,-234,-466,-245,-174};
        int max = (int) (-1/0.0);
        System.out.println(max);
        for (int i = 0; i < nums.length; i++) {
            if(max<nums[i] && nums[i]%2!=0){
                max = nums[i];
            }
        }
        System.out.println(max);*/



        /*
        int[] nums = {4,4,5,5,5,5,5};
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum=sum+nums[i];
        }
        System.out.println((double) sum/nums.length);
        double summ = 10000;
        int p = 10;
        System.out.println("Сумма вклада "+summ+", под "+p+"% годовых");
        for (int i=0; i<10; i++){
            summ = summ + (summ * p/100);
            System.out.println(summ);
        }*/


        /*
        for(int i=0; i<3; i=i+1){
            System.out.println("Привет");
        }
        int a = 6;
        do{
            a = a + 1;
            System.out.println(a);
        }while (a<6);*/

        /*while (a<6){
            a = a + 1;
            System.out.println(a);
        }*/

    }
}
