package com.jsp.boot_movie_crud.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.jsp.boot_movie_crud.entity.Movie;
import com.jsp.boot_movie_crud.repository.MovieRepository;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@Controller
public class MovieController {
 MovieRepository repository;
	@GetMapping("/")
	public String loadmain(ModelMap map)
	{
		List<Movie> movies = repository.findAll();
		if(!movies.isEmpty())
			map.put("movies", movies);
		return "main.html";
	}
	@GetMapping("/add")
	public String loadadd()
	{
		return "add.html";
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id, RedirectAttributes attributes) {
		repository.deleteById(id);
		attributes.addFlashAttribute("message","movie record deleted sucess");
		return "redirect:/";
	}
	
	@PostMapping("/add")
	public String add(@ModelAttribute Movie movie, RedirectAttributes attribute)
	{
		repository.save(movie);
		attribute.addFlashAttribute("message","Movie Record Added Success")	;	
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String loadEdit(@PathVariable Long id,ModelMap map) {
		
		Movie movie=repository.findById(id).orElseThrow();
		map.put("movie", movie);
		return "edit.html";
	}
	
	

}


