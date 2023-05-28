package item8_9;

public class AutoClose implements AutoCloseable {
    public void task(){
        System.out.println("some task~");
    }
    @Override
    public void close() throws Exception {
        System.out.println("auto close");
    }
}
