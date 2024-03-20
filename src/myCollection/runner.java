package myCollection;


import java.util.*;
import java.util.stream.IntStream;

public class runner {
    public static void main(String[] args) {
        IdentityHashMap<Integer, User> Users = new IdentityHashMap<>();

        User Ram = new User(User.incId,"Ram","Fatykhov","Ildusovich",
                "22.08.1989","Moscow");
        User Zilya = new User(User.incId,"Zilya","Fatykhova","Linarovna",
                "26.02.1992","Kazan");
        User Leila = new User(User.incId,"Leila","Fatykhova","Ramilevna",
                "08.10.2015","Kazan");

        Users.put(Ram.getId(),Ram);
        Users.put(Zilya.getId(),Zilya);
        Users.put(Leila.getId(),Leila);

        /*
        selectUsers(Users,1,1);
        selectUsers(Users,"Ram");
        showCityList(Users);
        selectAllUsers(Users);
        System.out.println(Users.get(1).getBirthDay());
         */
        //System.out.println(Users.get(2).getBirthDay());
        //Ram.calculateAge();
       //selectAllUsers(Users);
       selectUsers(Users,2,5);

    }


    // O(n)
    public static void selectAllUsers(Map<Integer,User> Users)
    {
        for (Map.Entry<Integer, User> entry:Users.entrySet()) {
            System.out.println(entry.getValue());
        }
    }


    //O(1)
    public static void selectUsers(Map<Integer,User> Users,int startId,int endId)
    {
        for (int i = startId; i <= endId ; i++) {
            if(Users.containsKey(i)) {
                System.out.println(Users.get(i).toString());
            }
        }
    }


    public static void selectUsers(Map<Integer,User> Users,String substring) {
        String template = ".*"+ substring +".*";

        for (Map.Entry<Integer, User> entry:Users.entrySet()) {
            if(entry.getValue().getLastName().matches(template)) {
                System.out.print("Founded user: ");
                System.out.println(entry.getValue());
            }
            else if(entry.getValue().getName().matches(template)) {
                System.out.print("Founded user: ");
                System.out.println(entry.getValue());
            }
            else if(entry.getValue().getSurName().matches(template)) {
                System.out.print("Founded user: ");
                System.out.println(entry.getValue());
            }
        }
    }

    public static void showCityList(Map<Integer,User> Users) {
        List<String> cities = new ArrayList<>();
        // можно занести в Set и перебрать в нем
        for (Map.Entry<Integer, User> entry:Users.entrySet()) {
            if (!cities.contains(entry.getValue().getCity()))
                 cities.add(entry.getValue().getCity());
            }
        System.out.print("Cities in collection: ");
        for (String city : cities) {
            if(cities.indexOf(city) == (cities.size() - 1)) {
                System.out.print(city + ".");
            }
            else {
                System.out.print(city + ", ");
            }
        }
        System.out.println();
    }


}
