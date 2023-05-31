package moviecrud;

/**
 *
 * @author JAMES
 */
public class User {
    String fjudul,falur,pkh,akg;
    public User(String fjudul,String falur,String pkh, String akg){
        this.fjudul = fjudul;
        this.falur = falur;
        this.pkh = pkh;
        this.akg = akg;
    }

    User(String string, String string0, String string1, String string2, String string3 ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    User(String string, String string0, String string1, String string2, String string3, String string4 ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //getters
    public String getFjudul(){
        return this.fjudul;
    }
    public String getFalur(){
        return this.falur;
    }
    public String getPenokohan(){
        return this.pkh;
    }
    public String getAkting(){
        return this.akg;
    }

    Object getfjudul() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
