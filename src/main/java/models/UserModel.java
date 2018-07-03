package models;


public class UserModel {

    
    private int ID;
    private String name;
    private String surname ;
    private int age;
    
    
    public UserModel(String name, String surname, int age) {
        name = this.name;
        surname = this.surname;
        age = this.age;
    }

    public UserModel() {
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    /*   @Override
    public String toString() {
    return "User{" +
    "id='" + ID + '\'' +
    ", name='" + name + '\'' +
    ", surname=" + surname +
    ", age=" + age +
    '}';
    }*/
}
