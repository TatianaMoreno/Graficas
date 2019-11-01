/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.graficas;


import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author AndresChila
 */
@ManagedBean(name = "contollerVotos")
@Dependent
@ViewScoped
public class ContollerVotos {

    Candidato c1 = new Candidato("Angie", " ", 0);
    Candidato c2 = new Candidato("Santiago", " ", 0);
    Candidato c3 = new Candidato("Adirana", " ", 0);
    private PieChartModel pieModel1;
    public ContollerVotos() {
        
    }
    @PostConstruct
    public void init(){
        createPieModel1();
    }
    public void sumarVotos(int nombreCandidato){
        if(nombreCandidato==1){
            c1.setVotos(c1.getVotos()+1);
        }
        if(nombreCandidato==2){
            c2.setVotos(c2.getVotos()+1);
        }
        if(nombreCandidato==3){
            c3.setVotos(c3.getVotos()+1);
        }
        createPieModel1();
    }
    private void createPieModel1() {
        pieModel1 = new PieChartModel();
 
        pieModel1.set("Angie", c1.getVotos());
        pieModel1.set("Santiago", c2.getVotos());
        pieModel1.set("Adriana", c3.getVotos());
        pieModel1.setTitle("Simple Pie");
        pieModel1.setLegendPosition("w");
        pieModel1.setShadow(true);
    }

    public PieChartModel getPieModel1() {
        return pieModel1;
    }

    public void setPieModel1(PieChartModel pieModel1) {
        this.pieModel1 = pieModel1;
    }
    
}
