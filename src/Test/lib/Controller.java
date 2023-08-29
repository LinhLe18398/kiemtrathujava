package Test.lib;

import java.sql.SQLException;
import java.util.Scanner;

public class Controller {
    public static void main(String[] args) throws SQLException {
        ChucNang chucNang = new ChucNang();
        while (true) {
            System.out.println("1.select all data");
            System.out.println("2.add data");
            System.out.println("3.delete data");
            System.out.println("4.search data");
            System.out.println("5.Exit");
            System.out.println("------------------------------");

            Scanner scanner = new Scanner(System.in);
            System.out.println("chon chuc nang: ");
            int inputNumber = scanner.nextInt();

            switch (inputNumber) {
                case 1:
                    chucNang.getAllData();
                    break;
                case 2:
                    Teacher newTeacher = addNewData();
                    ChucNang.insertData(newTeacher);
                    System.out.println("them thanh cong");
                    break;

                case 3:
                    Scanner scanner2 = new Scanner(System.in);
                    System.out.println("enter delete");
                    int delete = scanner2.nextInt();
                    ChucNang.deleteDataId(delete);
                    break;
            }
        }
    }


    public static Teacher addNewData() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Input name: ");
        String name = scanner.nextLine();

        System.out.println("Input gender: ");
        Boolean gender = scanner.nextBoolean();

        System.out.println("Input age: ");
        int age = scanner.nextInt();

        scanner.nextLine();
        System.out.println("Input address: ");
        String address = scanner.nextLine();

        Teacher newTeacher = new Teacher(id, name, gender, age, address);
        return newTeacher;
    }
}
