package dataSet;

import org.apache.flink.api.java.ExecutionEnvironment;

public class File {

    public static void main(String[] args) {

        final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        env.readCsvFile("D:\\springbootProject\\flink\\src\\main\\resources").types(String.class, Integer.class);
        //env.map().print();
    }
}
