//В файле содержится строка с исходными данными в такой форме:
// {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
// Требуется на её основе построить и вывести на экран новую строку, в форме SQL запроса:
// SELECT * FROM students WHERE name = "Ivanov" AND country = "Russia" AND city = "Moscow"
// Для разбора строки используйте String.split. Сформируйте новую строку, используя StringBuilder.
// Значения null не включаются в запрос.


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


class Main
{
    public static void main(String[] args)
    {
        File dataFile = new File("C:\\Users\\andre\\Desktop\\Java_sem_hw_2\\task1\\src\\data.txt");
        StringBuilder sqlQuery = new StringBuilder();

        try
        {
            BufferedReader br = new BufferedReader(new FileReader(dataFile));
            String line;

            while ((line = br.readLine()) != null)
            {
                String[] strings = line.split(",|:|\\s");
                for (String string : strings)
                    sqlQuery.append(string);
            }
            StringBuffer strBuffer = new StringBuffer(sqlQuery);
            strBuffer.replace(0,7,"SELECT * FROM students WHERE name = ");
            strBuffer.replace(44,53," AND country = ");
            strBuffer.replace(67,73," AND city = ");
            strBuffer.replace(87,100," ");
            System.out.println(strBuffer);
            br.close();

        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}



