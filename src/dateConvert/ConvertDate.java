package dateConvert;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertDate {
    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public static Date toDate (String inputDate){

        try{
            Date date = sdf.parse(inputDate);
            return date;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static String toString(Date date){

        return sdf.format(date);
    }
}
