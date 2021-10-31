package tn.esprit.spring.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.services.IEntrepriseService;
import tn.esprit.spring.entities.Entreprise;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EntrepriseServiceImplTest {


	@Autowired
	IEntrepriseService entreprise; 

	@Test
	@Order(2)
	public void testretrieveAllEntreprise() {
		List<Entreprise> entreprises = entreprise.retrieveAllEntreprise(); 
		Assert.assertFalse(entreprises.isEmpty());
	}

	

	@Test
	@Order(1)
	public void testajouterEntreprise() throws ParseException {
		Entreprise e = new Entreprise("SSII consulting", "Cite El Ghazela");
		//@SuppressWarnings("Unused")
		Entreprise entrepriseAdded = entreprise.ajouterEntreprise(e); 
		//Assert.assertEquals(e.getName(), entrepriseAdded.getName());
		Assert.assertNotNull(entreprise.getEntrepriseById(entrepriseAdded.getId()));
		System.out.println(entrepriseAdded.getId());
	}
	

	@Test
	@Order(3)
	public void testupdateEntreprise() throws ParseException   {
		Entreprise e = new Entreprise(5, "IGA Tunisie", "Cite El Ghazela");
		//@SuppressWarnings("Unused")
		Entreprise entrepriseUpdated  = entreprise.updateEntreprise(e); 
		Assert.assertEquals(e.getRaisonSocial(), entrepriseUpdated.getRaisonSocial());
	}

	
	

	@Test
	@Order(4)
	public void testgetEntrepriseById() {
		Entreprise entrepriseRetrieved = entreprise.getEntrepriseById(3); 
		Assert.assertEquals(3, entrepriseRetrieved.getId());
	}
	

	
	
	
	@Test
	@Order(5)
	public void testdeleteEntreprise() {
		entreprise.deleteEntreprise(2);
		Assert.assertNull(entreprise.getEntrepriseById(2));
	}
	
	// 5 tests unitaires  

}