package org.example;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamExercise {
    static class Person {
        public final String name;
        public final Integer age;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
    }

    static class Car {
        public final String make;
        public final String color;
        public final Float price;

        public Car(String make, String color, Float price) {
            this.make = make;
            this.color = color;
            this.price = price;
        }
    }

    static class Employee {
        public final String name;
        public final Integer age;
        public final String jobTitle;
        public final Float salary;

        public Employee(String name, Integer age, String jobTitle, Float salary) {
            this.name = name;
            this.age = age;
            this.jobTitle = jobTitle;
            this.salary = salary;
        }
    }

    public static void main(String[] args) {
        Person[] peopleArr = {
                new Person("Brandon", 23),
                new Person("Hank", 43),
                new Person("Jenna", 33),
                new Person("Veronica", 56),
                new Person("Jack", 27),
        };
        List<Person> people = new ArrayList<>(Arrays.asList(peopleArr));

        // Answer 1 goes here  ; print only names of Person
       // System.out.println(people);
        Function<Person, String> personName = (x) -> x.name;

        var outputNames = people.stream().
                map(personName).
                toList();
        System.out.println(outputNames);

        Car[] carsArr = {
                new Car("Chevy", "red", 45000f),
                new Car("Ford", "blue", 23000f),
                new Car("Toyota", "grey", 14000f),
                new Car("Lamborghini", "blue", 150000f),
                new Car("Renault", "blue", 150000f),
        };
        List<Car> cars = new ArrayList<>(Arrays.asList(carsArr));

        // Answer 2 goes here, display car name which has blue color
       // System.out.println(cars);
        var blueCarDetails = cars.stream().filter(x -> x.color.equals("blue")).toList();
        System.out.println(blueCarDetails.stream().map(x-> x.make).collect(Collectors.joining(", ")));


        Employee[] employeesArr = {
                new Employee("John", 34, "developer", 80000f),
                new Employee("Hannah", 24, "developer", 95000f),
                new Employee("Bart", 50, "sales executive", 100000f),
                new Employee("Sophie", 49, "construction worker", 40000f),
                new Employee("Darren", 38, "writer", 50000f),
                new Employee("Nancy", 29, "developer", 75000f),
        };
        List<Employee> employees = new ArrayList<>(Arrays.asList(employeesArr));

        // Answer 3 goes here ; sum of all employees.

        var salary = employees.stream().
                map(employee -> employee.salary)
                .reduce(0f,Float::sum);

        System.out.println(salary);

        // avg salary of developers vs others
       // Function<Map<Boolean,List<Employee>>,Float > findSal =

       Predicate<Employee> findDev = employee -> employee.jobTitle.equals("developer");


        var mapDev_NonDev=employees.stream()
                .collect(Collectors.partitioningBy(findDev));


        var dev = mapDev_NonDev.
                get(true)
                .stream()
                .map(employee -> employee.salary)
                .reduce(0f,Float::sum);

        var salaryOther = mapDev_NonDev
                .get(false)
                .stream()
                .map(employee -> employee.salary)
                .reduce(0f,Float::sum);

        var getDevCount =  mapDev_NonDev.get(true)
                .size();

        var getNonDevCount =  mapDev_NonDev.get(false)
                .size();

        System.out.println("Average of Dev "+ dev/ getDevCount);
        System.out.println("Average of non Dev "+ salaryOther/getNonDevCount);



        //optimising the above avg calculatiom\ns

        var optimisedMap = employees
                .stream()
                .collect(Collectors
                        .groupingBy(employee -> employee.jobTitle));

        Float devSalary=0f;
        int countDevs=1;
        for(var x: optimisedMap.keySet())
        {
            if(x.equals("developer"))
            {
                devSalary = optimisedMap.get(x)
                        .stream()
                        .map(employee -> employee.salary)
                        .reduce(0f, Float::sum);

                countDevs = optimisedMap.get(x).size();

            }

        }
        System.out.println("Average Salary of Devs "+  devSalary/countDevs);


        var prof_sal = employees
                .parallelStream()
                .collect(Collectors.groupingBy(employee -> employee.jobTitle))
                .entrySet()
                .parallelStream()
                .collect(Collectors.toMap(
                        (entry) -> entry.getKey(),
                        (entry) -> entry.getValue().stream()
                                .map(val-> val.salary)
                                .reduce(0f,Float::sum) / entry.getValue().size()

                )
        );

        System.out.println(prof_sal);

        //compose function is to combine 2 functions

        //reverse employee name and then apply Upper case

        Function<String , String> reverse = word -> new StringBuilder(word).reverse().toString();
        Function<Employee, String> getEmployeeName = employee -> employee.name;
        Function<String, String> toggle = x-> x.toLowerCase();

        System.out.println(
                reverse.compose(getEmployeeName)
                        .andThen(toggle)
                        .apply(employees.get(0))


        );
        var out = getEmployeeName.andThen(reverse).andThen(toggle).apply(employees.get(1));
        System.out.println(out);


      String name = "sabarish is a sabarish ";

      var nameList = new ArrayList<>(List.of(name.split(" ")));
      Map<String, Integer> patterncount = new HashMap<>();

      for(var x: nameList)
          patterncount.put(x, patterncount.getOrDefault(x,0)+1);

        System.out.println(patterncount);

        String pattern = "abba";
        System.out.println(nameList);
    }
    }
