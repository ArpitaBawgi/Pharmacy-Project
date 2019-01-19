package com.group4.project.DataService;

import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.group4.project.DataService.DAO.UserDAO;
import com.group4.project.DataService.Model.User;
import com.group4.project.DataService.Repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserTest {

	@Autowired
	private UserDAO dao;

	@MockBean
	private UserRepository repo;

	@Test
	public void searchAlluserTest() {

		when(repo.findAll()).thenReturn(Stream.of(new User("102", "pooji", "4568")).collect(Collectors.toList()));
		assertEquals(1, dao.searchAll().size());
	}

	@Test
	public void createUserTest() {
		User user = new User("405", "rahul", "8659");

		dao.create(user);
		verify(repo, times(1)).save(user);
	}

	@Test
	public void deleteUserTest() {
		User user = new User("405", "rahul", "8569");
		dao.remove(user);
		verify(repo, times(1)).delete(user);
	}

	@Test
	public void deleteUserByIDTest() {
		User user = new User("405", "rahul", "8569");
		dao.removebyId("8569");
		verify(repo, times(1)).deleteById("8569");
	}

	@Test
	public void deleteAllTest() {
		User user1 = new User("405", "rahul", "8569");
		User user2 = new User("502", "priti", "4258");
		dao.removeAll();
		verify(repo, times(1)).deleteAll();
	}

	@Test
	public void userPresentTest() {
		User user1 = new User("405", "rahul", "8569");
		when(repo.existsById("8569")).thenReturn(true);
		assertEquals(true, dao.isPresent("8569"));

	}

	@Test
	public void countUserTest() {
		User user1 = new User("405", "rahul", "8569");
		User user2 = new User("305", "kajal", "8269");
		User user3 = new User("505", "manish", "2569");
		when(repo.count()).thenReturn(3L);
		assertEquals(3, dao.total());
	}

	@Test
	public void searchUserByIDTest() {
		User user1 = new User("405", "rahul", "8569");
		User user2 = new User("505", "simer", "8069");
		when(repo.findById("405")).thenReturn(Optional.of(user1));
		assertEquals(Optional.of(user1), dao.searchById("405"));

	}

	@Test
	public void searAllUserbyIDTest() {
		User user1 = new User("405", "rahul", "8569");
		User user2 = new User("305", "kajal", "8269");
		User user3 = new User("505", "manish", "2569");
		ArrayList<String> ids = new ArrayList<>();
		ids.add("305");
		ids.add("405");
		ArrayList<User> list = new ArrayList<>();
		list.add(user1);
		list.add(user2);

		when(repo.findAllById(ids)).thenReturn(list);
		assertEquals(list, dao.searchAllbyId(ids));

	}

	@Test
	public void createallUsers() {
		User user1 = new User("405", "rahul", "8569");
		User user2 = new User("305", "kajal", "8269");
		User user3 = new User("505", "manish", "2569");
		ArrayList<User> userlist = new ArrayList<>();
		dao.creatAll(userlist);
		verify(repo, times(1)).saveAll(userlist);

	}

}
