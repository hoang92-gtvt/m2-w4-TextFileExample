package TestMain;

import customer.Customer;
import stream.TextFileFactory;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Customer> listCustomer= new ArrayList<>();
    static String filePath = "E:\\CONGVIEC\\2021\\MODEL2\\WEEK4\\TextFileExample/demo.txt";

    public static void menu() {

        System.out.println("1: Nhập file");
        System.out.println("2: Xuất file");
        System.out.println("3: Lưu file");
        System.out.println("4: Mở file");
        System.out.println("5: Thoát");
        System.out.println("Bạn muốn gì");
        int inputChoice = new Scanner(System.in).nextInt();
        switch (inputChoice) {
            case 1:
                nhap();
                break;
            case 2:
                xuat();
                break;
            case 3:
                save();
                break;
            case 4:
                open();
                break;
            default:
                System.err.println("Tạm biệt");
                System.exit(0);
                break;


        }


    }

    public static void nhap(){
        System.out.println("Mời bạn nhập tên");
        String name = new Scanner(System.in).nextLine();
        System.out.println("Mời bạn nhập id");
        String id = new Scanner(System.in).nextLine();
        System.out.println("Mời bạn nhập ngày sinh theo định dạng dd/MM/yyyy");
        String brithDay = new Scanner(System.in).nextLine();

        Customer customer = new Customer(name, id, brithDay);
        listCustomer.add(customer);

    }
    public static void xuat(){
        for (Customer c:listCustomer
             ) {
            System.out.println(c);
        }

    }
    public static void save(){
        Boolean value = TextFileFactory.saveFile(listCustomer, filePath);
        if(value){
            System.out.println("Bạn lưu file thành công");
        }else System.out.println("File lưu thất bại");
    }
    public static void open(){
        listCustomer= TextFileFactory.readFile(filePath);
    }

    public static void main(String[] args) {
        open();
        while(true){

            menu();
        }
    }

}
