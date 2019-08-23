
package dhcp;


public class Teszt {
    
  private String maccim;
   private String feltetel;
   
  public Teszt(String betomb){

            String[] s = betomb.split(";");

       feltetel=s[0];
    maccim=s[1];
      
    }

    public String getMaccim() {
        return maccim;
    }

    public String getFeltetel() {
        return feltetel;
    }
    
    
}
