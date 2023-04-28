package org.example;

public class FunctionAsData {
    protected static class Employee
    {
        private String name;
        private Integer age;

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        public Employee(String name, Integer age)
        {
            this.name=name;
            this.age=age;
        }

    }

    private static class DataLoader
    {
        final private  NoArgFunction<Employee> load;

        public DataLoader(boolean isDev)
        {
            load = isDev ? this::loadDevData : this::loadProdData;
        }

        private Employee loadProdData(){
            System.out.println("Loading Prod ready data....");
            return new Employee("Sabarish" ,23);
        }
        private Employee loadDevData()
        {
            System.out.println("Loading Dev Data....");
            return new Employee("ROBO_1", -2);
        }

    }

    public static void main(String[] args) {
        boolean isDevData = true;

        DataLoader dataLoader = new DataLoader(isDevData);
        System.out.println(dataLoader.load.apply().getName());
        System.out.println(dataLoader.load.apply().getAge());
    }
}
