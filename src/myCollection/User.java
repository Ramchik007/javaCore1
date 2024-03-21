package myCollection;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class User {
    private final int id;
    private String name,lastName,surName;
    private Calendar birthDay;
    private int age;
    private String city;
    static int incId = 1;


    User(int id, String name, String lastName, String surName, String birthDay, String city) {
        this.id = incId;
        this.name = name;
        this.lastName = lastName;
        this.surName = surName;
        this.birthDay = convertDate(birthDay);
        this.age = calculateAge();
        this.city = city;
        incId++;

    }


    public Calendar convertDate(String date) {
        Calendar cal = new GregorianCalendar();
        String[] findDate = date.split("\\.");

        //переделать

        int[] convertedData = new int[3];
        for (int i = 0,j = 2; i < findDate.length; i++,j--) {
            convertedData[j] = Integer.parseInt(findDate[i]);
        }
        cal.set(convertedData[0],convertedData[1] - 1,convertedData[2]);
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


    public int calculateAge() {
        Calendar userBirthday = this.birthDay;
        Calendar currentDate = new GregorianCalendar();
        int age = 0;
        if(userBirthday.get(Calendar.MONTH) < currentDate.get(Calendar.MONTH))
        {
                age = currentDate.get(Calendar.YEAR) - userBirthday.get(Calendar.YEAR);
        }
        else if(userBirthday.get(Calendar.MONTH) == currentDate.get(Calendar.MONTH)) {
            if(userBirthday.get(Calendar.DAY_OF_MONTH) < currentDate.get(Calendar.DAY_OF_MONTH)) {
                age = currentDate.get(Calendar.YEAR) - userBirthday.get(Calendar.YEAR);
            }
        }
        else {
            age = currentDate.get(Calendar.YEAR) - userBirthday.get(Calendar.YEAR) - 1;
        }
        return age;
    }

    //getters
    public String getBirthDay() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return dateFormat.format(birthDay.getTime());
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSurName() {
        return surName;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

}
