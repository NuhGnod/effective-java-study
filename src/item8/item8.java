package item8;

import java.io.*;

public class item8 {


    public static void main(String[] args) throws IOException {
        String firstLine = new Finalizable().readFirstLine();
        System.out.println("firstLine = " + firstLine);
//        assertEquals("baeldung.com", firstLine);
        System.gc();
    }
}

class Finalizable {
    private BufferedReader reader;

    public Finalizable() throws FileNotFoundException {

        InputStream input = new FileInputStream("src/item8/file.txt");
        this.reader = new BufferedReader(new InputStreamReader(input));
    }

    public String readFirstLine() throws IOException {
        String firstLine = reader.readLine();
        return firstLine;
    }

    @Override
    protected void finalize() throws Throwable {
        try {
            reader.close();

            System.out.println("Closed BufferedReader in the finalizer");
//            throw new RuntimeException("일부로.");
            int arr[] = new int[10];
            arr[100]  =123;
        } catch (Exception e) {
            System.out.println("e = " + e);
        }
        super.finalize();
    }
}