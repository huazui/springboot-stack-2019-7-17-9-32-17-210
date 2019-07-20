package com.oocl.web.sampleWebApp.jpaSample.entity;

import javax.persistence.*;
import java.util.List;


@Entity
public class Procuratorate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="name",length=255,unique = true)
    private String name;
    @OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name="lawCase_id")
    private List<LawCase> lawCaseList;

    public void setId(long id) {
        this.id = id;
    }

   @OneToMany (cascade = CascadeType.ALL,fetch=FetchType.LAZY)

   private List<Inquisitor> inquisitorList;

    public void setName(String name) {
        this.name = name;
    }

    public List<LawCase> getLawCaseList() {
        return lawCaseList;
    }

    public void setLawCaseList(List<LawCase> lawCaseList) {
        this.lawCaseList = lawCaseList;
    }

    public List<Inquisitor> getInquisitorList() {
        return inquisitorList;
    }

    public void setInquisitorList(List<Inquisitor> inquisitorList) {
        this.inquisitorList = inquisitorList;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }
}

