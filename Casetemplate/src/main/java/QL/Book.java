package QL;

import java.util.Date;

public class Book {
    private long id;
    private String name;
    private String description;
    private Date entryDate;
    private double price;
    public Book(){

    }
    public Book(long id, String name, String description, Date entryDate, double price){
        this.id = id;
        this.description = description;
        this.name = name;
        this.price = price;
        this.entryDate = entryDate;
    }
    public long getId(){
        return this.id;
    }
    public void setId(long id){
        this.id = id;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public double getPrice(){
        return this.price;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public Date getEntryDate(){
        return  this.entryDate;
    }
    public void setEntryDate(Date entryDate){
        this.entryDate = entryDate;
    }
}
