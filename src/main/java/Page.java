import java.io.Serializable;
import java.util.Hashtable;
import java.util.Vector;

public class Page implements Serializable {

    String strTableName;
    int intPageId;
    Vector< Hashtable<String,Object> > vectorTuples= new Vector<Hashtable<String,Object>>();;
    String strNextPage;

    public Page(String strTableName,int intPageId){
        this.strTableName = strTableName;
        this.intPageId=intPageId;
    }

}
