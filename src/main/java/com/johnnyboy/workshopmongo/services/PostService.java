package com.johnnyboy.workshopmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johnnyboy.workshopmongo.domain.Post;
import com.johnnyboy.workshopmongo.repository.PostRepository;
import com.johnnyboy.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
		
	public Post findById(String id) {
		Optional<Post> obj = postRepository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado"));
		
	}
	
}
