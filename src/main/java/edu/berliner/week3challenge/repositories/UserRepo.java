package edu.berliner.week3challenge.repositories;

import edu.berliner.week3challenge.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User,Long>
{
}
