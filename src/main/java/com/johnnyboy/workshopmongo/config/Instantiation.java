package com.johnnyboy.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.johnnyboy.workshopmongo.domain.Post;
import com.johnnyboy.workshopmongo.domain.User;
import com.johnnyboy.workshopmongo.dto.AuthorDTO;
import com.johnnyboy.workshopmongo.dto.CommentDTO;
import com.johnnyboy.workshopmongo.repository.PostRepository;
import com.johnnyboy.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
				
		User helenita = new User(null, "Helenita Rodriguez", "helenrodri@gmail.com");
		User james = new User(null, "James Western", "jamesalton@gmail.com");
		User javier = new User(null, "Javier Domenicano", "javierbobito@gmail.com");
		
		userRepository.saveAll(Arrays.asList(helenita, james,javier));
		
		Post post1 = new Post(null, sdf.parse("28/11/2023"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(javier));
		Post post2 = new Post(null, sdf.parse("30/11/2023"), "Bom dia",  "Acordei feliz hoje!", new AuthorDTO(javier));
		
		CommentDTO ct1 = new CommentDTO("Aproveite as férias", sdf.parse("02/12/2023"), new AuthorDTO(helenita));
		CommentDTO ct2 = new CommentDTO("Manda fotos, não abusa do mé", sdf.parse("03/12/2023"), new AuthorDTO(james));
		CommentDTO ct3 = new CommentDTO("Se for a Santos,procura a Nath", sdf.parse("03/12/2023"), new AuthorDTO(helenita));
		
		post1.getComments().addAll(Arrays.asList(ct1,ct2));
		post2.getComments().addAll(Arrays.asList(ct3));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		javier.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(javier);
		
	}

}
