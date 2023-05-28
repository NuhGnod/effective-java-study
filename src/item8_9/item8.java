package item8_9;

import java.io.*;

public class item8 {


    public static void main(String[] args) throws Exception {
//        String firstLine = new Finalizable().readFirstLine();
//        System.out.println("firstLine = " + firstLine);
////        assertEquals("baeldung.com", firstLine);
//        System.gc();
        runTry_With_Resources();
    }
    static void runTry_With_Resources() throws Exception {

        try (AutoClose auto = new AutoClose()) {
            auto.task();
        } finally {
//            if(br2 != null){
//                System.out.println("not null");
//            }else {
//                System.out.println("NULL");
//            }
//            br.close(); //물리적 예외 -> br.close예외 가 더 나중에 발생 -> br.readLine()예외를 집어 삼킴
            // -> 로그 스택에 남지 않는다?
        }
//        finally {
//            br.close(); //물리적 예외 -> br.close예외 가 더 나중에 발생 -> br.readLine()예외를 집어 삼킴
//            // -> 로그 스택에 남지 않는다?
//        }

//        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
//            return br.readLine();
//        } catch (IOException e) {
//            return "null!@!!@";
//        }
//        BufferedReader br = new BufferedReader(new FileReader(path));
//        return br.readLine();
    }
}

class Finalizable {
    private BufferedReader reader;

    public Finalizable() throws FileNotFoundException {

        InputStream input = new FileInputStream("src/item8_9/file.txt");
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
//            int arr[] = new int[10];
//            arr[100]  =123;
        } catch (Exception e) {
            System.out.println("e = " + e);
        }
        super.finalize();
    }
}