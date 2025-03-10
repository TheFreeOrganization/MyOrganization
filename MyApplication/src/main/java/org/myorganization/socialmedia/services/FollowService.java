package org.myorganization.socialmedia.services;

import org.myorganization.socialmedia.dao.requests.FollowRequest;
import org.myorganization.socialmedia.data.Follow;
import org.myorganization.socialmedia.mappers.FollowMapper;
import org.myorganization.socialmedia.repositories.FollowRepository;
import org.springframework.stereotype.Service;


@Service
public class FollowService {
    private final FollowRepository followRepository;
    private final FollowMapper followMapper;
    private final UserService userService;

    public FollowService(FollowRepository followRepository, FollowMapper followMapper, UserService userService) {
        this.followRepository = followRepository;
        this.followMapper = followMapper;
        this.userService = userService;
    }

    public void add(FollowRequest followAddRequest){
        if (userService.isFollowing(followAddRequest.getUserId(), followAddRequest.getFollowingId())){
            return;
        }
        followRepository.save(followMapper.addRequestToFollow(followAddRequest));
    }

    public  void delete(FollowRequest followRequest){
      Follow follow
                = followRepository.findByUser_IdAndFollowing_Id(followRequest.getUserId(), followRequest.getFollowingId()).orElse(null);
        followRepository.delete(follow);
    }


}
