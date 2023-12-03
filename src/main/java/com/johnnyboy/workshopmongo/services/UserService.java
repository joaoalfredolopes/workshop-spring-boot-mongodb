package com.johnnyboy.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johnnyboy.workshopmongo.domain.User;
import com.johnnyboy.workshopmongo.dto.UserDTO;
import com.johnnyboy.workshopmongo.repository.UserRepository;
import com.johnnyboy.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado"));
		
	}
	
	public User Insert(User obj) {
		return userRepository.insert(obj);
		
	}
	
	public void delete(String id) {
		findById(id);
		userRepository.deleteById(id);
	}
	
	public User fromDTO(UserDTO objDTO ) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
		
	}
	
	

}
