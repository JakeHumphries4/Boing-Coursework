public class testFile {
    public static void main(String[] args) {
        Queue queue = (ReadShapeFile.readDataFile("ExampleShapes.txt"));
        queue.print();
    }
}
