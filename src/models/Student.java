/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Matija
 */
@XmlRootElement(name = "student")
public class Student {
    
    @XmlElement(name = "name")
    public String name;
    @XmlElement(name = "surname")
    public String surname;
    @XmlElement(name = "subject")
    public String subject;
    @XmlElement(name = "grade")
    public int grade;
}
