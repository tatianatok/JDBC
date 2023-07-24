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
       private int age;

       @Column(name = "city_id")
       private int city_id;

}