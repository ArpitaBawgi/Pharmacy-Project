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

import com.group4.project.DataService.DAO.MedicineDAO;

import com.group4.project.DataService.Model.MedicineProduct;

import com.group4.project.DataService.Repository.MedicineRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MedicineTest {

	@Autowired
	private MedicineDAO dao;

	@MockBean
	private MedicineRepository repo;

	@Test
	public void searchAllmedicineTest() {

		when(repo.findAll()).thenReturn(Stream
				.of(new MedicineProduct("100", "Paracetamol", new Date(2000 - 1 - 1), new Date(2003 - 06 - 04), 200))
				.collect(Collectors.toList()));
		assertEquals(1, dao.searchAll().size());
	}

	@Test
	public void createMedicineTest() {
		MedicineProduct p1 = new MedicineProduct("100", "Paracetamol", new Date(2001 - 1 - 1), new Date(2003 - 06 - 04),
				200);

		dao.create(p1);
		verify(repo, times(1)).save(p1);
	}

	@Test
	public void deleteMedicineTest() {
		MedicineProduct p1 = new MedicineProduct("100", "Paracetamol", new Date(2002 - 1 - 1), new Date(2003 - 06 - 04),
				200);

		dao.remove(p1);
		verify(repo, times(1)).delete(p1);
	}

	@Test
	public void deleteMedicineByIDTest() {
		MedicineProduct p1 = new MedicineProduct("100", "Paracetamol", new Date(2001 - 1 - 1), new Date(2003 - 06 - 04),
				200);

		dao.removebyId("100");
		verify(repo, times(1)).deleteById("100");
	}

	@Test
	public void deleteAllTest() {
		MedicineProduct p1 = new MedicineProduct("100", "Paracetamol", new Date(2001 - 1 - 1), new Date(2003 - 06 - 04),
				200);

		MedicineProduct p2 = new MedicineProduct("101", "cinarest", new Date(2002 - 4 - 6), new Date(2006 - 05 - 04),
				200);

		dao.removeAll();
		verify(repo, times(1)).deleteAll();
	}

	@Test
	public void medicinePresentTest() {
		MedicineProduct p1 = new MedicineProduct("100", "Paracetamol", new Date(2001 - 1 - 1), new Date(2003 - 06 - 04),
				200);

		when(repo.existsById("100")).thenReturn(true);
		assertEquals(true, dao.isPresent("100"));

	}

	@Test
	public void countMedicineTest() {
		MedicineProduct p1 = new MedicineProduct("100", "Paracetamol", new Date(2000 - 2 - 1), new Date(2003 - 06 - 04),
				200);

		MedicineProduct p2 = new MedicineProduct("101", "Benadryl", new Date(2001 - 1 - 1), new Date(2003 - 06 - 04),
				200);

		MedicineProduct p3 = new MedicineProduct("102", "cinarest", new Date(2002 - 1 - 1), new Date(2003 - 06 - 04),
				200);
		when(repo.count()).thenReturn(3L);
		assertEquals(3, dao.total());
	}

	@Test
	public void searchMedicineByIDTest() {
		MedicineProduct p1 = new MedicineProduct("100", "Paracetamol", new Date(2000 - 1 - 1), new Date(2003 - 06 - 04),
				200);
		MedicineProduct p2 = new MedicineProduct("101", "cinarest", new Date(2001 - 1 - 1), new Date(2003 - 06 - 04),
				200);

		when(repo.findById("100")).thenReturn(Optional.of(p1));
		assertEquals(Optional.of(p1), dao.searchById("100"));

	}

	@Test
	public void searAllMedicinebyIDTest() {
		MedicineProduct p1 = new MedicineProduct("100", "Paracetamol", new Date(2001 - 1 - 1), new Date(2003 - 06 - 04),
				200);
		MedicineProduct p2 = new MedicineProduct("101", "Cinarest", new Date(2002 - 1 - 1), new Date(2003 - 06 - 04),
				200);
		MedicineProduct p3 = new MedicineProduct("102", "Baenadryl", new Date(2003 - 1 - 1), new Date(2003 - 06 - 04),
				200);

		ArrayList<String> ids = new ArrayList<>();
		ids.add("100");
		ids.add("101");
		ArrayList<MedicineProduct> list = new ArrayList<>();
		list.add(p1);
		list.add(p2);

		when(repo.findAllById(ids)).thenReturn(list);
		assertEquals(list, dao.searchAllbyId(ids));

	}

	@Test
	public void createallMedicineTest() {
		MedicineProduct p1 = new MedicineProduct("100", "Paracetamol", new Date(2000 - 1 - 1), new Date(2003 - 06 - 04),
				200);
		MedicineProduct p2 = new MedicineProduct("101", "Cinarest", new Date(2001 - 1 - 1), new Date(2003 - 06 - 04),
				200);
		MedicineProduct p3 = new MedicineProduct("102", "Baenadryl", new Date(2002 - 1 - 1), new Date(2003 - 06 - 04),
				200);

		ArrayList<MedicineProduct> medicinelist = new ArrayList<>();
		dao.creatAll(medicinelist);
		verify(repo, times(1)).saveAll(medicinelist);

	}

}
