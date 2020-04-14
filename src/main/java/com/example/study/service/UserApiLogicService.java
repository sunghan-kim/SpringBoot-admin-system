package com.example.study.service;

import com.example.study.model.entity.User;
import com.example.study.model.enumclass.UserStatus;
import com.example.study.model.network.Header;
import com.example.study.model.network.request.UserApiRequest;
import com.example.study.model.network.response.UserApiResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserApiLogicService extends BaseService<UserApiRequest, UserApiResponse, User> {

    @Override
    public Header<UserApiResponse> create(Header<UserApiRequest> request) {

        // 1. get request data
        UserApiRequest  userApiRequest = request.getData();

        // 2. create user
        User user = User.builder()
                .account(userApiRequest.getAccount())
                .password(userApiRequest.getPassword())
                .status(UserStatus.REGISTERED) // Enum 활용
                .phoneNumber(userApiRequest.getPhoneNumber())
                .email(userApiRequest.getEmail())
                .registeredAt(LocalDateTime.now())
                .build();

        User newUser = baseRepository.save(user);

        // 3. 생성된 데이터를 기준으로 UserApiResponse return
        return response(newUser);
    }

    @Override
    public Header<UserApiResponse> read(Long id) { // 람다식 사용
        return baseRepository.findById(id)
                .map(user -> response(user))
                .orElseGet(
                        () -> Header.ERROR("데이터 없음")
                );
    }

    @Override
    public Header<UserApiResponse> update(Header<UserApiRequest> request) {
        // 1. data
        UserApiRequest userApiRequest = request.getData();

        // 2. id -> user 테이터 찾기
        Optional<User> optional = baseRepository.findById(userApiRequest.getId());

        return optional.map(user -> {
            user.setAccount(userApiRequest.getAccount())
                    .setPassword(userApiRequest.getPassword())
                    .setStatus(userApiRequest.getStatus())
                    .setPhoneNumber(userApiRequest.getPhoneNumber())
                    .setEmail(userApiRequest.getEmail())
                    .setRegisteredAt(userApiRequest.getRegisteredAt())
                    .setUnregisteredAt(userApiRequest.getUnregisteredAt());
            return user;
        })
                .map(user -> baseRepository.save(user)) // // 3. update
                .map(updateUser -> response(updateUser)) // 4. userApiResponse return
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    @Override
    public Header delete(Long id) {
        // 1. id -> repository -> user
        Optional<User> optional = baseRepository.findById(id);

        return optional.map(user -> {
            // 2. repository -> delete
            baseRepository.delete(user);

            // 3. response return
            return Header.OK();
        }).orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    private Header<UserApiResponse> response(User user) {
        // user -> userApiResponse
        UserApiResponse userApiResponse = UserApiResponse.builder()
                .id(user.getId())
                .account(user.getAccount())
                .password(user.getPassword()) // TODO : 암호화, 길이
                .status(user.getStatus())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .registeredAt(user.getRegisteredAt())
                .unregisteredAt(user.getUnregisteredAt())
                .build();

        // Header + data return
        return Header.OK(userApiResponse);
    }

}
