package edu.berliner.week3challenge.repositories;

import edu.berliner.week3challenge.models.Work;
import org.springframework.data.repository.CrudRepository;

public interface WorkRepo extends CrudRepository<Work,Long>
{
}
