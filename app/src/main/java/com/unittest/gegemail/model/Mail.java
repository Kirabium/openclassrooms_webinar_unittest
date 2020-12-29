package com.unittest.gegemail.model;

import java.util.ArrayList;
import java.util.Arrays;

public class Mail {
    private String object;
    private String text;
    private String expeditor;

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public Mail() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getExpeditor() {
        return expeditor;
    }

    public void setExpeditor(String expeditor) {
        this.expeditor = expeditor;
    }

    public Mail(String object, String text, String expeditor) {
        this.object = object;
        this.text = text;
        this.expeditor = expeditor;
    }

    public static Mail[] getMails(){
        return new Mail[]{new Mail("Réunion", "nouvelle réunion demain soir à 19h", "toto@gegemail.com"),
                new Mail("Financement", "votre financement va se terminer dans 3 jours", "Pole emploi"),
                new Mail("Webinar", "nouveau webinar demain soir à 19h", "Openclassrooms"),
                new Mail("Raclette", "raclette demain soir à 20h", "hugue@gegemail.com")};
    }
}
