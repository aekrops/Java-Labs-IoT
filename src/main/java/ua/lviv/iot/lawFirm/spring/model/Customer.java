package ua.lviv.iot.lawFirm.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "\"customers\"")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Integer age;

    // many to many
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Lawyer_Customer", joinColumns = {
            @JoinColumn(name = "customer_id", nullable = false) }, 
    inverseJoinColumns = {
                    @JoinColumn(name = "lawyer_id", nullable = false) })
    @JsonIgnoreProperties("customers")
    private Set<Lawyer> lawyers;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Customer() {
      
    }

    public Set<Lawyer> getLawyers() {
        return lawyers;
    }

    public void setLawyers(Set<Lawyer> lawyers) {
        this.lawyers = lawyers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
