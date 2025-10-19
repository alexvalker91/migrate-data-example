package alex.valker91.migrate_data_example.mapper;

import alex.valker91.migrate_data_example.model.UserDomain;
import alex.valker91.migrate_data_example.model.UserEntity;
import alex.valker91.migrate_data_example.model.UserRequestDto;
import alex.valker91.migrate_data_example.model.UserResponseDto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UserMapper {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE; // example "2025-09-14"

    private UserMapper() {}

    public static UserDomain toUserDomain(UserRequestDto dto) {
        UserDomain user = new UserDomain();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setSurname(dto.getSurname());
        if (dto.getBirthday() != null) {
            user.setBirthday(LocalDate.parse(dto.getBirthday(), DATE_TIME_FORMATTER));
        }
        return user;
    }

    public static UserResponseDto toUserResponseDto(UserDomain user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setSurname(user.getSurname());
        if (user.getBirthday() != null) {
            dto.setBirthday(user.getBirthday().format(DATE_TIME_FORMATTER));
        } else {
            dto.setBirthday(null);
        }
        return dto;
    }

    public static UserEntity toUserEntity(UserDomain userDomain) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userDomain.getName());
        userEntity.setSurname(userDomain.getSurname());
        userEntity.setBirthday(userDomain.getBirthday());
        return userEntity;
    }

    public static UserDomain toUserDomain(UserEntity userEntity) {
        UserDomain userDomain = new UserDomain();
        userDomain.setId(userEntity.getId());
        userDomain.setName(userEntity.getName());
        userDomain.setSurname(userEntity.getSurname());
        userDomain.setBirthday(userEntity.getBirthday());
        return userDomain;
    }
}
