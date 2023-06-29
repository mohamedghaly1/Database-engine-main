import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

public class Node implements Serializable {
    boolean parent;
    Object minX, maxX, minY, maxY, minZ, maxZ;
    Vector<Entry> entries = new Vector<Entry>();
    Node[] childNodes = new Node[8];

    public Node(Object minX, Object maxX, Object minY, Object maxY, Object minZ, Object maxZ) {
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
        this.minZ = minZ;
        this.maxZ = maxZ;
    }

    public Object getHalfWayX(){
        if(minX instanceof Integer){
            return ((int)minX + (int)maxX)/2;
        }
        else if(minX instanceof Double){
            return ((double)minX + (double)maxX)/2;
        }
        else if(minX instanceof String){
            return getMiddleString((String)minX,(String)maxX);
        }
        else {
            long midwayTime = ( ((Date)minX).getTime() + ((Date)maxX).getTime() ) / 2;
            return new Date(midwayTime);
        }
    }

    public Object getHalfWayY(){
        if(minY instanceof Integer){
            return ((int)minY + (int)maxY)/2;
        }
        else if(minY instanceof Double){
            return ((double)minY + (double)maxY)/2;
        }
        else if(minY instanceof String){
            return getMiddleString((String)minY,(String)maxY);
        }
        else {
            long midwayTime = ( ((Date)minY).getTime() + ((Date)maxY).getTime() ) / 2;
            return new Date(midwayTime);
        }
    }

    public Object getHalfWayZ(){
        if(minZ instanceof Integer){
            return ((int)minZ + (int)maxZ)/2;
        }
        else if(minZ instanceof Double){
            return ((double)minZ + (double)maxZ)/2;
        }
        else if(minZ instanceof String){
            return getMiddleString((String)minZ,(String)maxZ);
        }
        else {
            long midwayTime = ( ((Date)minZ).getTime() + ((Date)maxZ).getTime() ) / 2;
            return new Date(midwayTime);
        }
    }

    private static String getMiddleString(String s, String t)
    {
        return numberToAlphaString((alphaStringToNumber(s)+alphaStringToNumber(t))/2);
    }

    public static long alphaStringToNumber(String str) {
        long n = 0;
        for (char elem : str.toCharArray()) {
            n *= 26;
            n += 1 + (elem - 'a');
        }
        return n;
    }

    public static String numberToAlphaString(long n) {
        StringBuilder r = new StringBuilder();
        while (n > 0) {
            r.append((char)('a' + ( --n % 26) ));
            n /= 26;
        }
        return r.reverse().toString();
    }


    public String toString(){
        if(parent)return "Parent: "+ "X["+minX+","+maxX+"] "+"Y["+minY+","+maxY+"] "+"Z["+minZ+","+maxZ+"]";
        else {
            String s = "";
            for(Entry e : entries){
                s+=e.toString();
                s+="  ";
            }
            return s;
        }
    }
}