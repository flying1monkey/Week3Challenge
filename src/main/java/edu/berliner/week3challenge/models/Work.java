package edu.berliner.week3challenge.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Work
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String company;
    private String jobTitle;
    private String startDate;
    private String endDate;
    private String firstDuty;
    private String secondDuty;

    public String getCompany()
    {
        return company;
    }

    public void setCompany(String company)
    {
        this.company = company;
    }

    public String getJobTitle()
    {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle)
    {
        this.jobTitle = jobTitle;
    }

    public String getStartDate()
    {
        return startDate;
    }

    public void setStartDate(String startDate)
    {
        this.startDate = startDate;
    }

    public String getEndDate()
    {
        return endDate;
    }

    public void setEndDate(String endDate)
    {
        this.endDate = endDate;
    }

    public String getFirstDuty()
    {
        return firstDuty;
    }

    public void setFirstDuty(String firstDuty)
    {
        this.firstDuty = firstDuty;
    }

    public String getSecondDuty()
    {
        return secondDuty;
    }

    public void setSecondDuty(String secondDuty)
    {
        this.secondDuty = secondDuty;
    }
}
