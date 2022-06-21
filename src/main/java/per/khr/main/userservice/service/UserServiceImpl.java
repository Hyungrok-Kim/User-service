package per.khr.main.userservice.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.internal.bytebuddy.matcher.StringMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.khr.main.userservice.dao.UserDao;
import per.khr.main.userservice.dao.UserEntity;
import per.khr.main.userservice.dto.UserDto;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * userDto -> userEntity 객체로 변환 후 dao에 insert
     *
     * @param userDto : userEntity 객체로 변환 후 dao로 전달할 userDto
     * @return
     */
    @Override
    public UserDto createUser(UserDto userDto) {
        // UUID로 userId UNIQUE하게 세팅
        userDto.setUserId(UUID.randomUUID().toString());

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserEntity userEntity = mapper.map(userDto, UserEntity.class);

        return null;
    }
}
