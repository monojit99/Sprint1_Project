package com.ars;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.PersistenceException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.ars.config.HibernateUtil;
import com.ars.entity.Passenger;
import com.ars.model.PassengerDTO;
import com.ars.service.PassengerService;
import com.ars.serviceImpl.PassengerServiceImpl;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PassengerTest {

	PassengerService passengerService=new PassengerServiceImpl();
	private static SessionFactory sessionFactory;
	private Session session;
	
	@BeforeAll
	static void setUp()
	{
		sessionFactory=HibernateUtil.getSessionFactory();
	}
	@BeforeEach
	void openSession()
	{
		session=sessionFactory.openSession();
	}
	
@AfterEach
void closeSession()
{
	if(session!=null)
	session.close();
	System.out.println("Session closed");
}
@AfterAll
static void tearDown()
{
	if(sessionFactory!=null)
		sessionFactory.close();
	System.out.println("Session factory closed");
}
//testing for passenger registration
//@Test
//@Order(1)
//void testRegisterPassenger()
//{
//	Transaction tx1=session.beginTransaction();
//	Passenger passenger=Passenger.builder().aName("Nilanjan").email("nilanjan@gmail.com").UserName("npassenger").password("pass1234").role("passen").build();
//	Integer i=(Integer)session.save(passenger);
//	tx1.commit();
//	assertThat(i>0).isTrue();
//	}
//testing for get passenger
//@Test
//@Order(2)
//void testGetPassengerById()
//{
//	PassengerDTO pDto=passengerService.getPassengerById(5);
//	assertThat(pDto.getName()).isEqualTo("Monojit");
//	}
//testing for update passenger
//@Test
//@Order(3)
//void testUpdatePassengerUsingService()
//{
//	Transaction tx1=session.beginTransaction();
//	Passenger ps1=new Passenger();
//	ps1.setName("Monojit Chowdhury");
//	PassengerDTO pDto=passengerService.updatePassenger(5, ps1);
//	tx1.commit();
//	assertThat(aDto.getName()).isEqualTo("Monojit Chowdhury")
//	}
// testing for delete passenger
//@Test
//@Order(4)
//@DisplayName(value="Negetive Test case")
//void testDeletePassenger()
//{
//	passengerService.deletePassenger(1);
//	assertThrows(HibernateException.class,()->passengerService.getPassengerById(1));
//	}
}