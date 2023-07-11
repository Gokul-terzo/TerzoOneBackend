//package com.terzoOne.terzoOneBackend.security;
//
//import com.terzoOne.terzoOneBackend.models.Authorities;
//import com.terzoOne.terzoOneBackend.models.Users;
//import com.terzoOne.terzoOneBackend.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        Users user = userRepository.findByEmail(email);
//        if (user == null) {
//            throw new UsernameNotFoundException("Invalid username or password.");
//        }
//
//        List<GrantedAuthority> authorities = getUserAuthorities(user);
//
//        return new org.springframework.security.core.userdetails.User(
//                user.getEmail(), user.getPassword(), user.getEnabled() == 1, true, true, true, authorities);
//    }
//
//    private List<GrantedAuthority> getUserAuthorities(Users user) {
//        Authorities authorities = user.getAuthorities();
//        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
//        if (authorities != null) {
//            grantedAuthorities.add(new SimpleGrantedAuthority(authorities.getRole()));
//        }
//        return grantedAuthorities;
//    }
//}
//
