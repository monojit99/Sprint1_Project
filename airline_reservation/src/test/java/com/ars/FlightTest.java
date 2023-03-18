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
import com.ars.entity.Airline;
import com.ars.service.FlightService;
import com.ars.serviceImpl.FlightServiceImpl;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FlightTest {

	FlightService flightService=new FlightServiceImpl();
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
//testing for flight registration
//@Test
//@Order(1)
//void testRegisterFlight()
//{
//	Transaction tx2=session.beginTransaction();
//	Flight flight=Flight.builder().flight_id(1).avilableSeats(50).totalSeats(100).travellerClass("business").time("IST").date("2023-03-17").source("Kolkata").destination("hyderabad").airline("Indigo").build();
//	Integer i=(Integer)session.save(flight);
//	tx2.commit();
//	assertThat(i>0).isTrue();
//	}
//testing for get flight
//@Test
//@Order(2)
//void testGetFlightById()
//{
//	FlightDTO fDto=flightService.getFlightById(5);
//	assertThat(fDto.getTravellerClass()).isEqualTo("sleeper");
//	}
//testing for update flight
//@Test
//@Order(3)
//void testUpdateFlightUsingService()
//{
//	Transaction tx2=session.beginTransaction();
//	Flight fl1=new Flight();
//	fl1.setTravellerClass("business class");
//	FlightDTO fDto=flightService.updateFlight(5, fl1);
//	tx2.commit();
//	assertThat(fDto.getTravellerClass()).isEqualTo("business class");
//	}
// testing for delete flight
//@Test
//@Order(4)
//@DisplayName(value="Negetive Test case")
//void testDeleteFlight()
//{
//	flightService.deleteFlight(1);
//	assertThrows(HibernateException.class,()->flightService.getFlightById(1));
//	}

//testing for assignairlinetoflight
//@Test
//@Order(5)
//void assignAirlineToFlightTest()
//{
//Transaction tx2=session.beginTransaction();
//Flight fl1=new Flight();
//fl1.setFlight_id(1);
//Airline fl2=new Airline();
//fl2.setAirline_id(2);
//FlightDTO fDto=flightService.setFlight(5, fl2);
//tx2.commit();
}
