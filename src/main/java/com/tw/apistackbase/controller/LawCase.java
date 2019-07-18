package com.oocl.web.sampleWebApp.jpaSample.entity;

import javax.persistence.*;

@Entity
public class LawCase {


            public  LawCase(String name,long time) {
                this.name = name;
                this.time = time;
            }
           public LawCase(){}

            @Id
            @GeneratedValue(strategy = GenerationType.AUTO)
            private Long id;
            @Column(name="name",length=255)
            private String name;
            @Column(name="time")
            private long time;
            @OneToOne(cascade = CascadeType.ALL)
            private Document document;
            public void setName(String name) {
                this.name = name;
            }

           public Long getId() {
            return id;
          }

          public String getName() {
                return name;
            }

            public void setId(Long id) {
                this.id = id;
            }

            public long getTime() {
                return time;
            }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Document getDocument() {
        return document;
    }
}

