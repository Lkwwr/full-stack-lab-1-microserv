package kz.lkwwr.authservice.services;

import jakarta.transaction.Transactional;
import kz.lkwwr.authservice.entities.User;
import kz.lkwwr.authservice.repositories.RoleRepository;
import kz.lkwwr.authservice.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    public User findByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username);
        if (user == null) throw new UsernameNotFoundException(String.format("Пользователь '%s' не найден", username));
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName())).toList()
        );
    }

    public void createNewUser(User user) {
        user.setRoles(List.of(roleRepository.getRoleByName("ROLE_USER")));
        userRepository.save(user);
    }
}
