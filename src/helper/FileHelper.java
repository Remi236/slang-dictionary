package helper;

import entities.SlangEntity;
import config.*;
import java.io.*;
import java.util.ArrayList;

public class FileHelper {
    FileWriter fileWriter = null;
    BufferedReader br = null;

    public ArrayList<SlangEntity> readDataFromFile(String path) throws Exception {
        ArrayList<SlangEntity> ds = new ArrayList<SlangEntity>();
        try {
            String line;
            br = new BufferedReader(new FileReader(path));
            if(br.read() != -1) {
                String headerLine = br.readLine();
                while ((line = br.readLine()) != null) {
                    String[] row = line.split(Config.PROPERTY_SEPARATOR);
                    SlangEntity sData = new SlangEntity(row[0], row[1]);
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

    public void writeDataToFile(String path, ArrayList<SlangEntity> studentsArray) throws Exception {
        try {
            fileWriter = new FileWriter(path);
            for (SlangEntity s : studentsArray) {
                fileWriter.append(s.toString());
                fileWriter.append(Config.NEW_LINE_SEPARATOR);
            }
            System.out.println("data was write to file successfully !!!");
        } catch (Exception e) {
            System.out.println("Error in write file !!!");
            e.printStackTrace();
        } finally {
            if(fileWriter != null) {
                fileWriter.flush();
                fileWriter.close();
            }
        }
    }
}
