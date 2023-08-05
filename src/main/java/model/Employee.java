package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee")
public class Employee {

       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       @Column(name = "id")
       private int id;

       @Column(name="first_name")
       private String first_name;

       @Column(name = "last_name")
       private String last_name;

       @Column(name = "gender")
       private String gender;

       @Column(name = "age")
       private Integer age;

       @Column(name = "city_id")
       private Integer city_id;

       public Employee(String евгений, String лебедев, String м, int i, int i1) {
       }
}