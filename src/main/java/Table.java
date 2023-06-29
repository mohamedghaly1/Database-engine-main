import java.io.Serializable;
import java.util.Vector;

public class Table implements Serializable {

    String strTableName;
    Vector <String> vectorPageReferences = new Vector<String>();
    int intNewPageId;

    public Table(String strTableName){
        this.strTableName=strTableName;
    }

}
