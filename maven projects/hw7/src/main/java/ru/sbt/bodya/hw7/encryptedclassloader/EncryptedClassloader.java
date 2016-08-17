package ru.sbt.bodya.hw7.encryptedclassloader;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class EncryptedClassloader extends ClassLoader {

    private final String key;

    private final File dir;


    public EncryptedClassloader(String key, File dir, ClassLoader parent) {

        super(parent);

        this.key = key;

        this.dir = dir;

    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        Path filePath = Paths.get(dir.getPath() + "/" + name);
        System.out.println(filePath);
        byte[] bytes;
        try {
            bytes = Files.readAllBytes(filePath);
            OutputStream tmpOutputStream = tmpOutputStream = new FileOutputStream("/Users/bogdanpopov/Desktop/Sbertechnology/maven projects/hw7/src/main/resources/file2.txt");

            int key = this.key.length();

            for (int i = 0; i < bytes.length; i++) {

                tmpOutputStream.write(bytes[i]);

                bytes[i] = (byte) (bytes[i] - 1);
            }

            tmpOutputStream.close();

        } catch (IOException e) {
            throw new RuntimeException("Error", e);
        }


        return defineClass(name, bytes, 0, bytes.length);
    }


    public static void encrypt(String path) {

        try {


            InputStream inputStream = new FileInputStream(path);
            OutputStream tmpOutputStream = new FileOutputStream("/Users/bogdanpopov/Desktop/Sbertechnology/maven projects/hw7/src/main/resources/file.txt");

            for (int b = inputStream.read(); b >= 0; b = inputStream.read()) {
                tmpOutputStream.write(b + 1);
            }

            tmpOutputStream.close();
            inputStream.close();

            InputStream tmpInputStream = new FileInputStream("/Users/bogdanpopov/Desktop/Sbertechnology/maven projects/hw7/src/main/resources/file.txt");
            OutputStream outputStream = new FileOutputStream(path);

            for (int b = tmpInputStream.read(); b >= 0; b = tmpInputStream.read()) {

                outputStream.write(b);

            }

            tmpInputStream.close();

            outputStream.close();


        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private static int fib(int n) {

        return fibIter(1, 0, n);

    }

    private static int fibIter(int a, int b, int count) {

        return count == 0 ? b : fibIter(a + b, a, count - 1);

    }

    public static void main(String[] args) {

        encrypt("/Users/bogdanpopov/Desktop/testingSomeShit/Main.class");

        EncryptedClassloader encryptedClassloader = new EncryptedClassloader("String", new File("/Users/bogdanpopov/Desktop/testingSomeShit/"), ClassLoader.getSystemClassLoader());

        try {
            encryptedClassloader.findClass("Main");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

}