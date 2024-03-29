package com.oseco.basic.nio;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class MappedByteBufferTest {

    private final static String CONTENT = "Zero copy implemented by MappedByteBuffer";
    private final static String FILE_NAME = "/mmap.txt";
    private final static String CHARSET = "UTF-8";

    public static void main(String[] args) {
        Path path = Paths.get(MappedByteBufferTest.class
                .getResource(FILE_NAME)
                .getPath());

        byte[] content = CONTENT.getBytes(Charset.forName(CHARSET));

        try (FileChannel fileChannel = FileChannel.open(path,
                StandardOpenOption.READ,
                StandardOpenOption.WRITE,
                StandardOpenOption.TRUNCATE_EXISTING)) {
            MappedByteBuffer mappedByteBuffer =
                    fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, content.length);
            mappedByteBuffer.put(content);
            mappedByteBuffer.force();
        } catch (IOException ioException) {

        }
    }
}
