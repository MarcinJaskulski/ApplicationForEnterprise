/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.backing;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import javax.annotation.ManagedBean;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.model.chart.LegendPlacement;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author kliwe
 */
@Named(value = "manageBean")
@ManagedBean
@RequestScoped
public class ManageBean {

    private int firstNumber;
    private int secondNumber;
    private int resultNumber;
    private Date date;
    private ArrayList<Student> students = new ArrayList<>();
    private LineChartModel lineModel;
    
     /**
     * Creates a new instance of ManagedBean
     */
    public ManageBean() {
        CreateStudentsList();
        CreateChartData();
    }
    
    private void CreateStudentsList(){
        students.add(new Student("Jan","Wolny", 2.0));
        students.add(new Student("Jan","Szybki", 3.0));
        students.add(new Student("Elon","Kowalski", 4.0));
        students.add(new Student("Eryk","Szybki", 4.5));
        students.add(new Student("Eryk","Kowalski", 5.0));
    }
    
    private void CreateChartData(){
        lineModel = new LineChartModel();
        
        LineChartSeries sin = new LineChartSeries();
        LineChartSeries cos = new LineChartSeries();
        
        sin.setLabel("Sine");
        cos.setLabel("Cosine");
        
        for(int i=0; i<=360; i+=10){
            sin.set(i, Math.sin(i));
            cos.set(i, Math.cos(i));
        }
        lineModel.setTitle("Sin and Cos chart");
        lineModel.addSeries(sin);
        lineModel.addSeries(cos);
        
        lineModel.setZoom(true);      
    }

    public void addNumbers(){      
        setResultNumber(getFirstNumber() + getSecondNumber());
        addMessage();
    }
    
    public void addMessage(){
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage("growl", new FacesMessage("resultValue:", getFirstNumber() + "+" + getSecondNumber() + "=" + getResultNumber()));
    }
    
    /**
     * @return the firstNumber
     */
    public int getFirstNumber() {
        return firstNumber;
    }

    /**
     * @param firstNumber the firstNumber to set
     */
    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    /**
     * @return the secondNumber
     */
    public int getSecondNumber() {
        return secondNumber;
    }

    /**
     * @param secondNumber the secondNumber to set
     */
    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    /**
     * @return the result
     */
    public int getResultNumber() {
        return resultNumber;
    }

    /**
     * @param result the result to set
     */
    public void setResultNumber(int result) {
        this.resultNumber = result;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return Date.from(Instant.now());
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }    

    /**
     * @return the students
     */
    public ArrayList<Student> getStudents() {
        return students;
    }

    /**
     * @param students the students to set
     */
    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    /**
     * @return the lineModel
     */
    public LineChartModel getLineModel() {
        return lineModel;
    }

    /**
     * @param lineModel the lineModel to set
     */
    public void setLineModel(LineChartModel lineModel) {
        this.lineModel = lineModel;
    }
}
