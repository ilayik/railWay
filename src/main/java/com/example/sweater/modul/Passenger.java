package com.example.sweater.modul;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "passenger", cascade = CascadeType.ALL)
    private List<Ticket> tickets;


    public Passenger() {
    }

    public Passenger(String name, String surname, Date birthdate) {
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        if(tickets != null){
            for (Ticket ticket:tickets) {
                ticket.setPassenger(this);
            }
        }
        this.tickets = tickets;
    }

}
