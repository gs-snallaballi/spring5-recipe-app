package guru.springframework.repositories;

import guru.springframework.domain.Notes;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Saiteja on 7/18/18
 */
public interface NotesRepository extends CrudRepository<Notes,Long> {
}
