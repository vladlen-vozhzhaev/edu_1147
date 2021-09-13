/* В нашей вселенной, возраст человека не может превышать 120лет
*  У персонажа есть здоровье, оно не может быть больше 100ед.
*  */

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Ольга", "Иванова", 70, null,null);
        Person person2 = new Person("Николай", "Петров", 68, null, null);
        Person person3 = new Person("Иван", "Иванов", 38, person1, null);
        Person person4 = new Person("Ирина", "Иванова", 35, null, person2);
        Person person5 = new Person("Василий", "Иванов", 12, person4, person3);

        person5.info();
    }
}

class Person{
    private String name;
    private String lastname;
    private int age;
    private int hp;
    private Person mother;
    private Person father;
    Person(String name, String lastname, int age, Person mother, Person father){
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.hp = 100;
        this.mother = mother;
        this.father = father;
    }

    void info(){
        String info =   "Меня зовут "+this.name+"\n";

        if(this.mother != null){
            info += "Мою маму зовут "+this.mother.name+"\n";
            if(this.mother.father != null){
                info += "Моего дедушку по маминой линии зовут "+this.mother.father.name;
            }
        }
        if(this.father != null){
            info += "Моего отца зовут "+this.father.name+"\n";
            if(this.father.mother != null){
                info += "Мою бабушку по папиной линии зовут "+this.father.mother.name+"\n";
            }
        }

        System.out.println(info);
    }

    public Person getMother() {
        return mother;
    }

    public Person getFather() {
        return father;
    }

    String getName(){
        return this.name;
    }
    String getLastname(){
        return this.lastname;
    }
    int getAge(){
        return this.age;
    }
    int getHp(){
        return this.hp;
    }
    void setAge(int age){
        if(this.age+age>120) this.age = 120;
        else this.age = this.age+age;
    }
    void setHp(int hp){
        if(this.hp+hp>100) this.hp = 100;
        else this.hp = this.hp+hp;
    }
    void sayHi(String name){
        System.out.println("Привет "+name+", меня зовут "+this.name);
    }
}
