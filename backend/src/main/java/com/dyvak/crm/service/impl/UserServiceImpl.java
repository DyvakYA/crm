package com.dyvak.crm.service.impl;

import com.dyvak.crm.domain.User;
import com.dyvak.crm.exception.UserNotFoundException;
import com.dyvak.crm.repository.UserRepository;
import com.dyvak.crm.service.UserService;
import com.dyvak.crm.service.notification.Messenger;
import com.dyvak.crm.service.notification.MessengerFactory;
import com.dyvak.crm.service.notification.NotificationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private MessengerFactory messengerFactory;

    private UserRepository userRepository;

    private NotificationService notificationService;

    @Transactional(readOnly = true)
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Transactional(readOnly = true)
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Transactional
    public void createUser(User user) {
        userRepository.save(user);
        Messenger email = messengerFactory.getMessenger("email");
        Messenger sms = messengerFactory.getMessenger("sms");
        notificationService.setMessenger(email);
        notificationService.setMessenger(sms);
        notificationService.notify("me", "new object created", "hello world");
    }

    public User findById(long id) {
        return Optional.ofNullable(userRepository
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"))).get();
    }
}

