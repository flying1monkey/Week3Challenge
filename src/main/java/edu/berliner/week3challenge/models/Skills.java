package edu.berliner.week3challenge.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Skills
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String skill;
    private String skillLevel;

    public String getSkill()
    {
        return skill;
    }

    public void setSkill(String skill)
    {
        this.skill = skill;
    }

    public String getSkillLevel()
    {
        return skillLevel;
    }

    public void setSkillLevel(String skillLevel)
    {
        this.skillLevel = skillLevel;
    }
}
