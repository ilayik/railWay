package com.example.sweater.modul;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "passenger")
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    private String name;
    private String surname;
    private Date birthdate;

    public Passenger() {
    }

    public Passenger(String passengerName, String passengerSurName, Date passengerDataBirth) {
        this.name = passengerName;
        this.surname = passengerSurName;
        this.birthdate = passengerDataBirth;
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

    public void setSurname(String passengerSurName) {
        this.surname = passengerSurName;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date passengerDataBirth) {
        this.birthdate = passengerDataBirth;
    }
}
