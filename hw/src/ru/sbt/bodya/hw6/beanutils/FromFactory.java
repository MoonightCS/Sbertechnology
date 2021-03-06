package ru.sbt.bodya.hw6.beanutils;

import java.util.Date;

public class FromFactory {

    private Integer object1;
    private Double object2;
    private Date object3;
    private Account object4;
    private String object5;
    private Float object6;
    private Character object7;


    public FromFactory(Integer object1, Double object2, Date object3, Account object4, String object5, Float object6, Character object7) {
        this.object1 = object1;
        this.object2 = object2;
        this.object3 = object3;
        this.object4 = object4;
        this.object5 = object5;
        this.object6 = object6;
        this.object7 = object7;
    }

    public Integer getObject1() {
        return object1;
    }

    public Double getObject2() {
        return object2;
    }

    public Date getObject3() {
        return object3;
    }

    public Account getObject4() {
        return object4;
    }

    public String getObject5() {
        return object5;
    }

    public Float getObject6() {
        return object6;
    }

    public Character getObject7() {
        return object7;
    }

    public void setObject1(Integer object1) {
        this.object1 = object1;
    }

    public void setObject2(Double object2) {
        this.object2 = object2;
    }

    public void setObject3(Date object3) {
        this.object3 = object3;
    }

    public void setObject4(Account object4) {
        this.object4 = object4;
    }

    public void setObject5(String object5) {
        this.object5 = object5;
    }

    public void setObject6(Float object6) {
        this.object6 = object6;
    }

    public void setObject7(Character object7) {
        this.object7 = object7;
    }
}