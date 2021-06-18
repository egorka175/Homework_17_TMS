package com.tms.Homework_17_TMS;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MetodsForCreatingTheFile {
    public File pathValidation() {
        File rez = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("____________________________________________________");
        System.out.print("Введите путь к папке: ");
        String filePath = sc.nextLine();
        System.out.println("____________________________________________________");
        File fileBeingChecked = new File(filePath);
        if (fileBeingChecked.isDirectory() && fileBeingChecked.list().length != 0) {
            File[] arrayPathFile = fileBeingChecked.listFiles();
            for (File item : arrayPathFile) {
                if (item.getName().endsWith(".xml")) {
                    rez = item;
                    break;
                }
                if (item.isDirectory()) {
                    File[] arrayPathFile2 = item.listFiles();
                    for (File item2 : arrayPathFile2) {
                        if (item2.getName().endsWith(".xml")) {
                            rez = item2;
                            createFile(createNameFile(rez));
                            break;
                        }
                    }
                }
            }
        }
        else {
            System.out.println("Папка пуста!");
        }
            return rez;
        }
        //Метод который считывает информацию из тегов XML документа и на основе этой информации
        //генерирует путь к новому файлу для дальнейшего его создания.
        private String createNameFile(File file) {
            List<Author> author = new ArrayList<>();
            String lastName2 = null;
            String firstName2=null;
            String title2=null;
            final String lastName = "lastName";
            final String firstName = "firstName";
            final String title = "title";
            try {
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document document = builder.parse(file);
                NodeList elements = document.getElementsByTagName(lastName);
                NodeList elements2 = document.getElementsByTagName(firstName);
                NodeList elements3 = document.getElementsByTagName(title);
                // Перебор всех найденных элементов
                for (int i = 0; i < elements.getLength(); i++) {
                    Node line = elements.item(i);
                    Node line2 = elements2.item(i);
                    Node line3 = elements3.item(i);
                    if (line.getNodeType() == Node.ELEMENT_NODE) {
                        Element eElement = (Element) line;
                        Element eElement2 = (Element) line2;
                        Element eElement3 = (Element) line3;
                        lastName2 = eElement.getTextContent();
                        firstName2 = eElement2.getTextContent();
                        title2 = eElement3.getTextContent();
                        author.add(new Author(lastName2, firstName2, title2));
                    }
                }
            } catch (ParserConfigurationException parserConfigurationException) {
                parserConfigurationException.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (SAXException saxException) {
                saxException.printStackTrace();
            }
            String rez= "C:"+File.separator+"Users"+File.separator+"User"+File.separator+"IdeaProjects"+File.separator+"p1"+File.separator+"src"+File.separator+"com"+File.separator+"tms"+File.separator+"Homework_17_TMS"+File.separator  + lastName2 +  "_"  + firstName2 +  "_" +  title2  + ".txt";
            return rez;
        }
        //Создает файл по пути , переданному в параметры метода.
        private void createFile(String str){
        try{
           File myFile=new File(str);
            if(myFile.createNewFile()){
                System.out.println("Файл- " +str+"  создан");
            }
            else {
                System.out.println("Такой файл уже существует! ");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        }
        }

