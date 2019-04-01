package com.example.VolunteerEventLog.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Volunteer {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 1, message = "First Name can not be blank")
    private String firstname;

    @NotNull
    @Size(min = 1, message = "Last Name can not be blank")
    private String lastname;

    @ManyToMany
    private List<Event> events;

    public Volunteer(){}

    public Volunteer(String firstname, String lastname)
    {
        this.firstname = firstname;
        this.lastname = lastname;
    }

   public void addItem (Event item)
    {
        events.add(item);
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
