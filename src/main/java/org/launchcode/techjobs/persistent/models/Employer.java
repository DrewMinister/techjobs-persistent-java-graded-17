package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Employer extends AbstractEntity {

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "employer_id")
    private final List<Job> jobs = new ArrayList<>();

    @NotBlank
    @Size(min = 5, max = 50, message = "The location field must be 5-50 characters long")
    private String location;

    public String getLocation() {
        return location;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Employer() {
    }
}
