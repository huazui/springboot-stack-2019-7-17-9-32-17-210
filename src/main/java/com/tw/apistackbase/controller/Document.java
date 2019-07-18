package com.oocl.web.sampleWebApp.jpaSample.entity;

import javax.persistence.*;

@Entity
public class Document {
    public Document(String s,String o){
        this.objectiveElement=o;
        this.sbujectElement=s;
    }
    @Id
    private long id;
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="subjectiveElement",length=255)
    private String sbujectElement;
    @Column(name="objectiveElement",length=255)
    private String objectiveElement;

    public long getId() {
        return id;
    }

    public String getObjectiveElement() {
        return objectiveElement;
    }

    public void setObjectiveElement(String objectiveElement) {
        this.objectiveElement = objectiveElement;
    }

    public String getSbujectElement() {
        return sbujectElement;
    }

    public void setSbujectElement(String sbujectElement) {
        this.sbujectElement = sbujectElement;
    }
}
