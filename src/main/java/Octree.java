import java.io.Serializable;
import java.util.*;

public class Octree implements Serializable {

    Node root;
    int maxNodeEntries;
    String strIndexName;
    Vector<String> vectorColumnNames = new Vector<>();


    public static void main(String[] args) throws DBAppException{
        String [] strarrColName = new String[] {"gpa","name","grade"};

        Octree oct = new Octree(0.0,1.0,"a","zzzzz",0,10,2,strarrColName);
        oct.add(0.5,"mada",0,"hallOfFame1",0.5);
        oct.add(0.6,"mada",1,"hallOfFame2",0.6);
        oct.add(0.7,"mada",5,"hallOfFame3",0.7);
        oct.add(0.7,"mada",7,"hallOfFame4",0.8);
        oct.add(0.71,"madb",2,"hallOfFame5",0.71);
        oct.add(1.0,"mada",5,"hallOfFame6",1.0);
        oct.add(0.7,"a",5,"hallOfFame7",0.7);
        oct.add(0.7,"mazzd",5,"hallOfFame8",1.69);
        oct.add(0.7,"mazzd",5,"hallOfFame9",1.7);

//        Hashtable<String,Object> htblVals = new Hashtable<String,Object>();
//        htblVals.put("gpa",0.7);
//        htblVals.put("name","mazzd");
//        htblVals.put("grade",5);

        String [] strarrOperators = {"=","=","="};

        Hashtable<String,Object> htblVals1 = new Hashtable<String,Object>();
        htblVals1.put("name","mada");
        htblVals1.put("grade",7);
        htblVals1.put("gpa",0.7);

        System.out.println(oct);
        System.out.println("----------------------------------");
        oct.updateReference(htblVals1,0.8,"yesBaby");
        System.out.println(oct);
//        System.out.println(oct.search(htblVals1,strarrOperators));
    }

    public Octree(Object minX, Object maxX, Object minY, Object maxY, Object minZ, Object maxZ,int maxNodeEntries,String [] strarrColName){
        root = new Node(minX,maxX,minY,maxY,minZ,maxZ);
        this.maxNodeEntries=maxNodeEntries;
        vectorColumnNames.add(strarrColName[0]);
        vectorColumnNames.add(strarrColName[1]);
        vectorColumnNames.add(strarrColName[2]);
    }


    public Vector<Entry> search(Hashtable<String,Object>htblColNameValue,String []strarrOperators){
        Vector<Entry> vectorResult = new Vector<>();

        Object x = htblColNameValue.get(vectorColumnNames.get(0));
        Object y = htblColNameValue.get(vectorColumnNames.get(1));
        Object z = htblColNameValue.get(vectorColumnNames.get(2));

        Queue queue = new LinkedList<Node>();
        queue.add(root);

        while(!queue.isEmpty()){
            Node cur = (Node) queue.remove();
            if(cur.parent){
                Object halfWayX = cur.getHalfWayX();
                Object halfWayY = cur.getHalfWayY();
                Object halfWayZ = cur.getHalfWayZ();

                boolean one = false;
                boolean two = false;
                boolean three = false;

                if(x!=null)one = lessThan(x,halfWayX);
                if(y!=null)two= lessThan(y,halfWayY);
                if(z!=null)three= lessThan(z,halfWayZ);

                boolean oneBoth = ( one && (strarrOperators[0].equals(">")||strarrOperators[0].equals(">=")) ) ||( (!one) && (strarrOperators[0].equals("<")||strarrOperators[0].equals("<=")) ) || x==null || strarrOperators[0].equals("!=") ;
                boolean twoBoth = ( two && (strarrOperators[1].equals(">")||strarrOperators[1].equals(">=")) ) ||( (!two) && (strarrOperators[1].equals("<")||strarrOperators[1].equals("<=")) ) || y==null || strarrOperators[1].equals("!=");
                boolean threeBoth = ( three && (strarrOperators[2].equals(">")||strarrOperators[2].equals(">=")) ) ||( (!three) && (strarrOperators[2].equals("<")||strarrOperators[2].equals("<=")) || z==null || strarrOperators[2].equals("!=") ) ;

                if( (one||oneBoth) && (two||twoBoth) && (three||threeBoth)) queue.add(cur.childNodes[0]);
                if( (one||oneBoth) && (two||twoBoth) && ((!three)||threeBoth) ) queue.add(cur.childNodes[1]);
                if( (one||oneBoth) && ((!two)||twoBoth) && (three||threeBoth) ) queue.add(cur.childNodes[2]);
                if( (one||oneBoth) && ((!two)||twoBoth) && ((!three)||threeBoth) ) queue.add(cur.childNodes[3]);
                if( ((!one)||oneBoth) && (two||twoBoth) && (three||threeBoth) ) queue.add(cur.childNodes[4]);
                if( ((!one)||oneBoth) && (two||twoBoth) && ((!three)||threeBoth) ) queue.add(cur.childNodes[5]);
                if( ((!one)||oneBoth) && ((!two)||twoBoth) && (three||threeBoth) ) queue.add(cur.childNodes[6]);
                if( ((!one)||oneBoth) && ((!two)||twoBoth) && ((!three)||threeBoth) ) queue.add(cur.childNodes[7]);
            }
            else{
                for(Entry e: cur.entries){
                    boolean conditionOne=true;
                    boolean conditionTwo=true;
                    boolean conditionThree=true;
                    if(x!=null) {
                        switch (strarrOperators[0]) {
                            case "=":
                                conditionOne = e.x.equals(x);
                                break;
                            case "<":
                                conditionOne = lessThan(e.x, x);
                                break;
                            case "<=":
                                conditionOne = lessThan(e.x, x) || e.x.equals(x);
                                break;
                            case ">":
                                conditionOne = (!lessThan(e.x, x)) && (!e.x.equals(x));
                                break;
                            case ">=":
                                conditionOne = !lessThan(e.x, x);
                                break;
                            case "!=":
                                conditionOne = !e.x.equals(x);
                                break;
                        }
                    }
                    if(y!=null) {
                        switch (strarrOperators[1]) {
                            case "=":
                                conditionTwo = e.y.equals(y);
                                break;
                            case "<":
                                conditionTwo = lessThan(e.y, y);
                                break;
                            case "<=":
                                conditionTwo = lessThan(e.y, y) || e.y.equals(y);
                                break;
                            case ">":
                                conditionTwo = (!lessThan(e.y, y)) && (!e.y.equals(y));
                                break;
                            case ">=":
                                conditionTwo = !lessThan(e.y, y);
                                break;
                            case "!=":
                                conditionTwo = !e.y.equals(y);
                                break;
                        }
                    }
                    if(z!=null) {
                        switch (strarrOperators[2]) {
                            case "=":
                                conditionThree = e.z.equals(z);
                                break;
                            case "<":
                                conditionThree = lessThan(e.z, z);
                                break;
                            case "<=":
                                conditionThree = lessThan(e.z, z) || e.z.equals(z);
                                break;
                            case ">":
                                conditionThree = (!lessThan(e.z, z)) && (!e.z.equals(z));
                                break;
                            case ">=":
                                conditionThree = !lessThan(e.z, z);
                                break;
                            case "!=":
                                conditionThree = !e.z.equals(z);
                                break;
                        }
                    }
                    if(conditionOne&&conditionTwo&&conditionThree)vectorResult.add(e);
                }
            }
        }
        return vectorResult;
    }




    public void deleteTuple(Hashtable<String,Object> htblColNameValue, Object objClusteringValue){

        Object x = htblColNameValue.get(vectorColumnNames.get(0));
        Object y = htblColNameValue.get(vectorColumnNames.get(1));
        Object z = htblColNameValue.get(vectorColumnNames.get(2));


        Node cur = root;

        // Moving My Way Downtown
        while(cur.parent){
            Object halfWayX = cur.getHalfWayX();
            Object halfWayY = cur.getHalfWayY();
            Object halfWayZ = cur.getHalfWayZ();

            boolean one = lessThan(x,halfWayX);
            boolean two = lessThan(y,halfWayY);
            boolean three = lessThan(z,halfWayZ);

            if( one && two && three) cur=cur.childNodes[0];
            else if(one && two && (!three)) cur=cur.childNodes[1];
            else if(one && (!two) && three) cur=cur.childNodes[2];
            else if(one && (!two) && (!three)) cur=cur.childNodes[3];
            else if((!one) && two && three) cur=cur.childNodes[4];
            else if((!one) && two && (!three)) cur=cur.childNodes[5];
            else if((!one) && (!two) && three) cur=cur.childNodes[6];
            else if((!one) && (!two) && (!three)) cur=cur.childNodes[7];
        }

        Vector<Entry> toBeRemoved = new Vector<>();

        for(Entry e:cur.entries){
            for(int i=0;i<e.references.size();i++){
                if(e.clusteringValues.get(i).equals(objClusteringValue)){
                    e.references.remove(i);
                    e.clusteringValues.remove(i);
                    if(e.references.size()==0)toBeRemoved.add(e);
                    break;
                }
            }
        }

        for(Entry e:toBeRemoved)cur.entries.remove(e);
    }

    public void updateTuple(Hashtable<String,Object> htblOldTuple,Hashtable<String,Object> htblNewVals, Object objClusteringValue, String strReference){

        Object x = htblOldTuple.get(vectorColumnNames.get(0));
        Object y = htblOldTuple.get(vectorColumnNames.get(1));
        Object z = htblOldTuple.get(vectorColumnNames.get(2));

        Object newX = htblNewVals.get(vectorColumnNames.get(0));
        Object newY = htblNewVals.get(vectorColumnNames.get(1));
        Object newZ = htblNewVals.get(vectorColumnNames.get(2));


       Hashtable<String,Object> htblNewTuple = new Hashtable<>();

       Enumeration<String> k = htblOldTuple.keys();
       while(k.hasMoreElements()){
           String strColName = k.nextElement();
           Object objValue = htblOldTuple.get(strColName);
           if(strColName.equals(vectorColumnNames.get(0))){
               if(newX!=null)objValue = newX;
           }
           if(strColName.equals(vectorColumnNames.get(1))){
               if(newY!=null)objValue = newY;
           }
           if(strColName.equals(vectorColumnNames.get(2))){
               if(newZ!=null)objValue = newZ;
           }
           htblNewTuple.put(strColName,objValue);
       }

       deleteTuple(htblOldTuple,objClusteringValue);
       add(htblNewTuple.get(vectorColumnNames.get(0)),htblNewTuple.get(vectorColumnNames.get(1)),htblNewTuple.get(vectorColumnNames.get(2)),strReference,objClusteringValue);

    }

    public void add(Object x, Object y, Object z, String entryReference,Object objClusteringValue){
        Node cur = root;
        Entry newEntry = new Entry(x,y,z,entryReference,objClusteringValue);

        // Moving My Way Downtown
        while(cur.parent){
            Object halfWayX = cur.getHalfWayX();
            Object halfWayY = cur.getHalfWayY();
            Object halfWayZ = cur.getHalfWayZ();

            boolean one = lessThan(x,halfWayX);
            boolean two = lessThan(y,halfWayY);
            boolean three = lessThan(z,halfWayZ);

            if( one && two && three) cur=cur.childNodes[0];
            else if(one && two && (!three)) cur=cur.childNodes[1];
            else if(one && (!two) && three) cur=cur.childNodes[2];
            else if(one && (!two) && (!three)) cur=cur.childNodes[3];
            else if((!one) && two && three) cur=cur.childNodes[4];
            else if((!one) && two && (!three)) cur=cur.childNodes[5];
            else if((!one) && (!two) && three) cur=cur.childNodes[6];
            else if((!one) && (!two) && (!three)) cur=cur.childNodes[7];
        }

        //Duplicate Check
        if(cur.entries.contains(newEntry)){
            for(Entry e : cur.entries){
                if(e.equals(newEntry)){
                    e.references.add(entryReference);
                    e.clusteringValues.add(objClusteringValue);
                    return;
                }
            }
        }

        cur.entries.add(new Entry(x,y,z,entryReference,objClusteringValue));

        if(cur.entries.size()>maxNodeEntries){
            divideAndRedistribute(cur);
        }

    }

    public void updateReference(Hashtable<String,Object> htblColNameValue,Object objClusteringValue,String newReference){
        Vector<Entry> vectorEntries = search(htblColNameValue,new String[]{"=","=","="});
        Entry e = vectorEntries.get(0);
        int index = -1;
        for(int i=0;i<e.references.size();i++){
            if(!e.clusteringValues.get(i).equals(objClusteringValue))continue;
            index=i;
            break;
        }
        e.references.insertElementAt(newReference,index);
        e.references.remove(index+1);
    }

    private void divideAndRedistribute(Node cur){
        cur.parent = true;

        Object halfWayX = cur.getHalfWayX();
        Object halfWayY = cur.getHalfWayY();
        Object halfWayZ = cur.getHalfWayZ();

        //Creating new nodes
        cur.childNodes[0]= new Node(cur.minX,halfWayX,cur.minY,halfWayY,cur.minZ,halfWayZ);
        cur.childNodes[1]= new Node(cur.minX,halfWayX,cur.minY,halfWayY,halfWayZ,cur.maxZ);
        cur.childNodes[2]= new Node(cur.minX,halfWayX,halfWayY,cur.maxY,cur.minZ,halfWayZ);
        cur.childNodes[3]= new Node(cur.minX,halfWayX,halfWayY,cur.maxY,halfWayZ,cur.maxZ);
        cur.childNodes[4]= new Node(halfWayX,cur.maxX,cur.minY,halfWayY,cur.minZ,halfWayZ);
        cur.childNodes[5]= new Node(halfWayX,cur.maxX,cur.minY,halfWayY,halfWayZ, cur.maxZ);
        cur.childNodes[6]= new Node(halfWayX,cur.maxX,halfWayY,cur.maxY,cur.minZ,halfWayZ);
        cur.childNodes[7]= new Node(halfWayX,cur.maxX,halfWayY,cur.maxY,halfWayZ, cur.maxZ);


        //Redistributing
        for(Entry e : cur.entries){

            boolean one = lessThan(e.x,halfWayX);
            boolean two = lessThan(e.y,halfWayY);
            boolean three = lessThan(e.z,halfWayZ);

            if( one && two && three)cur.childNodes[0].entries.add(e);
            else if(one && two && (!three)) cur.childNodes[1].entries.add(e);
            else if(one && (!two) && three)cur.childNodes[2].entries.add(e);
            else if(one && (!two) && (!three))cur.childNodes[3].entries.add(e);
            else if((!one) && two && three) cur.childNodes[4].entries.add(e);
            else if((!one) && two && (!three)) cur.childNodes[5].entries.add(e);
            else if((!one) && (!two) && three) cur.childNodes[6].entries.add(e);
            else if((!one) && (!two) && (!three)) cur.childNodes[7].entries.add(e);

        }

        cur.entries = null;

        for(int i=0;i<8;i++){
            if(cur.childNodes[i].entries.size()>maxNodeEntries) divideAndRedistribute(cur.childNodes[i]);
        }
    }

    private static boolean lessThan(Object one, Object two){
        if(one instanceof Integer && two instanceof Integer){
            return (int)one<(int)two;
        }
        else if(one instanceof Double && two instanceof Double){
            return (double)one<(double)two;
        }
        else if(one instanceof String && two instanceof String){
            if( ((String)one).length() != ((String)two).length() ) return ((String)one).length() < ((String)two).length();
            else return ((String)one).compareTo((String)two)<0;
        }
        else return ((Date)one).before((Date)two);

    }

    public String toString() {
        StringBuilder buffer = new StringBuilder(50);
        print(buffer, "", "",root);
        return buffer.toString();
    }

    private void print(StringBuilder buffer, String prefix, String childrenPrefix, Node cur) {
        buffer.append(prefix);
        buffer.append(cur.toString());
        buffer.append('\n');
        if(!cur.parent)return;
        for (int i=0;i<cur.childNodes.length;i++) {
            Node next = cur.childNodes[i];
            if (i<=6) {
                print(buffer, childrenPrefix + "├── ", childrenPrefix + "│   ",next);
            } else {
                print(buffer, childrenPrefix + "└── ", childrenPrefix + "    ",next);
            }
        }
    }

    private static void generateLexicographical(int length) throws DBAppException{

        String s = "a";
        while(s.length()<=length) {
            System.out.println(s);
            char[] temp = s.toCharArray();
            if (s.charAt(temp.length - 1) < 'z') temp[temp.length - 1]++;
            else {
                temp[temp.length - 1] = 'a';
                boolean done = false;
                for (int i = temp.length - 2; i >= 0; i--) {
                    if (temp[i] < 'z') {
                        temp[i]++;
                        done = true;
                        break;
                    } else {
                        temp[i] = 'a';
                    }
                }
                if (!done){
                    s= "a"+new String(temp);
                    continue;
                }
            }
            s=new String(temp);

            long num = Node.alphaStringToNumber(s);
            if(!Node.numberToAlphaString(num).equals(s))throw new DBAppException("lalalala");
        }
    }
}
