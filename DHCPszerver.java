/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhcp;
 
import java.util.List;

public class DHCPszerver {
    
    
   private String maccim;
   private String ipcim;
   
    public DHCPszerver(String betomb){

            String[] s = betomb.split(";");

        maccim= s[0];
       ipcim= s[1];
    }

    public String getMaccim() {
        return maccim;
    }

    public String getIpcim() {
        return ipcim;
    }
    
    public int getIpcimlast(){
        String[] s = ipcim.split("\\.");

      
        
        return Integer.parseInt(s[3]);
    }
    
    
    
    
}
