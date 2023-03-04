package data;

import utils.ConfigReader;

public class temp {
    public static void main(String[] args) {
//        Employee employee1 = new Employee("john",1,"IT");
//        System.out.println(employee1.toString());
//        System.out.println(employee1.getDepartment());
//        System.out.println(employee1.getName());
//        employee1.setName("adams");
//        System.out.println(employee1.getName());
//        System.out.println(employee1.toString());


        String reader = ConfigReader.readProperty("configuration.properties","url");
        System.out.println(reader);
    }
}
