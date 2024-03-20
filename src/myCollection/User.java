package myCollection;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class User {


    int id;
    String name,lastName,surName;
    Calendar birthDay;
    int age;
    String city;
    static int incId = 1;

    public User(int id, String name, String lastName, String surName, String birthDay, int age, String city) {
        this.id = incId;
        this.name = name;
        this.lastName = lastName;
        this.surName = surName;
        this.birthDay = convertDate(birthDay);
        this.age = age;
        this.city = city;
        incId++;

    }


    public Calendar convertDate(String date) {
        Calendar cal = new GregorianCalendar();
        String[] findDate = date.split("\\.");
        int[] convertedData = new int[3];
        for (int i = 0,j=2; i < findDate.length; i++,j--) {
            convertedData[j] = Integer.parseInt(findDate[i]);
        }
        cal.set(convertedData[0],convertedData[1] - 1,convertedData[2] );
        return cal;
    }



    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return  lastName + ' ' +
                name + ' ' +
                surName + ' ' +
                dateFormat.format(birthDay.getTime()) + ' ' +
                age + ' ' +
                city + ' '
                ;
    }

    public int getId() {
        return id;
    }





}
