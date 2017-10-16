package Application.repositories;


import Application.domain.Parent;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Kino on 2017-09-17.
 */
public interface ParentRepository extends CrudRepository<Parent, Long>
{
}
