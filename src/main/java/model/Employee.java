package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

       private int id;

       private String first_name;

       private String last_name;

       private String gender;

       private int age;

       private int city_id;

       public Employee(String first_name, String last_name, String gender, int age, int city_id) {

       }
}