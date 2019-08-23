
package dhcp;


public class Kioszt {
    
    
    
       private String ipcim;
      private  String maccim;
    
   public Kioszt(String betomb){

            String[] s = betomb.split(";");

       maccim= s[0];
       ipcim= s[1];
    }

    public String getIpcim() {
        return ipcim;
    }

    public String getMaccim() {
        return maccim;
    }
    
     public int getIpcimlast(){
     String[] s = ipcim.split("\\.");

      
        
        return Integer.parseInt(s[3]);
    }
    
    
    
}
