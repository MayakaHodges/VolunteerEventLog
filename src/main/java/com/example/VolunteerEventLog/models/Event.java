package com.example.VolunteerEventLog.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Event {

    private static final String dateFormatPattern =  "yyyy-MM-dd";
    private static final SimpleDateFormat formatDate
            = new SimpleDateFormat(dateFormatPattern);

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 3, max = 15, message = "Must be between 3 to 15 characters")
    private String title;

    @NotNull(message = "Please enter a valid date")
    @DateTimeFormat(pattern = dateFormatPattern)
    private Date eventDate;

    @NotNull
    @Size(min = 3, max = 15, message = "location must not be empty")
    private String location;

    @NotNull
    @Size(min=1, message = "Description must not be empty")
    private String description;

    public Event() { }

    public Event(String title, Date eventDate, String location, String description)
    {
        if(eventDate == null)
            throw new IllegalArgumentException(" Start date may not be null");

        this.title = title;
        this.eventDate = eventDate;
        this.location = location;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getFormattedEventDate() {
        return Event.formatDate.format(eventDate);
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
