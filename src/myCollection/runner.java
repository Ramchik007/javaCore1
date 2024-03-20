package myCollection;



import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class runner {
    public static void main(String[] args) {
        IdentityHashMap<Integer, User> Users = new IdentityHashMap<>();

        User Ram = new User(User.incId,"Ram","Fatykhov","Ildusovich",
                "22.08.1989",34,"Moscow");
        User Zilya = new User(User.incId,"Zilya","Fatykhova","Linarovna",
                "26.02.1992",30,"Kazan");
        Users.put(Ram.getId(),Ram);
        Users.put(Zilya.getId(),Zilya);

        //selectSomeUsers(Users,1,1);
        //selectSomeUsers(Users,"Fat");
        showCityList(Users);



    }


    public static void selectAllUsers(IdentityHashMap<Integer,User> Users)
    {
        for (Map.Entry<Integer, User> entry:Users.entrySet()) {
            System.out.print(entry.getKey() + ":");
            System.out.println(entry.getValue());
        }
    }


    public static void selectSomeUsers(IdentityHashMap<Integer,User> Users,int start,int end)
    {
        IntStream intStream = IntStream.range(start, end + 1);
        List<Integer> list = intStream.boxed().toList();

        for (Map.Entry<Integer, User> entry:Users.entrySet()) {
            if( list.contains(entry.getKey())) {
                System.out.print(entry.getKey() + ":");
                System.out.println(entry.getValue());
            }

        }
    }


    public static void selectSomeUsers(IdentityHashMap<Integer,User> Users,String lastName) {
        String template = ".*"+ lastName +".*";

        for (Map.Entry<Integer, User> entry:Users.entrySet()) {
            if(entry.getValue().lastName.matches(template)) {
                System.out.print("Founded user: ");
                System.out.println(entry.getValue());
            }
        }
    }

    public static void showCityList(IdentityHashMap<Integer,User> Users) {
        List<String> cities = new ArrayList<>();
        for (Map.Entry<Integer, User> entry:Users.entrySet()) {
            if (!cities.contains(entry.getValue().city))
                 cities.add(entry.getValue().city);
            }
        for (String city : cities) {
            System.out.print(city + " ");
        }
    }







}
