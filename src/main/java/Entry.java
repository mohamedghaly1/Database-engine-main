import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Vector;

public class Entry implements Serializable {
    Vector<String> references = new Vector<String>();
    Vector<Object> clusteringValues = new Vector<Object>();
    Object x;
    Object y;
    Object z;

    public Entry(Object x, Object y, Object z, String reference,Object objClusteringValue) {
        this.x = x;
        this.y = y;
        this.z = z;
        references.add(reference);
        clusteringValues.add(objClusteringValue);
    }



    public String toString() {
        return "(" + x.toString() + "," + y.toString() + "," + z.toString() + "," + references.toString() +","+clusteringValues.toString()+ ")";
    }

    public boolean equals(Object o) {
        Entry e = (Entry) o;
        return this.x.equals(e.x) && this.y.equals(e.y) && this.z.equals(e.z);
    }

    public boolean hasDuplicates(){
        return references.size()>1;
    }
}