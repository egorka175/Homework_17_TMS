package com.tms.Homework_17_TMS;

import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class DOMParser implements IParser{
        static List<String> lines = new ArrayList<>();
        @Override
        public List<String> process(File file) {
            try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            NodeList elements = document.getElementsByTagName("line");
            // Перебор всех найденных элементов
            for (int i = 0; i < elements.getLength(); i++) {
                Node line = elements.item(i);
                if (line.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) line;
                    String informationLine = eElement.getTextContent();
                    lines.add(informationLine);
                }
            }
        } catch(ParserConfigurationException e) {
            e.printStackTrace();
        }
            catch(IOException e) {
            e.printStackTrace();
        }
            catch(SAXException e) {
            e.printStackTrace();
        }
        return lines;
        }
        //Метод необходимый для записи информации , извлеченной из XMl документа , в файл-отчет.
        public void writeToFile(List<String> lines){
            Scanner sc=new  Scanner(System.in);
            System.out.println("________________________________________________________________________");
            System.out.print("Введите путь к файлу для записи в него информации: ");
            String path=sc.nextLine();
            try(FileWriter fw=new FileWriter(path)){
                for(String item: lines){
                    fw.write(item);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }





