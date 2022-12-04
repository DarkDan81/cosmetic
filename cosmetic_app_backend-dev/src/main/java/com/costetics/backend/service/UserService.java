package com.costetics.backend.service;

import com.costetics.backend.classes.User;
import com.costetics.backend.classes.UserSummary;
import com.costetics.backend.repository.RoleRepository;
import com.costetics.backend.repository.UserRepository;
import com.costetics.backend.utils.OtherUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUser(Long id) {
        if (id == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        Optional<User> userOptional = userRepository.findUserById(id);
        if (userOptional.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        return userOptional;
    }

    @Transactional
    public User registerUser(User user) {
        Optional<User> userOptional = userRepository.findUserByMail(user.getMail());
        if (userOptional.isPresent())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User with this email already exist");
        user.setTimeCreation(Timestamp.from(Instant.now()));
        user.setRoleId(roleRepository.findRoleByName("USER").orElseThrow(
                () -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Role USER not found. Contact to support.")).getId());
        userRepository.save(user);
        return user;
    }

    public void deleteUser(Long userId) {
        if (!userRepository.existsById(userId))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with id " + userId + " does not exist");
        userRepository.deleteById(userId);
    }

    @Transactional
    public void updateUser(Long id, UserSummary providedUser) {
        var user = userRepository.findUserById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "User with id " + id + " does not exist"));
        var tmp = userRepository.findUserByMail(providedUser.getMail());
        if (tmp.isEmpty() || Objects.equals(tmp.get().getId(), id))
            user.setMail(providedUser.getMail());
        user.setFirstName(providedUser.getFirstName());
        user.setLastName(providedUser.getLastName());
        user.setCity(providedUser.getCity());
        user.setBirthday(providedUser.getBirthday());
    }

    public void changeUserPassword(Long userId, String oldPassword, String newPassword) {
        var user = userRepository.findUserById(userId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User with id " + userId + " does not exist"));
        if (!Objects.equals(user.getPassword(), oldPassword))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Wrong old password");
        user.setPassword(newPassword);
    }

    public String resetUserPassword(Long userId) {
        var user = userRepository.findUserById(userId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User with id " + userId + " does not exist"));
        var newPassword = OtherUtil.generatePwd(15);
        user.setPassword(newPassword);
        return newPassword;
    }

    //TODO: Связать с контроллером и как-то идентифицировать админа
    public void changeUserRole(Long userId, Long roleId, Long adminId) {
        var admin = userRepository.findUserById(adminId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Admin with id " + adminId + " does not exist"));
        if (admin.getRoleId() >= roleId)
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Your role is lower or equals to the requested");
        var user = userRepository.findUserById(userId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User with id " + userId + " does not exist"));
        if (user.getRoleId() >= admin.getRoleId())
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You cant edit this user");
        user.setRoleId(roleId);
    }
}
