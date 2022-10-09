package com.apple.model;

import com.sun.istack.NotNull;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;



@Entity
@Table(name="APPLE_BAG")
public class AppleBag {


    @Id
    @GeneratedValue
    @Type(type="org.hibernate.type.UUIDCharType")
    public UUID id;

    @Column
    @NotNull
    @Min(value = 1, message = "Amount should not be lower than 1")
    @Max(value = 100, message = "Amount should not be greater than 100")
    public int amount;

    @Column
    @NotNull
    @Pattern(regexp="Royal Gala|Pink Lady|Kanzi Apple|Elstar Apples", message = "Supplier must be Royal Gala, Pink Lady, Kanzi Apple or, Elstar Apples")
    public String supplier;

    @Column
    private LocalDateTime dateTime = LocalDateTime.now();

    @Column
    @NotNull
    @Min(value = 1, message = "Price should not be lower than 1")
    @Max(value = 50, message = "Price should not be greater than 50")
    private double price;

    public AppleBag() {
    }

    public AppleBag(String supplier, int amount, double price) {
        this.amount = amount;
        this.supplier = supplier;
        this.price = price;
    }

    public String getSupplier(){
        return this.supplier;
    }

    public void setSupplier(){
        this.supplier = supplier;
    }

    public UUID getId(){
        return this.id;
    }

    public void setId(UUID id){
        this.id = id;
    }

    public double getPrice(){
        return this.price;
    }

    public void setPrice(double price){
        this.price = price;
    }


    public LocalDateTime getDateTime(){
        return this.dateTime;
    }

    public void setDateTime(LocalDateTime dateTime){
        this.dateTime = dateTime;
    }
    @Override
    public String toString() {
        return "AppleBag{" +
                "id=" + id +
                ", amount=" + amount +
                ", supplier='" + supplier + '\'' +
                ", dateTime=" + dateTime +
                ", price=" + price +
                '}';
    }

    //defining age as column name
//    @Column
//    private String supplier;
//    //defining email as column name

}

