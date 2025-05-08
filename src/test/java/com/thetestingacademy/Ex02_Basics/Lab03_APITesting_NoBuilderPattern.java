package com.thetestingacademy.Ex02_Basics;

public class Lab03_APITesting_NoBuilderPattern {
    public void step1(){
        System.out.println("Step1");
    }
    public void step2(){
        System.out.println("Step2");
    }
    public void step3(){
        System.out.println("Step3");
    }

    public static void main(String[] args) {
      Lab03_APITesting_NoBuilderPattern nobp=new Lab03_APITesting_NoBuilderPattern();
      nobp.step1();
      nobp.step2();
      nobp.step3();
    }
}
