package com.group4.project.DataService.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.group4.project.DataService.Model.User;
import com.group4.project.DataService.Repository.UserRepository;

@RestController
public class UserDAO {

	@Autowired
	UserRepository userRepository;

	@RequestMapping(method = RequestMethod.POST, value = "user/create")
	void create(@RequestBody User user) {
		userRepository.save(user);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "users/remove")
	void remove(@RequestBody User user) {
		userRepository.delete(user);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "user/removeusingid/{id}")
	void removebyId(@PathVariable String id) {
		userRepository.deleteById(id);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "user/removeall")
	void removeAll() {
		userRepository.deleteAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "user/present/{id}")
	public boolean isPresent(@PathVariable String id) {
		return userRepository.existsById(id);
	}

	@RequestMapping("user/total")
	public long total() {
		return userRepository.count();
	}

	@RequestMapping(method = RequestMethod.GET, value = "user/searchbyid/{id}")
	public Optional<User> searchById(@PathVariable String id) {
		return userRepository.findById(id);
	}

	@RequestMapping(method = RequestMethod.GET, value = "user/searchallbyid/{ids}")
	public Iterable<User> searchAllbyId(@PathVariable ArrayList<String> ids) {
		return userRepository.findAllById(ids);
	}

	@RequestMapping(method = RequestMethod.POST, value = "user/createall")
	void creatAll(@RequestBody ArrayList<User> u) {
		userRepository.saveAll(u);
	}

	@RequestMapping("user/getall")
	public List<User> searchAll() {
		List<User> userList = userRepository.findAll();
		return userList;

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "user/deleteall")
	void removeAllUser() {
		userRepository.deleteAll();
	}

}
