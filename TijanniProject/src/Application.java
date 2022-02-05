import java.io.*;
import java.nio.file.FileVisitResult;
import java.util.ArrayList;
import java.util.Arrays;

public class Application {

    static ArrayList<String>   classrooms = new ArrayList<>();
    static ArrayList<String>   supervisors = new ArrayList<>();
    static ArrayList<String>   exams = new ArrayList<>();
    static File    classroomsFile = new File("/Users/aabdelaziz/Desktop/classrooms.txt");
    static File    supervisorFile = new File("/Users/aabdelaziz/Desktop/supervisors.txt");
    static File    examsFile = new File("/Users/aabdelaziz/Desktop/exams.txt");

    public static void readListFromFile(ArrayList<String>   arr, File file) {
        if (file.isFile() && file.canRead()) {
            try {
                FileReader input = new FileReader(file);
                BufferedReader bReader = new BufferedReader(input);
                while (true) {
                    String line = bReader.readLine();
                    if (line == null)
                        break;
                    else
                        arr.add(line);
                }
                input.close();
                bReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void printSupervisorsPerClassroom(){
        int             start = 0;
        Surveillance    s;
        String[]        names;
        int             k = 0;

        for (int i = 0; i < exams.size(); i++){
            System.out.println("exam" + (i + 1) + " information:*****************************************************");
            for (int j = 0; j < classrooms.size(); j++){
                int nextIndex;
                if (k == supervisors.size())
                    k = 0;
                if (k == supervisors.size() - 1)
                    nextIndex = 0;
                else
                    nextIndex = k + 1;
                names = new String[]{supervisors.get(k), supervisors.get(nextIndex)};
                s = new Surveillance(classrooms.get(j), names, exams.get(i));
                System.out.println(s);
                k += 2;
                if (nextIndex == 0)
                    k = 1;
            }
            if (k == supervisors.size())
                k = 0;
        }
    }

    public static void main(String[] args){
        readListFromFile(supervisors, supervisorFile);
        readListFromFile(classrooms, classroomsFile);
        readListFromFile(exams, examsFile);
        //System.out.println(supervisors);
        printSupervisorsPerClassroom();
    }
}
