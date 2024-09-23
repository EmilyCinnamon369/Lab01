import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import java.util.ArrayList;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PersonReader {

    static ArrayList<String[]> Person = new ArrayList<>();

    public static void main(String[] args)
    {

        File workingDirectory = new File(System.getProperty("user.dir"));
        File jfcFile = new File(workingDirectory.getPath() + "\\src\\PersonTestData.txt");
        JFileChooser jfc = new JFileChooser(jfcFile, FileSystemView.getFileSystemView());

        ArrayList<String> Person = new ArrayList<>();

        jfc.showOpenDialog(null);

        try {
            String content = new String(Files.readAllBytes(Paths.get(jfc.getSelectedFile().getAbsolutePath())));
            String content2 = content.replaceAll("[\\r\\n]+", "");
            String content4 = content.replaceAll(",", "");
            String[] content3 = content4.split("\\s");

            for (String x : content3)
            {
                Person.add(x);
            }



            System.out.printf("%-10s %-15s %-15s %-15s %-15s%n", "ID", "First Name", "Last Name", "Title", "YOB");
            System.out.println("-----------------------------------------------------------------");
            for (int i = 0; i < Person.size(); i+=5)
            {
                System.out.printf("%-10s %-15s %-15s %-15s %-15s%n", Person.get(i), Person.get(i+1), Person.get(i+2), Person.get(i+3), Person.get(i+4));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
