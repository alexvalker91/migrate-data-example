package alex.valker91.migrate_data_example.controller;

import alex.valker91.migrate_data_example.mapper.UserMapper;
import alex.valker91.migrate_data_example.model.UserDomain;
import alex.valker91.migrate_data_example.model.UserRequestDto;
import alex.valker91.migrate_data_example.model.UserResponseDto;
import alex.valker91.migrate_data_example.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto requestDto, UriComponentsBuilder uriComponentsBuilder) {
        UserDomain toCreate = UserMapper.toUserDomain(requestDto);
        toCreate.setId(null);
        UserDomain created = userService.addUser(toCreate);
        UserResponseDto response = UserMapper.toUserResponseDto(created);
        return ResponseEntity.created(uriComponentsBuilder
                .replacePath("/api/v1/user/{userId}")
                .build(Map.of("userId", response.getId()))).body(response);
    }


    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDto> findUser(@PathVariable("userId") long userId) {
        return userService.findById(userId).map(user -> ResponseEntity.ok(UserMapper.toUserResponseDto(user)))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/all")
    public List<UserResponseDto> findAll() {
        return userService.findAll().stream().map(UserMapper::toUserResponseDto).toList();
    }

    @PostMapping("/copy-users")
    public List<Long> copyUsers() {
        return userService.copyUsersToUserCopyRepository();
    }
}

// POST http://localhost:8081/api/v1/user
//     {
//        "id": 1,
//        "name": "my name",
//        "surname": "my surname"
//    }

// GET http://localhost:8081/api/v1/user/1

// GET http://localhost:8081/api/v1/user/all

// POST http://localhost:8081/api/v1/user/copy-users