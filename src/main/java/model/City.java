package model;

import lombok.*;

import javax.persistence.*;

import java.util.List;

@Data
@Entity
@Table(name = "city")
public class City {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "city_id")
   private int cityId;

   @Column(name = "city_name")
   private String city_name;

   @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
   private List<Employee> employees;

    public City(String city_name) {
        this.city_name = city_name;
    }

    public City(){

    }

}

