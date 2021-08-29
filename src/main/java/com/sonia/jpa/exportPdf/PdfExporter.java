package com.sonia.jpa.exportPdf;
import java.util.List;

import com.sonia.jpa.entities.Employee;
import java.awt.Color;
import java.io.IOException;

 
import javax.servlet.http.HttpServletResponse;
 
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
public class PdfExporter {  
	
	
private List<Employee> listempl;

public PdfExporter(List<Employee> listEmployees) {
   this.listempl = listEmployees;
}

private void writeTableHeader(PdfPTable table) {
   PdfPCell cell = new PdfPCell();
   cell.setBackgroundColor(Color.BLUE);
   cell.setPadding(5);
    
   Font font = FontFactory.getFont(FontFactory.HELVETICA);
   font.setColor(Color.WHITE);
    
  
   cell.setPhrase(new Phrase("nom", font));
   table.addCell(cell);
    
   cell.setPhrase(new Phrase("prenom", font));
   table.addCell(cell);
    
     
   cell.setPhrase(new Phrase("lieu de naissance", font));
   table.addCell(cell); 
  
   cell.setPhrase(new Phrase("diplome", font));
   table.addCell(cell); 
  
   cell.setPhrase(new Phrase("email", font));
   table.addCell(cell); 
   cell.setPhrase(new Phrase("situation", font));
   table.addCell(cell); 
   cell.setPhrase(new Phrase("date d'embauche", font));
   table.addCell(cell); 
   
   cell.setPhrase(new Phrase("lieu de naissance", font));
   table.addCell(cell); 
   cell.setPhrase(new Phrase("date de naissance", font));
   table.addCell(cell); 
   cell.setPhrase(new Phrase("telephone", font));
   table.addCell(cell); 
   cell.setPhrase(new Phrase("departements", font));
   table.addCell(cell); 
   
 
}

private void writeTableData(PdfPTable table) {
   for (Employee e : listempl) {
      
       table.addCell(e.getNom_empl());
       table.addCell(e.getPrenom_empl());
       
       table.addCell(e.getLieu_naissance());
     
       table.addCell(e.getDiplome());
       table.addCell(e.getEmail());
       table.addCell(e.getSituation());
       table.addCell(e.getDate_embauche());
       table.addCell(e.getLieu_naissance());
       table.addCell(e.getDate_naissance());
       table.addCell(e.getTelephone());
       table.addCell(e.getDepartements().getNom_dep());
      
      
     
   }
}

public void export(HttpServletResponse response) throws DocumentException, IOException {
   Document document = new Document(PageSize.A4);
   PdfWriter.getInstance(document, response.getOutputStream());
    
   document.open();
   Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
   font.setSize(11);
   font.setColor(Color.gray);
    
   Paragraph p = new Paragraph("List of Employees", font);
   p.setAlignment(Paragraph.ALIGN_CENTER);
    
   document.add(p);
    
   PdfPTable table = new PdfPTable(11);
   table.setWidthPercentage(100f);
   table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 1.5f,1.5f, 3.5f, 3.0f, 3.0f, 1.5f,1.5f});
   table.setSpacingBefore(5);
    
   writeTableHeader(table);
   writeTableData(table);
    
   document.add(table);
    
   document.close();
    
}
}