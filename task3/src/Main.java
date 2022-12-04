//В файле содержится строка с данными:
// [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
// {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
// {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
// Напишите метод, который разберёт её на составные части и, используя StringBuilder создаст массив строк такого вида:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


class Main
{
    public static void main(String[] args)
    {
        stringReconstructor();
    }


    public static void stringReconstructor()
    {
        File dataFile = new File("C:\\Users\\andre\\Desktop\\Java_sem_hw_2\\task3\\src\\data.txt");
        StringBuilder text = new StringBuilder();
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(dataFile));
            String line;
            while ((line = br.readLine()) != null)
            {
                String[] strings = line.split(",|:|\\s|]|}");
                text.append("Студент " + strings[1] + " получил " + strings[3] + " по предмету " + strings[5] + "." + "\n");
            }
            System.out.println(text);
            br.close();
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}