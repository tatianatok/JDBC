package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(of = {"id"})
@Entity
@Table(name = "employee")
public class Employee {

       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       @Column(name = "id")
       private Integer id;

       @Column(name = "first_name")
       private String first_name;

       @Column(name = "last_name")
       private String last_name;

       @Column(name = "gender")
       private String gender;

       @Column(name = "age")
       private int age;

       @ManyToOne
       private City city;

       public Employee(String first_name, String last_name, String gender, int age) {
              this.first_name = first_name;
              this.last_name = last_name;
              this.gender = gender;
              this.age = age;

       }

}