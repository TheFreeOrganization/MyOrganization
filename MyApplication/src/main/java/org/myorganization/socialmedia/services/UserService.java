package org.myorganization.socialmedia.services;

import org.myorganization.socialmedia.dao.requests.UserAddRequest;
import org.myorganization.socialmedia.dao.responses.user.UserFollowingResponse;
import org.myorganization.socialmedia.dao.responses.user.UserResponse;
import org.myorganization.socialmedia.data.Follow;
import org.myorganization.socialmedia.data.User;
import org.myorganization.socialmedia.mappers.UserMapper;
import org.myorganization.socialmedia.repositories.FollowRepository;
import org.myorganization.socialmedia.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceI {
   private final UserMapper userMapper;
   private final UserRepository userRepository;
   private final FollowRepository followRepository;

    public UserService(UserMapper userMapper, UserRepository userRepository, FollowRepository followRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
        this.followRepository = followRepository;
    }

    public List<UserResponse> getAll(){

        return userMapper.usersToResponses(userRepository.findAll());
    }
    public UserResponse getResponseById(int id){
        User user = userRepository.findById(id).orElse(null);
        return userMapper.userToResponse(user);
    }

    public UserResponse getByEmail(String email){
        User user = userRepository.findByEmail(email);
        return userMapper.userToResponse(user);
    }

    public List<UserFollowingResponse> getUserFollowing(int userId){
        return userMapper.followsToFollowingResponses(followRepository.findAllByUser_Id(userId));
    }

    public boolean isFollowing(int userId,int followingId){
       Optional<Follow> follow = followRepository.findByUser_IdAndFollowing_Id(userId,followingId);
       return follow.isPresent();
    }

    public User getById(int id){
        return userRepository.findById(id).get();
    }
    public User add(UserAddRequest userAddRequest){
        User user = userMapper.requestToUser(userAddRequest);
        userRepository.save(user);
        return user ;
    }

    public void delete(int id){
        userRepository.deleteById(id);
    }
}
