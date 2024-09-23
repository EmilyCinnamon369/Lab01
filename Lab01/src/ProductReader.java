import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ProductReader {

    public static void main(String[] args)
    {

        File workingDirectory = new File(System.getProperty("user.dir"));
        File jfcFile = new File(workingDirectory.getPath() + "\\src\\ProductTestData.txt");
        JFileChooser jfc = new JFileChooser(jfcFile, FileSystemView.getFileSystemView());

        ArrayList<String> Product = new ArrayList<>();

        jfc.showOpenDialog(null);

        System.out.println(jfc.getSelectedFile());

        try {
            String content = new String(Files.readAllBytes(Paths.get(jfc.getSelectedFile().getAbsolutePath())));
            String content2 = content.replaceAll("[\\r\\n]+", "");
            String content4 = content.replaceAll(",", "");
            String[] content3 = content4.split("\\s");

            for (String x : content3)
            {
                Product.add(x);
            }

            System.out.printf("%-10s %-10s %-10s %-10s%n", "ID", "Name", "Description", "Cost");
            System.out.println("-----------------------------------------------------------------");
            for (int i = 0; i < Product.size(); i+=4)
            {
                System.out.printf("%-10s %-10s %-10s %-10s%n", Product.get(i), Product.get(i+1), Product.get(i+2), Product.get(i+3));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
