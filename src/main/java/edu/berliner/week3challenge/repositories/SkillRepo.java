package edu.berliner.week3challenge.repositories;

import edu.berliner.week3challenge.models.Skills;
import org.springframework.data.repository.CrudRepository;

public interface SkillRepo extends CrudRepository<Skills,Long>
{
}
