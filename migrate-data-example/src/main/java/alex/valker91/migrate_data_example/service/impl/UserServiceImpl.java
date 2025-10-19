package alex.valker91.migrate_data_example.service.impl;

import alex.valker91.migrate_data_example.mapper.UserMapper;
import alex.valker91.migrate_data_example.model.UserDomain;
import alex.valker91.migrate_data_example.model.UserEntity;
import alex.valker91.migrate_data_example.repository.UserRepository;
import alex.valker91.migrate_data_example.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDomain addUser(UserDomain userDomain) {
        UserEntity userEntity = UserMapper.toUserEntity(userDomain);
        userEntity = userRepository.save(userEntity);
        return UserMapper.toUserDomain(userEntity);
    }

    @Override
    public Optional<UserDomain> findById(Long id) {
        return userRepository.findById(id).map(UserMapper::toUserDomain);
    }
}
