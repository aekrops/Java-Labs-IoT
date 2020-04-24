package ua.lviv.iot.lawFirm.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "\"firms\"")
public class LawyerFirm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Integer yearOfFoundation;
    private Integer amountOfLawyers;

    // one to many
    @OneToMany(mappedBy = "lawyerFirm", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("lawyerFirm")
    private Set<Lawyer> lawyers;

    public Integer getId() {
        return id;
    }

    public LawyerFirm() {
        
    }

    public Set<Lawyer> getLawyers() {
        return lawyers;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getYearOfFoundation() {
        return yearOfFoundation;
    }

    public void setYearOfFoundation(Integer yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
    }

    public Integer getAmountOfLawyers() {
        return amountOfLawyers;
    }

    public void setAmountOfLawyers(Integer amountOfLawyers) {
        this.amountOfLawyers = amountOfLawyers;
    }
}
