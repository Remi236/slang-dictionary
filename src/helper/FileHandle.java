package helper;
import entities.StudentEntitiy;

import java.io.*;
import java.util.ArrayList;

public class FileHandle {
    ObjectInputStream ois = null;
    ObjectOutputStream oos = null;

    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    // CSV file header
    private static final String FILE_HEADER = "id,name,point,address,note";

    public ArrayList<StudentEntitiy> readObjFromFile(String path) throws Exception {
        ArrayList<StudentEntitiy> ds = null;
        try {

            FileInputStream fis = new FileInputStream(new File(path));
//            int b = fis.read();
            if (fis.getChannel().size() == 0) // check file empty
            {
                ds = new ArrayList<StudentEntitiy>();
            }
            else {
                ois = new ObjectInputStream(fis);
                ds = (ArrayList<StudentEntitiy>)ois.readObject();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (ois != null)
            {
                ois.close();
                System.out.println("Success read data from file ...");
            }
        }
        return ds;
    }

    public void writeObjToFile(String path, ArrayList<StudentEntitiy> studentsArray) throws Exception {
        try {
            oos = new ObjectOutputStream(new FileOutputStream(path));
            oos.writeObject(studentsArray);
            oos.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            oos.close();
            System.out.println("Success write data to file ...");
        }
    }

    public ArrayList<StudentEntitiy> importCSVFile(String path) throws Exception {
        BufferedReader br = null;
        ArrayList<StudentEntitiy> ds = new ArrayList<StudentEntitiy>();
        try {
            String line;
            br = new BufferedReader(new FileReader(path));

            // How to read file in java line by line?
            if(br.read() != -1) {
                String headerLine = br.readLine();
                while ((line = br.readLine()) != null) {
                    String[] row = line.split(",");
                    StudentEntitiy sData = new StudentEntitiy(row[0], row[1], Float.parseFloat(row[2]), row[3], row.length < 5 ? "": row[4]);
                    ds.add(sData);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                br.close();
                System.out.println("Success read data from file ...");
            }
        }
        return ds;
    }

    public void exportCSVFile(String path, ArrayList<StudentEntitiy> studentsArray) throws Exception {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(path);
            // Write the CSV file header
            fileWriter.append(FILE_HEADER);
            // Add a new line separator after the header
            fileWriter.append(NEW_LINE_SEPARATOR);

            // Write a new Country object list to the CSV file
            for (StudentEntitiy s : studentsArray) {
                fileWriter.append(s.toString());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }

            System.out.println("CSV file was created successfully !!!");

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
            if(fileWriter != null) {
                fileWriter.flush();
                fileWriter.close();
            }
        }
    }
}
