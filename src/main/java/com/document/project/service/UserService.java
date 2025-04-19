package com.document.project.service;

import com.document.project.DTO.UserDTO;
import com.document.project.domain.User;
import com.document.project.repository.UserRepository;
import com.document.project.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(String id) {
        Optional<User> userOptional = repo.findById(id);
        if (!userOptional.isPresent()) {
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
        return userOptional.get();
    }

    public User insert(User obj){
        return repo.insert(obj);
    }

    public User fromDTO(UserDTO objDto){
        return new User(objDto.getId(), objDto.getNome(), objDto.getEmail());
    }

    public void delete(String id){
        findById(id);
        repo.deleteById(id);
    }
}
