import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
/*
21 задание
Вводится массив целых чисел. Найти самую длинную подпоследовательностей подряд идущих элементов массива,
которые в сумме дают 0 (реализовать функцию, которая будет возвращать позицию первого элемента такой
подпоследовательности и кол-во элементов). В случае нескольких таких подпоследовательностей
найти вторую слева (от начала массива). В случае, если таких подпоследовательностей не существует,
функция должна возвращать в качестве первого элемента подпоследовательности -1.
5 -5 5 -5 0 7 -7 7 -7 7 -7 7 -7
5 -5 0 1000 7 -7 7 -7
5 -5 5 -5 100000  8 -8 8 -8
3 3 3 3 3 3 3 3 3 -27 7
5 6 7 -18 9 11 -25 5 3
 */

public class Main {
    public static void LenthAndFirstMember(int[] rabochi) {
        int firstmember = 0;
        int finishcnt = 0;
        int fixcnt = 0;
        int finishmember = 0;
        for(int i =0; i < rabochi.length; i++){
            int cnt = 1;
            int sum = rabochi[i];
            for(int j = i + 1; j < rabochi.length; j++ ){
                sum += rabochi[j];
                cnt++;
                if(sum == 0){
                    firstmember = rabochi[i];
                    fixcnt = cnt;
                }
            }
            if (finishcnt <= fixcnt){
                finishcnt = fixcnt;
                finishmember = firstmember;
            }
        }
        System.out.println(finishcnt);
        System.out.println(finishmember);
    }
    public static void main( String[] args ) throws FileNotFoundException {
        File file = new File("C:\\Users\\shish\\OneDrive\\Рабочий стол\\Текстовый документ.txt");
        Scanner ss = new Scanner(file);
        String line = ss.nextLine();// считываем первую и единственную строчку в файле
        String[] ishodnimassiv = line.split(" ");
        int[] rabochi = new int[ishodnimassiv.length];// делаем интовый массив с такой же длинной
        for (int i = 0; i<rabochi.length;i++){
            double d = Double.parseDouble(ishodnimassiv[i]);// сначала в добл а потом в инт
            rabochi[i]= (int)d;
        }
        //int count = ss.nextInt();
        //int ishodnimassiv[] = new int[count];
        //for (int i = 0; i < count; i++) {
            //ishodnimassiv[i] = ss.nextInt();
        //}
        LenthAndFirstMember(rabochi);
    }
}
