package edu.berliner.week3challenge.models;


import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String email;

    private ArrayList<Skills> skills;
    private ArrayList<Work> work;
    private ArrayList<Education> education;



    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public ArrayList<Skills> getSkills()
    {
        return skills;
    }

    public void setSkills(ArrayList<Skills> skills)
    {
        this.skills = skills;
    }

    public ArrayList<Work> getWork()
    {
        return work;
    }

    public void setWork(ArrayList<Work> work)
    {
        this.work = work;
    }

    public ArrayList<Education> getEducation()
    {
        return education;
    }

    public void setEducation(ArrayList<Education> education)
    {
        this.education = education;
    }


}
