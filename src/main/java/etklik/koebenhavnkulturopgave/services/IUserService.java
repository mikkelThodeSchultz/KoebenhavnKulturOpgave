package etklik.koebenhavnkulturopgave.services;

import etklik.koebenhavnkulturopgave.model.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserService extends ICrudService<User,Long> {
}
