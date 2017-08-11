package edu.berliner.week3challenge.repositories;

import edu.berliner.week3challenge.models.Education;
import org.springframework.data.repository.CrudRepository;

public interface EdRepo extends CrudRepository<Education,Long>
{
}
