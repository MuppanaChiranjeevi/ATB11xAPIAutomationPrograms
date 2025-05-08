package com.thetestingacademy.Ex02_Basics;

public class Lab04_APITesting_BuilderPattern {
    public Lab04_APITesting_BuilderPattern step1(){
        System.out.println("Step1");
        return this;
    }
    public Lab04_APITesting_BuilderPattern step2(){
        System.out.println("Step2");
        return this;
    }
    public Lab04_APITesting_BuilderPattern step3(String name){
        System.out.println("Step3");
        return this;
    }

    public static void main(String[] args) {
        Lab04_APITesting_BuilderPattern bp=new Lab04_APITesting_BuilderPattern();
        bp.step1().step2().step3("Chiru");
    }
}
