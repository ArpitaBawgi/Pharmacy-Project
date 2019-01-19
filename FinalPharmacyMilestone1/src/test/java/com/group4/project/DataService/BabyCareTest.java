package com.group4.project.DataService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.group4.project.DataService.DAO.BabyCareDAO;
import com.group4.project.DataService.Model.BabyCareProduct;

import com.group4.project.DataService.Repository.BabyCareRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BabyCareTest {

	@Autowired
	private BabyCareDAO dao;

	@MockBean
	private BabyCareRepository repo;

	@Test
	public void searchAllbabycareTest() {

		when(repo.findAll()).thenReturn(Stream.of(
				new BabyCareProduct("100", "Jhonsonbaby cream", new Date(2000 - 1 - 1), new Date(2003 - 06 - 04), 200))
				.collect(Collectors.toList()));
		assertEquals(1, dao.searchAll().size());
	}

	@Test
	public void createBabyCareTest() {
		BabyCareProduct p1 = new BabyCareProduct("100", "Jhonsonbaby cream", new Date(2000 - 1 - 1),
				new Date(2003 - 06 - 04), 200);

		dao.create(p1);
		verify(repo, times(1)).save(p1);
	}

	@Test
	public void deleteBabyCareTest() {
		BabyCareProduct p1 = new BabyCareProduct("100", "Jhonsonbaby cream", new Date(2000 - 1 - 1),
				new Date(2003 - 06 - 04), 200);

		dao.remove(p1);
		verify(repo, times(1)).delete(p1);
	}

	@Test
	public void deleteBabyCareByIDTest() {
		BabyCareProduct p1 = new BabyCareProduct("100", "Jhonsonbaby cream", new Date(2001 - 1 - 1),
				new Date(2003 - 06 - 04), 200);

		dao.removebyId("100");
		verify(repo, times(1)).deleteById("100");
	}

	@Test
	public void deleteAllTest() {
		BabyCareProduct p1 = new BabyCareProduct("100", "Jhonsonbaby cream", new Date(2001 - 1 - 1),
				new Date(2003 - 06 - 04), 200);

		BabyCareProduct p2 = new BabyCareProduct("101", "Jhonsonbaby powder", new Date(2002 - 4 - 6),
				new Date(2006 - 05 - 04), 200);

		dao.removeAll();
		verify(repo, times(1)).deleteAll();
	}

	@Test
	public void babyCarePresentTest() {
		BabyCareProduct p1 = new BabyCareProduct("100", "Jhonsonbaby", new Date(2001 - 1 - 1), new Date(2003 - 06 - 04),
				200);

		when(repo.existsById("100")).thenReturn(true);
		assertEquals(true, dao.isPresent("100"));

	}

	@Test
	public void countBabyCareTest() {
		BabyCareProduct p1 = new BabyCareProduct("100", "Jhonsonbaby cream", new Date(2000 - 2 - 1),
				new Date(2003 - 06 - 04), 200);

		BabyCareProduct p2 = new BabyCareProduct("101", "Jhonsonbaby oil", new Date(2001 - 1 - 1),
				new Date(2003 - 06 - 04), 200);

		BabyCareProduct p3 = new BabyCareProduct("102", "Jhonsonbaby powder", new Date(2002 - 1 - 1),
				new Date(2003 - 06 - 04), 200);
		when(repo.count()).thenReturn(3L);
		assertEquals(3, dao.total());
	}

	@Test
	public void searchbabyCareIDTest() {
		BabyCareProduct p1 = new BabyCareProduct("100", "Jhonsonbaby cream", new Date(2000 - 1 - 1),
				new Date(2003 - 06 - 04), 200);
		BabyCareProduct p2 = new BabyCareProduct("101", "Jhonsonbaby oil", new Date(2001 - 1 - 1),
				new Date(2003 - 06 - 04), 200);

		when(repo.findById("100")).thenReturn(Optional.of(p1));
		assertEquals(Optional.of(p1), dao.searchById("100"));

	}

	@Test
	public void searAllBabyCarebyIDTest() {
		BabyCareProduct p1 = new BabyCareProduct("100", "Jhonsonbaby cream", new Date(2000 - 1 - 1),
				new Date(2003 - 06 - 04), 200);
		BabyCareProduct p2 = new BabyCareProduct("101", "Jhonsonbaby oil", new Date(2001 - 1 - 1),
				new Date(2003 - 06 - 04), 200);
		BabyCareProduct p3 = new BabyCareProduct("102", "Jhonsonbaby powder", new Date(2002 - 1 - 1),
				new Date(2003 - 06 - 04), 200);

		ArrayList<String> ids = new ArrayList<>();
		ids.add("100");
		ids.add("101");
		ArrayList<BabyCareProduct> list = new ArrayList<>();
		list.add(p1);
		list.add(p2);

		when(repo.findAllById(ids)).thenReturn(list);
		assertEquals(list, dao.searchAllbyId(ids));

	}

	@Test
	public void createallBabyCareTest() {
		BabyCareProduct p1 = new BabyCareProduct("100", "Jhonsonbaby cream", new Date(2000 - 1 - 1),
				new Date(2003 - 06 - 04), 200);
		BabyCareProduct p2 = new BabyCareProduct("101", "Jhonsonbaby oil", new Date(2001 - 1 - 1),
				new Date(2003 - 06 - 04), 200);
		BabyCareProduct p3 = new BabyCareProduct("102", "Jhonsonbaby powder", new Date(2002 - 1 - 1),
				new Date(2003 - 06 - 04), 200);

		ArrayList<BabyCareProduct> babycarelist = new ArrayList<>();
		dao.creatAll(babycarelist);
		verify(repo, times(1)).saveAll(babycarelist);

	}

}
