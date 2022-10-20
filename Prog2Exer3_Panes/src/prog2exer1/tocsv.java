/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2exer1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Iya
 */
public class tocsv{
    //customers                                                                                                 ///variables
    static CustomerForm cusform = new CustomerForm();
    static String[][] customers = new String[cusform.cus.length][cusform.cus[0].length];
    static String[][] cusnew = new String [cusform.cus.length][cusform.cus[0].length];
    //products 2d
    static ProductsWindow prodwin = new ProductsWindow();
    static String[][] prodstbl1 = new String[prodwin.prods.length][prodwin.prods[0].length];
    static String[][] prodstbl1new = new String[prodwin.prods.length][prodwin.prods[0].length];
    //prods 3d
    static String[][][] prodstbl2 = new String[prodwin.prods3d.length][prodwin.prods3d[0].length][prodwin.prods3d[0][0].length];
    static String[][][] prodstbl2new = new String[prodwin.prods3d.length][prodwin.prods3d[0].length][prodwin.prods3d[0][0].length];
    //orders
    static String [][][] orderstbl = new String[cusform.orders3d.length][cusform.orders3d[0].length][cusform.orders3d[0][0].length];
    static String [][][] orderstblnew = new String[cusform.orders3d.length][cusform.orders3d[0].length][cusform.orders3d[0][0].length];
    //count2    
    static int[] counter = new int[prodwin.count2.length];
    static int[] counternew = new int[prodwin.count2.length];
    //costs 
    static int[] costs = new int[3];
    static int[] costsnew = new int[costs.length];
    //deletedID
    static ArrayList<Integer> delID = new ArrayList<Integer>();
    static ArrayList<Integer> delIDnew = new ArrayList<Integer>();
    // customers                                                                                                   ///functions
    public static void customerscsv(){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\AdDU\\College 1st year - 2nd sem\\ComProg\\Exercises\\Java\\database\\customers.csv", false));
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<customers.length;i++){
                for(int j=0;j<customers[0].length;j++){
                    if(customers[i][0] != null){
                        sb.append(customers[i][j]);
                        sb.append(" , ");
                    }
                }
                sb.append("-");
                sb.append(" , ");
            }
            bw.write(sb.toString());
            bw.close();
        }catch(Exception e){
        }
    }
    public static void getcus(){
        for(int i=0;i<customers.length;i++){
            for(int j=0;j<customers[0].length;j++){
                if(cusform.cus[i][0] != null){
                    customers[i][j] = cusform.cus[i][j];
                }
            }
        }
    }
    public static void showcuscsv(){
        String [] cusget = {};
        int index = 0;
        int count = 0;
        try{
            String line;
            BufferedReader br = new BufferedReader(new FileReader("D:\\AdDU\\College 1st year - 2nd sem\\ComProg\\Exercises\\Java\\database\\customers.csv"));
            while((line = br.readLine()) != null){
                cusget = line.split(" , ");
            }
            for(int a=0;a<cusget.length;a++){               //1D to 2D
                if(cusget[a].equals("-")){                  //new row
                    if(index == cusform.cus.length){
                        break;
                    }else{      
                        count = 0;
                        index++;
                        cusnew[index][count] = cusget[a+1];
                    }
                }else{                                      //same row
                    if(count == cusform.cus[0].length){
                        count = 0;
                    }
                    cusnew[index][count] = cusget[a];
                    count++;
                }
            }
        }catch (Exception e){
        }
    }
    //products 2d
    public static void prods2dcsv(){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\AdDU\\College 1st year - 2nd sem\\ComProg\\Exercises\\Java\\database\\prodstable1.csv", false));
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<prodstbl1.length;i++){
                for(int j=0;j<prodstbl1[0].length;j++){
                    if(prodstbl1[i][0] != null){
                        sb.append(prodstbl1[i][j]);
                        sb.append(" , ");
                    }
                }
                sb.append("-");
                sb.append(" , ");
            }
            bw.write(sb.toString());
            bw.close();
        }catch (Exception e){
        }
    }
    public static void getprods2d(){
        for(int i=0;i<prodstbl1.length;i++){
            for(int j=0;j<prodstbl1[0].length;j++){
                if(prodwin.prods[i][0] != null){
                    prodstbl1[i][j] = prodwin.prods[i][j];
                }
            }
        }
    }
    public static void showprods2d(){
        String[] prods2dget = {};
        int index = 0;
        int count = 0;
        try{
            String line;
            BufferedReader br = new BufferedReader(new FileReader("D:\\AdDU\\College 1st year - 2nd sem\\ComProg\\Exercises\\Java\\database\\prodstable1.csv"));
            while((line = br.readLine()) != null){
                prods2dget = line.split(" , ");
            }
            for(int a=0;a<prods2dget.length;a++){               //1D to 2D
                if(prods2dget[a].equals("-")){                  //new row
                    if(index == prodwin.prods.length){
                        break;
                    }else{      
                        count = 0;
                        index++;
//                        prodstbl1new[index][count] = prods2dget[a+1];
                    }
                    continue;
                }else{                                      //same row
                    if(count == prodwin.prods[0].length){
                        count = 0;
                    }
                    prodstbl1new[index][count] = prods2dget[a];
                    count++;
                }
            }
        }catch (Exception e){
        }
    }
    //products 3d
    public static void prods3dcsv(){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\AdDU\\College 1st year - 2nd sem\\ComProg\\Exercises\\Java\\database\\prodstable2.csv", false));
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<prodstbl2.length;i++){
                for(int j=0;j<prodstbl2[0].length;j++){
                    for(int k=0;k<prodstbl2[0][0].length;k++){
                        if(prodstbl2[i][j][0] != null){
                        sb.append(prodstbl2[i][j][k]);
                        sb.append(" , ");
                        }
                    }
                    sb.append("|");
                    sb.append(" , ");
                }
                sb.append("-");
                sb.append(" , ");
            }
            bw.write(sb.toString());
            bw.close();
        }catch (Exception e){
        }
    }
    public static void getprods3d(){
        for(int i=0;i<prodstbl2.length;i++){
            for(int j=0;j<prodstbl2[0].length;j++){
                for(int k=0;k<prodstbl2[0][0].length;k++){
                    if(prodwin.prods3d[i][j][0] != null){
                        prodstbl2[i][j][k] = prodwin.prods3d[i][j][k];
                    }
                }
            }
        }
    }
    public static void showprods3d(){
        String[] prods3dget = {};
        int index = 0;
        int count1 = 0;
        int count2 = 0;
        try{
            String line;
            BufferedReader br = new BufferedReader(new FileReader("D:\\AdDU\\College 1st year - 2nd sem\\ComProg\\Exercises\\Java\\database\\prodstable2.csv"));
            while((line = br.readLine()) != null){
                prods3dget = line.split(" , ");
            }
            for(int a=0;a<prods3dget.length;a++){
                if(prods3dget[a].equals("-")){
                    if(index == prodwin.prods3d.length){
                        break;
                    }else{
                        index++;
                        count1 = 0;
                        count2 = 0;
                    }
                    continue;
                }
                if(prods3dget[a].equals("|")){
                    if(count1 == prodwin.prods3d[0].length){
                        count1 = 0;
                    }else{
                        count1++;
                        count2 = 0;
                    }
                    continue;
                }
                else{
                    if(count2 == prodwin.prods3d[0][0].length){
                        count2 = 0;
                    }
                    prodstbl2new[index][count1][count2] = prods3dget[a];
                    count2++;
                }
            }
        }catch (Exception e){
        }
    }
    //count2
    public static void count2csv(){
         try{
            FileWriter fw = new FileWriter("D:\\AdDU\\College 1st year - 2nd sem\\ComProg\\Exercises\\Java\\database\\count2.csv", false);
            BufferedWriter bw = new BufferedWriter(fw);
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<counter.length;i++){
                sb.append(counter[i]);
                sb.append(" , ");
            }
            bw.write(sb.toString());
            bw.close();
        }catch(Exception e){
        }
    }
    public static void getcount2(){
        for(int i=0;i<counter.length;i++){
            counter[i] = prodwin.count2[i];
        }
    }
    public static void showcount2(){
        String [] count2get = {};
        try{
            String line;
            BufferedReader br = new BufferedReader(new FileReader("D:\\AdDU\\College 1st year - 2nd sem\\ComProg\\Exercises\\Java\\database\\count2.csv"));
            while((line = br.readLine()) != null){
                count2get = line.split(" , ");
            }
            for(int i=0;i<count2get.length;i++){
                counternew[i] = Integer.parseInt(count2get[i]);
            }
        }catch (Exception e){
        }
    }
    //orders
    public static void orderscsv(){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\AdDU\\College 1st year - 2nd sem\\ComProg\\Exercises\\Java\\database\\orders.csv", false));
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<orderstbl.length;i++){
                for(int j=0;j<orderstbl[0].length;j++){
                    for(int k=0;k<orderstbl[0][0].length;k++){
                        if(orderstbl[i][j][0] != null){
                            sb.append(orderstbl[i][j][k]);
                            sb.append(" , ");
                        }
                    }
                    sb.append("|");
                    sb.append(" , ");
                }
                sb.append("-");
                sb.append(" , ");
            }
            bw.write(sb.toString());
            bw.close();
        }catch (Exception e){
        }
    }
    public static void getorders(){
        for(int i=0;i<orderstbl.length;i++){
            for(int j=0;j<orderstbl[0].length;j++){
                for(int k=0;k<orderstbl[0][0].length;k++){
                    if(cusform.orders3d[i][j][0] != null){
                        orderstbl[i][j][k] = cusform.orders3d[i][j][k];
                    }
                }
            }
        }
        System.out.println("Orderstbl func: ");
        System.out.println(Arrays.deepToString(orderstbl));
    }
    public static void showorders(){
        String [] ordersget = {};
        int index = 0;
        int count1 = 0;
        int count2 = 0;
        try{
            String line;
            BufferedReader br = new BufferedReader(new FileReader("D:\\AdDU\\College 1st year - 2nd sem\\ComProg\\Exercises\\Java\\database\\orders.csv"));
            while((line = br.readLine()) != null){
                ordersget = line.split(" , ");
            }
            for(int i=0;i<ordersget.length;i++){
                if(ordersget[i].equals("-")){
                    if(index == cusform.orders3d.length){
                        break;
                    }else{
                        index++;
                        count1 = 0;
                        count2 = 0;
                    }
                    continue;
                }
                if(ordersget[i].equals("|")){
                    if(count1 == cusform.orders3d[0].length){
                        count1 = 0;
                    }else{
                        count1++;
                        count2 = 0;
                    }
                    continue;
                }
                else{
                    if(count2 == cusform.orders3d[0][0].length){
                        count2 = 0;
                    }
                    orderstblnew[index][count1][count2] = ordersget[i];
                    count2++;
                }
            }
        }catch (Exception e){
        }
    }
    //costs
    public static void costscsv(){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\AdDU\\College 1st year - 2nd sem\\ComProg\\Exercises\\Java\\database\\costs.csv", false));
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<costs.length;i++){
                    sb.append(costs[i]);
                    sb.append(" , ");
            }
            bw.write(sb.toString());
            bw.close();
        }catch (Exception e){
        }
    }
    public static void showcosts(){
        String [] costsget = {};
        try{
            String line;
            BufferedReader br = new BufferedReader(new FileReader("D:\\AdDU\\College 1st year - 2nd sem\\ComProg\\Exercises\\Java\\database\\costs.csv"));
            while((line = br.readLine()) != null){
                costsget = line.split(" , ");
            }
            for(int i=0;i<costsget.length;i++){
                costsnew[i] = Integer.parseInt(costsget[i]);
            }
        }catch (Exception e){
        }
    }
    //deleted
    public static void delcsv(){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\AdDU\\College 1st year - 2nd sem\\ComProg\\Exercises\\Java\\database\\delID.csv", false));
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<delID.size();i++){
                sb.append(delID);
                sb.append(" , ");
            }
            bw.write(sb.toString());
            bw.close();
        }catch (Exception e){
        }
    }
    public static void getdel(){
        delID.addAll(cusform.deletedID);
    }
    public static void showdel(){
        String [] del = {};
        try{
            String line;
            BufferedReader br = new BufferedReader(new FileReader("D:\\AdDU\\College 1st year - 2nd sem\\ComProg\\Exercises\\Java\\database\\delID.csv"));
            while((line = br.readLine()) != null){
                del = line.split(" , ");
            }
            for(int i=0;i<del.length;i++){
               delIDnew.add(Integer.parseInt(del[i]));
            }
        }catch (Exception e){
        }
    }
    //checker
    public static void check(){
            System.out.println("Customers: ");
            System.out.println(Arrays.deepToString(customers));
            System.out.println("Cusnew: ");
            System.out.println(Arrays.deepToString(cusnew));
            System.out.println("prodstbl1: ");
            System.out.println(Arrays.deepToString(prodstbl1));
            System.out.println("prodstbl1new: ");
            System.out.println(Arrays.deepToString(prodstbl1new));
            System.out.println("prodstbl2: ");
            System.out.println(Arrays.deepToString(prodstbl2));
            System.out.println("prodstbl2new: ");
            System.out.println(Arrays.deepToString(prodstbl2new));
            System.out.println("orderstbl: ");
            System.out.println(Arrays.deepToString(orderstbl));
            System.out.println("orderstblnew: ");
            System.out.println(Arrays.deepToString(orderstblnew));
        }
}
