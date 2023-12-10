//package kz.lkwwr.authservice.services.impl;
//
//
//import kz.lkwwr.authservice.entities.User;
//import kz.lkwwr.authservice.repositories.UserRepository;
//import kz.lkwwr.authservice.services.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class UserServiceImpl implements UserService {
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public void addUser(User user) {
//        userRepository.save(user);
//    }
//
//    @Override
//    public List<User> getUsers() {
//        return userRepository.findAll();
//    }
//
//    @Override
//    public User getUser(Long id) {
//        return userRepository.getReferenceById(id);
//    }
//
//    @Override
//    public void saveUser(User user) {
//        userRepository.save(user);
//    }
//
//    @Override
//    public void deleteUser(User user) {
//        userRepository.delete(user);
//    }
//
//    @Override
//    public UserDTO convertToDTO(User user) {
//        UserDTO userDTO = new UserDTO();
//
//        userDTO.setId(user.getId());
//        userDTO.setName(user.getName());
//        userDTO.setUsername(user.getUsername());
//        userDTO.setPassword(user.getPassword());
//        userDTO.setRoles(user.getRoles());
//
//        return userDTO;
//    }
//}
