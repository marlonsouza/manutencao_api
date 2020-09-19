package com.souza.manutencao.service;

import com.souza.manutencao.entity.User;
import com.souza.manutencao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {


    @Autowired
    private UserRepository respository;

    public User save(User user){
        return respository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return this.respository.findByEmail(login).orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado."));
    }
}
