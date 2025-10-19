package alex.valker91.migrate_data_example.service;

import alex.valker91.migrate_data_example.model.UserDomain;

import java.util.Optional;

public interface UserService {

    UserDomain addUser(UserDomain userDomain);

    Optional<UserDomain> findById(Long id);
}
