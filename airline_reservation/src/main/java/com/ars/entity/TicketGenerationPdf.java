package com.ars.entity;


import java.io.File;
import java.io.FileOutputStream;

import com.ars.model.TicketBookingDTO;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;

public class TicketGenerationPdf {
	private static final String FILE_NAME="F://pdfbackup/TicketDetails.pdf";
	public static void TicketGeneration(TicketBookingDTO ticketDTO)
	{
		Document document=new Document(PageSize.A4,20,20,20,20);
		try {
			PdfWriter.getInstance(document, new FileOutputStream(new File(FILE_NAME)));
			document.open();
			Font f1=new Font();
			f1.setStyle(Font.BOLD);
			f1.setSize(10);
			Paragraph p=new Paragraph("",f1);
			p.add(ticketDTO.getAid().getAirlineName()+" "+"Ticket Id:"+ticketDTO.getTicketId());
			document.add(p);
			Paragraph p1=new Paragraph();
			p1.add(ticketDTO.getPid().getName());
			p1.setAlignment(Element.ALIGN_LEFT);
			document.add(p1);
			Chunk linebreak=new Chunk(new DottedLineSeparator());
			document.add(linebreak);
			
			Paragraph p2=new Paragraph();
			p2.add("From: "+ticketDTO.getId().getSource()+
					" "+"TO: "+ticketDTO.getId().getDestination()+" "+"Travel Date: "+ticketDTO.getId().getDate().toString());
			document.add(p2);
			
			Paragraph p3=new Paragraph();
			p3.add("Flight id: "+ticketDTO.getId().getFlight_id());
			p3.add("Boarding Time: "+ticketDTO.getId().getTime());
			document.add(p3);
			
			Font f=new Font();
			f.setSize(Font.BOLD);
			f.setSize(8);
			Paragraph p4 =new Paragraph("Gate Closed 20 min before Departure",f);
			p4.setAlignment(Element.ALIGN_BOTTOM);
			document.add(p4);
			document.close();
			System.out.println("Ticket has download in your system");
			
			
		}catch (Exception e) {
			System.out.println(e);
		}
	}

}
