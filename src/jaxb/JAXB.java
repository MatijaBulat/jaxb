/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb;

import java.io.File;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.xml.sax.SAXException;
import models.Student;

/**
 *
 * @author Matija
 */
public class JAXB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        String xmlFile = "C:\\Users\\Matija\\Desktop\\Interoperabilnost informacijskih sustava\\IIS-projects\\IIS-0102-REST-API\\Resources\\students.xml";
        String xsdFile = "C:\\Users\\Matija\\Desktop\\Interoperabilnost informacijskih sustava\\IIS-projects\\IIS-0102-REST-API\\Resources\\students.xsd";

        jaxbXmlFileToObject(xmlFile, xsdFile);
    }

    private static void jaxbXmlFileToObject(String xmlFile, String xsdFile) {

        JAXBContext jaxbContext;

        try {
            //Get JAXBContext
            jaxbContext = JAXBContext.newInstance(Student.class);

            //Create Unmarshaller
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            //Setup schema validator
            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema studentSchema = sf.newSchema(new File(xsdFile));
            jaxbUnmarshaller.setSchema(studentSchema);

            //Unmarshal xml file 
            Student student = (Student) jaxbUnmarshaller.unmarshal(new File(xmlFile));

            System.out.println(student);
        } catch (JAXBException | SAXException e) {
            e.printStackTrace();
        }
    }
}
