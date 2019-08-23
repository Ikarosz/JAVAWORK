
package dhcp;


public class Nemkioszt {
    
   private String ipcim;
    
    public Nemkioszt(String ipcim){
        this.ipcim=ipcim;
    }

    public String getIpcim() {
        return ipcim;
    }
    
     public int getIpcimlast(){
        String[] s = ipcim.split("\\.");

      
        
        return Integer.parseInt(s[3]);
    }
    
}
