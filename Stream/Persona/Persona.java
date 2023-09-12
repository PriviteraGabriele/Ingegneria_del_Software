package Ingegneria_del_Software.Stream.Persona;

public class Persona {
    String name;
    int age; 
    String role;

    public Persona(String name, int age, String role) {
        this.name = name;
        this.age = age;
        this.role = role;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public String getRole(){
        return role;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setRole(String role){
        this.role = role;
    }
}
