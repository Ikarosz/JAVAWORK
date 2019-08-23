/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class Program {

   private static ArrayList<DHCPszerver> dhcp_tomb;
     private static ArrayList<Kioszt> kioszt_tomb;
     private static ArrayList<Nemkioszt> nemkioszt_tomb;
      private static  ArrayList<Teszt> teszt_tomb;
      
    public static void main(String[] args) throws IOException {
        
       

        List<String> dhcp_beolvas= Files.readAllLines(Paths.get("dhcp.csv"));
       dhcp_tomb= new ArrayList<>();
        for (String dhcp_beolva : dhcp_beolvas) {
            DHCPszerver ujdhcp= new DHCPszerver(dhcp_beolva);
            dhcp_tomb.add(ujdhcp);
        }
        
     
        
     List<String> kioszt_beolvas= Files.readAllLines(Paths.get("reserved.csv"));
     kioszt_tomb= new ArrayList<>();
        for (String kiosz_beolva : kioszt_beolvas) {
            Kioszt ujkioszt= new Kioszt(kiosz_beolva);
            kioszt_tomb.add(ujkioszt);
        }
   List<String> nemkioszt_beolvas= Files.readAllLines(Paths.get("excluded.csv"));
   nemkioszt_tomb= new ArrayList<>();
        for (String nemkioszt_beolva : nemkioszt_beolvas) {
            Nemkioszt ujnemkioszt= new Nemkioszt(nemkioszt_beolva);
            nemkioszt_tomb.add(ujnemkioszt);
        }
  List<String> teszt_beolvas= Files.readAllLines(Paths.get("test.csv"));
  teszt_tomb= new ArrayList<>();
        for (String teszt_beolva : teszt_beolvas) {
            Teszt ujteszt= new Teszt(teszt_beolva);
            teszt_tomb.add(ujteszt);
        }
  
        for (Nemkioszt nemkioszt : nemkioszt_tomb) {
            System.out.println(nemkioszt.getIpcimlast()+" last id");
        }
        for (Teszt teszt : teszt_tomb) {
            System.out.println(teszt.getFeltetel()+"feltetel");
            System.out.println(teszt.getMaccim()+"mac");
            if(teszt.getFeltetel().equals("request")){
                request(teszt.getMaccim());
                System.out.println(teszt.getMaccim()+"rquest");
            }
            
        }
        
        
        
        
        
   BufferedWriter kiir= new BufferedWriter(new FileWriter("dhcp_kesz.csv"));
        for (DHCPszerver dHCPszerver : dhcp_tomb) {
             kiir.write(dHCPszerver.getMaccim()+";"+dHCPszerver.getIpcim());
             kiir.newLine();
        }
  
   kiir.close();
        
     
    }
    
    
    private static void request(String maccim){
        int i=0;
        int ipcim=ipcvizsgal();
        
        
      
        if(!macdhcpben(maccim)){
            if(!macfentart(maccim)&& ipcim>=199){
              
               
                    System.out.println("Sikertelen IP cím kiosztás");
                

            }else if(!ipcimvizsgalBerelt(kioszt_tomb.get(foglalas(maccim)).getIpcimlast()) || ipcim<199){
                if(!ipcimvizsgalBerelt(kioszt_tomb.get(foglalas(maccim)).getIpcimlast())){
                    ipcim=kioszt_tomb.get(foglalas(maccim)).getIpcimlast();
                }
             DHCPszerver ujdhcp= new DHCPszerver(maccim+";192.168.10."+ipcim);
            
        }
        }
        
        
        
        
    }
    
   
        
    
    
 private static int ipcvizsgal(){
  int ipcim=100;
                while(ipcim<199 && (ipcimvizsgalBerelt(ipcim) || ipcimvizsgalKizart(ipcim) || ipcimvizsgalFentart(ipcim))){
                    ipcim++;
                }
 
 
 return ipcim;
         
         
         }
 
 
    private static boolean macdhcpben(String maccim){
        int i=0;
        while(i<dhcp_tomb.size()&&!(dhcp_tomb.get(i).getMaccim().equals(maccim))){
           i++;
       }
        return i<dhcp_tomb.size();
    }
    
      private static boolean macfentart(String maccim){
        int i=0;
        while(i<kioszt_tomb.size()&&!(kioszt_tomb.get(i).getMaccim().equals(maccim))){
           i++;
       }
        return i<kioszt_tomb.size();
    }
          private static int foglalas(String maccim){
        int i=0;
        while(i<kioszt_tomb.size()&&!(kioszt_tomb.get(i).getMaccim().equals(maccim))){
           i++;
       }
        return i;
    }
      
      private static boolean ipcimvizsgalBerelt(int ipcim){
          int i =0;
         while(i<dhcp_tomb.size()&&!(dhcp_tomb.get(i).getIpcimlast()==(ipcim))){
           i++;
       }
        return i<dhcp_tomb.size();
    }
      
       private static boolean ipcimvizsgalKizart(int ipcim){
          int i =0;
         while(i<nemkioszt_tomb.size()&&!( nemkioszt_tomb.get(i).getIpcimlast()==(ipcim))){
           i++;
       }
        return i<nemkioszt_tomb.size();
    }
       
       private static boolean ipcimvizsgalFentart(int ipcim){
          int i =0;
         while(i<kioszt_tomb.size()&&!( kioszt_tomb.get(i).getIpcimlast()==(ipcim))){
           i++;
       }
        return i<kioszt_tomb.size();
    }
      
}
