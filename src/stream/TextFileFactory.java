package stream;

import customer.Customer;
import dateConvert.ConvertDate;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class TextFileFactory {
    public static boolean saveFile(ArrayList<Customer> list, String filePath){
        try{
            FileOutputStream fos = new FileOutputStream( filePath, true);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);
            for (Customer kh: list
                 ) {
                String line = kh.getName()+ ";" +kh.getId() + ";"+ ConvertDate.toString(kh.getBirthDay()) ;
//                String line1 = kh.toString();
                bw.write(line);
                bw.newLine();
            }
            bw.close();
            osw.close();
            fos.close();

            return true;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public static ArrayList<Customer> readFile(String filePath){
        ArrayList<Customer> readList = new ArrayList<>();

        try{
            FileInputStream fis = new FileInputStream(filePath);
            InputStreamReader ipr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new LineNumberReader(ipr);

            String line = br.readLine();

            while (line!=null){
                Customer inputCustomer = new Customer();
                Date inputDate = new Date();
                String[] infomation = line.split(";");
                if(infomation.length ==3){
                    inputCustomer.setName(infomation[0]);
                    inputCustomer.setId(infomation[1]);
                    inputDate=ConvertDate.toDate(infomation[2]);
                    inputCustomer.setBirthDay(inputDate);

                    readList.add(inputCustomer);
                }

                line = br.readLine();
            }
            br.close();
            ipr.close();
            fis.close();
            return readList;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
