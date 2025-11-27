package services;

import entities.User;
import entities.request.UserRequest;
import entities.response.UserResponse;
import org.springframework.stereotype.Service;
import repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Object createUser(UserRequest request){
        User userRequest = new User(request);
        userRepository.save(userRequest);

        return new UserResponse(userRequest);
    }

    public List<?>
}
