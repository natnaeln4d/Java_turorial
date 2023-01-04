package com.example.exam_practices;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Group root=new Group();
        Scene scene = new Scene(root);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        tryoutput();
        trybufferinput();
        trybufferoutput();
        trybufferedIO();
        testEncoder();
        testreadEncoider();



    }
    public void tryoutput(){
        String data="hello from other side";
        byte[] buffer=data.getBytes();
        File file=new File("/Users/natnaelgetachew/IdeaProjects/PraticeForExam/file2.txt");
       try {
           OutputStream ow=new FileOutputStream(file);
           ow.write(buffer);
           ow.close();


       }catch (IOException E)
       {
           System.out.println(E);
       }
    }
    public void trybufferinput(){
        File file=new File("/Users/natnaelgetachew/IdeaProjects/PraticeForExam/file2.txt");
        BufferedInputStream bin=null;
        try {
            FileInputStream fileInputStream=new FileInputStream(file);
           bin=new BufferedInputStream(fileInputStream);

            byte[] contents = new byte[1024];
            int bytesRead = 0;
            String content;
            while ((bytesRead = bin.read(contents)) != -1) {
                content = new String(contents, 0, bytesRead);
                System.out.print(content);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found" + e);
        } catch (IOException e) {
            System.out.println("Exception while reading the file " + e);
        }
    }
    public void trybufferoutput(){
        try{
//            String data="hello from other side of buffered output";
//   File file=new File("/Users/natnaelgetachew/IdeaProjects/PraticeForExam/file.txt");
//            OutputStream op=new FileOutputStream(file);
//            BufferedOutputStream bo=new BufferedOutputStream(op);
//            byte[] buffer=data.getBytes();
//            bo.write(buffer);
//            bo.flush();
//            bo.close();
//            String source = "Now is the time for all good men\n"
//                    + " to come to the aid of their country\n"
//                    + " and pay their due taxes.";
//            FileWriter ff = new FileWriter("filllle.txt");
//            BufferedWriter bw=new BufferedWriter(ff);
//            bw.write(source);
//            ff.close();
            String pm = "እልፍ ከሲታዎች ቀጥነዉ የሞገጉ" +
                    " ሥጋችን የት ሄደ ብለዉ ሲፈልጉ\n" +
                    "በየሸንተረሩ በየጥጋጥጉ" +
                    "አሥሠዉ አሥሠዉ በምድር በሰማይ" +
                    "አገኙት ቦርጭ ሆኖ በአንድ ሰዉ ገላ ላይ ";

            OutputStream output  = new FileOutputStream("poem.txt");
            Writer outputStreamWriter = new OutputStreamWriter(output, "utf-8");
            outputStreamWriter.write(pm);
            outputStreamWriter.close();



        }
        catch (FileNotFoundException e) {
            System.out.println("File not found" + e);
        } catch (IOException e) {
            System.out.println("Exception while reading the file " + e);
        }

    }
    public void trybufferedIO(){
        try {
            File file=new File("/Users/natnaelgetachew/IdeaProjects/PraticeForExam/file.txt");
            FileInputStream ip=new FileInputStream(file);
            FileOutputStream io=new FileOutputStream("file copy.txt");
            BufferedInputStream bip=new BufferedInputStream(ip);
            BufferedOutputStream bop=new BufferedOutputStream(io);

            byte[] contents = new byte[1024];

            while ((bip.read(contents)) != -1) {
                bop.write(contents);
            }
            System.out.println("File copied successfully");
            bop.flush();
            ip.close();
            io.close();
            bop.close();

            bip.close();


        }
        catch (FileNotFoundException e){
            System.out.println(e);
        }catch (IOException F){
            System.out.println(F);
        }
    }
    public void testreadEncoider(){
        try {
            InputStream Ip=new FileInputStream("poem.txt");
            Reader InputStreamReader=new InputStreamReader(Ip,"utf-8");
            int data;
            while ((data=InputStreamReader.read())!=-1){
                System.out.println((char)data);

            }
            InputStreamReader.close();

        }
        catch (FileNotFoundException F){
            System.out.println(F);
        }
        catch (IOException E){
            System.out.println(E);
        }
    }

    public  void  testEncoder(){
        try {
            OutputStream outputStream  = new FileOutputStream("output.txt");
            Writer outputStreamWriter = new OutputStreamWriter(outputStream);
            outputStreamWriter.write("Hello World");
            outputStreamWriter.close();
        }catch (FileNotFoundException E){
            System.out.println(E);
        }
        catch (IOException D){
            System.out.println(D);
        }
    }

    

    public static void main(String[] args) {
        launch();
    }
}