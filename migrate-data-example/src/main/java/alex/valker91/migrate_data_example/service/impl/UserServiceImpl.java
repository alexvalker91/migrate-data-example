package alex.valker91.migrate_data_example.service.impl;

import alex.valker91.migrate_data_example.mapper.UserMapper;
import alex.valker91.migrate_data_example.model.UserCopyEntity;
import alex.valker91.migrate_data_example.model.UserDomain;
import alex.valker91.migrate_data_example.model.UserEntity;
import alex.valker91.migrate_data_example.repository.UserCopyRepository;
import alex.valker91.migrate_data_example.repository.UserRepository;
import alex.valker91.migrate_data_example.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserCopyRepository userCopyRepository;

    public UserServiceImpl(UserRepository userRepository, UserCopyRepository userCopyRepository) {
        this.userRepository = userRepository;
        this.userCopyRepository = userCopyRepository;
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

    @Override
    public List<UserDomain> findAll() {
        return userRepository.findAll().stream().map(UserMapper::toUserDomain).toList();
    }

    @Transactional
    @Override
    public List<Long> copyUsersToUserCopyRepository() {
        List<UserEntity> users = userRepository.findAll();

        List<UserCopyEntity> usersCopy = users.stream().map(user -> {
            UserCopyEntity copy = new UserCopyEntity();
            copy.setName(user.getName());
            copy.setSurname(user.getSurname());
            copy.setBirthday(user.getBirthday());
            return copy;
        }).toList();

        List<UserCopyEntity> savedUsers = userCopyRepository.saveAll(usersCopy);
        return savedUsers.stream()
                .map(UserCopyEntity::getId)
                .collect(Collectors.toList());
    }
 }
