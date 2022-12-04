// Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.


import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;


class Main
{
    public static void main(String[] args)
    {
        int [] array = {23, 14, 166, 1, 16, 4, 105};
        boolean isSorted = false;
        int temp;
        Logger logger = Logger.getLogger("task2");
        try
        {
            FileHandler handler = new FileHandler("task2.log", false);
            logger.addHandler(handler);

        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        while(!isSorted)
        {
            isSorted = true;
            for (int i = 0; i < array.length-1; i++)
            {
                if(array[i] > array[i+1])
                {
                    isSorted = false;

                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
                logger.log(Level.INFO, "msg"+ array[i]);
                logger.log(Level.INFO, "msg"+ array[array.length - 1]);
            }
        }
        System.out.println(Arrays.toString(array));
    }
}