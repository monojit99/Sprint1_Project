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
import com.ars.service.TicketService;
import com.ars.serviceImpl.TicketServiceImpl;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TicketBookingTest {

	TicketService passengerService=new TicketServiceImpl();
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
//testing for ticket booking
//@Test
//@Order(1)
//void testBookTicket()
//{
//	Transaction tx6=session.beginTransaction();
//	TicketBooking ticket_booking=TicketBooking.builder().ticketId(787878).no_of_passenger(6).total_fare(15000).date("2023-03-17").id(1).aid(2).pid(5).build();
//	Integer i=(Integer)session.save(ticket_booking);
//	tx6.commit();
//	assertThat(i>0).isTrue();
//	}
//testing for cancel ticket
//@Test
//@Order(2)
//@DisplayName(value="Negetive Test case")
//void testCancelTicketById()
//{
//TicketService.cancelBooking(1);
//assertThrows(HibernateException.class,()->ticketService.getTicket(1));
//	}
//testing for get the ticket
//@Test
//@Order(3)
//void testGetTicketById()
//{
//	TicketBookingDTO tdto=ticketService.getTicket(5);
//	assertThat(tdto.getName()).isEqualTo("Monojit");
//	}
}
