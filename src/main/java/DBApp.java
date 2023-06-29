
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Clock;
import java.util.*;

import static org.antlr.v4.runtime.CharStreams.fromString;


public class DBApp {

    static int intMaxPageRows;
    static int MaximumEntriesInOctreeNode;
    static Vector<Octree> vectorLoadedIndices = new Vector<>();

    public static void main(String[] args) throws Exception {

        DBApp db = new DBApp();
        db.init();
//        String table = "students";
//        Hashtable<String, Object> row = new Hashtable();
//        row.put("first_name","zzzzzz");
//        db.deleteFromTable("students",row);
//        printTable("students");

//	        Date dob = new Date(1992 - 1900, 9 - 1, 8);
	     //   row.put("dob", dob);
	        //row.put("id", "44-5679");

//	        db.deleteFromTable(table, row);
        //printTable("students");
//        String [] cols = new String[]{"first_name","last_name","gpa"};
//       db.createIndex("students",cols);
//       System.out.println(vectorLoadedIndices.get(0));
        //printTable("students");
//        String table = "students";
//        Hashtable<String, Object> row = new Hashtable();
//        row.put("id", "44-5679");
//        row.put("first_name", "hWknCP");
//        row.put("last_name", "EGpfuC");
//        Date dob = new Date(1995 - 1900, 4 - 1, 1);
       // row.put("dob", dob);
      //  row.put("gps", 1.1);
//        db.insertIntoTable(table,row);
//       createCoursesTable(db);
//        createPCsTable(db);
//        createTranscriptsTable(db);
      //    createStudentTable(db);
//        insertPCsRecords(db,200);
//        insertTranscriptsRecords(db,200);
       //   insertStudentRecords(db,200);
//        insertCoursesRecords(db,200);
       //db.parseSQL(new StringBuffer("create table Bonjour1 ( id INT check (id>=1 and id<=1000),name varchar check (name>=a and name<=zzzzz),gpa DOUBLE check (gpa>=0.7 and gpa<=4.0),dob DATE check (dob>=1990/01/01 and dob<=2023/05/16), PRIMARY KEY(id))"));
//
//        db.parseSQL(new StringBuffer("create index indexName on Bonjour (name,gpa,id)"));


//
//        for(int i=100;i<=199;i++) {
//            double gpa = Math.random()*3 +1;
//            db.parseSQL(new StringBuffer("insert into Bonjour1 (id,name,gpa,dob) values ("+i+",mada,"+gpa+",2003/05/18)"));
//        }
//
        db.parseSQL(new StringBuffer("delete from Bonjour1 where id=100"));
//
//        db.parseSQL(new StringBuffer("update Bonjour1 set (gpa=1.101010101) where id=100"));
        printTable("Bonjour1");
//
//        Iterator i = db.parseSQL(new StringBuffer("select * from students where first_name>=\"nUGpuU\" and gpa >=1.04 and gpa<=3.0\" "));
//        while(i.hasNext())System.out.println(i.next());
//
//        System.out.println(vectorLoadedIndices.get(0));
//        printTable("Bonjour");


    }

    private static void  insertCoursesRecords(DBApp dbApp, int limit) throws Exception {
        BufferedReader coursesTable = new BufferedReader(new FileReader("src/main/resources/courses_table.csv"));
        String record;
        Hashtable<String, Object> row = new Hashtable<>();
        int c = limit;
        if (limit == -1) {
            c = 1;
        }
        while ((record = coursesTable.readLine()) != null && c > 0) {
            String[] fields = record.split(",");


            int year = Integer.parseInt(fields[0].trim().substring(0, 4));
            int month = Integer.parseInt(fields[0].trim().substring(5, 7));
            int day = Integer.parseInt(fields[0].trim().substring(8));

            Date dateAdded = new Date(year - 1900, month - 1, day);

            row.put("date_added", dateAdded);

            row.put("course_id", fields[1]);
            row.put("course_name", fields[2]);
            row.put("hours", Integer.parseInt(fields[3]));

            dbApp.insertIntoTable("courses", row);
            row.clear();

            if (limit != -1) {
                c--;
            }
        }

        coursesTable.close();
    }

    private static void  insertStudentRecords(DBApp dbApp, int limit) throws Exception {
        BufferedReader studentsTable = new BufferedReader(new FileReader("src/main/resources/students_table.csv"));
        String record;
        int c = limit;
        if (limit == -1) {
            c = 1;
        }

        Hashtable<String, Object> row = new Hashtable<>();
        while ((record = studentsTable.readLine()) != null && c > 0) {
            String[] fields = record.split(",");

            row.put("id", fields[0]);
            row.put("first_name", fields[1]);
            row.put("last_name", fields[2]);

            int year = Integer.parseInt(fields[3].trim().substring(0, 4));
            int month = Integer.parseInt(fields[3].trim().substring(5, 7));
            int day = Integer.parseInt(fields[3].trim().substring(8));

            Date dob = new Date(year - 1900, month - 1, day);
            row.put("dob", dob);

            double gpa = Double.parseDouble(fields[4].trim());

            row.put("gpa", gpa);

            dbApp.insertIntoTable("students", row);
            row.clear();
            if (limit != -1) {
                c--;
            }
        }
        studentsTable.close();
    }
    private static void insertTranscriptsRecords(DBApp dbApp, int limit) throws Exception {
        BufferedReader transcriptsTable = new BufferedReader(new FileReader("src/main/resources/transcripts_table.csv"));
        String record;
        Hashtable<String, Object> row = new Hashtable<>();
        int c = limit;
        if (limit == -1) {
            c = 1;
        }
        while ((record = transcriptsTable.readLine()) != null && c > 0) {
            String[] fields = record.split(",");

            row.put("gpa", Double.parseDouble(fields[0].trim()));
            row.put("student_id", fields[1].trim());
            row.put("course_name", fields[2].trim());

            String date = fields[3].trim();
            int year = Integer.parseInt(date.substring(0, 4));
            int month = Integer.parseInt(date.substring(5, 7));
            int day = Integer.parseInt(date.substring(8));

            Date dateUsed = new Date(year - 1900, month - 1, day);
            System.out.println();
            row.put("date_passed", dateUsed);

            dbApp.insertIntoTable("transcripts", row);
            row.clear();

            if (limit != -1) {
                c--;
            }
        }

        transcriptsTable.close();
    }
    private static void insertPCsRecords(DBApp dbApp, int limit) throws Exception {
        BufferedReader pcsTable = new BufferedReader(new FileReader("src/main/resources/pcs_table.csv"));
        String record;
        Hashtable<String, Object> row = new Hashtable<>();
        int c = limit;
        if (limit == -1) {
            c = 1;
        }
        while ((record = pcsTable.readLine()) != null && c > 0) {
            String[] fields = record.split(",");

            row.put("pc_id", Integer.parseInt(fields[0].trim()));
            row.put("student_id", fields[1].trim());

            dbApp.insertIntoTable("pcs", row);
            row.clear();

            if (limit != -1) {
                c--;
            }
        }

        pcsTable.close();
    }
    private static void createTranscriptsTable(DBApp dbApp) throws Exception {
        // Double CK
        String tableName = "transcripts";

        Hashtable<String, String> htblColNameType = new Hashtable<String, String>();
        htblColNameType.put("gpa", "java.lang.Double");
        htblColNameType.put("student_id", "java.lang.String");
        htblColNameType.put("course_name", "java.lang.String");
        htblColNameType.put("date_passed", "java.util.Date");

        Hashtable<String, String> minValues = new Hashtable<>();
        minValues.put("gpa", "0.7");
        minValues.put("student_id", "43-0000");
        minValues.put("course_name", "AAAAAA");
        minValues.put("date_passed", "1990/01/01");

        Hashtable<String, String> maxValues = new Hashtable<>();
        maxValues.put("gpa", "5.0");
        maxValues.put("student_id", "99-9999");
        maxValues.put("course_name", "zzzzzz");
        maxValues.put("date_passed", "2020/12/31");

        dbApp.createTable(tableName, "gpa", htblColNameType, minValues, maxValues);
    }

    private static void createStudentTable(DBApp dbApp) throws Exception {
        // String CK
        String tableName = "students";

        Hashtable<String, String> htblColNameType = new Hashtable<String, String>();
        htblColNameType.put("id", "java.lang.String");
        htblColNameType.put("first_name", "java.lang.String");
        htblColNameType.put("last_name", "java.lang.String");
        htblColNameType.put("dob", "java.util.Date");
        htblColNameType.put("gpa", "java.lang.Double");

        Hashtable<String, String> minValues = new Hashtable<>();
        minValues.put("id", "43-0000");
        minValues.put("first_name", "AAAAAA");
        minValues.put("last_name", "AAAAAA");
        minValues.put("dob", "1990/01/01");
        minValues.put("gpa", "0.7");

        Hashtable<String, String> maxValues = new Hashtable<>();
        maxValues.put("id", "99-9999");
        maxValues.put("first_name", "zzzzzz");
        maxValues.put("last_name", "zzzzzz");
        maxValues.put("dob", "2000/12/31");
        maxValues.put("gpa", "5.0");

        dbApp.createTable(tableName, "id", htblColNameType, minValues, maxValues);
    }
    private static void createPCsTable(DBApp dbApp) throws Exception {
        // Integer CK
        String tableName = "pcs";

        Hashtable<String, String> htblColNameType = new Hashtable<String, String>();
        htblColNameType.put("pc_id", "java.lang.Integer");
        htblColNameType.put("student_id", "java.lang.String");


        Hashtable<String, String> minValues = new Hashtable<>();
        minValues.put("pc_id", "0");
        minValues.put("student_id", "43-0000");

        Hashtable<String, String> maxValues = new Hashtable<>();
        maxValues.put("pc_id", "20000");
        maxValues.put("student_id", "99-9999");

        dbApp.createTable(tableName, "pc_id", htblColNameType, minValues, maxValues);
    }
    private static void createCoursesTable(DBApp dbApp) throws Exception {
        // Date CK
        String tableName = "courses";

        Hashtable<String, String> htblColNameType = new Hashtable<String, String>();
        htblColNameType.put("date_added", "java.util.Date");
        htblColNameType.put("course_id", "java.lang.String");
        htblColNameType.put("course_name", "java.lang.String");
        htblColNameType.put("hours", "java.lang.Integer");


        Hashtable<String, String> minValues = new Hashtable<>();
        minValues.put("date_added", "1901/01/01");
        minValues.put("course_id", "0000");
        minValues.put("course_name", "AAAAAA");
        minValues.put("hours", "1");

        Hashtable<String, String> maxValues = new Hashtable<>();
        maxValues.put("date_added", "2020/12/31");
        maxValues.put("course_id", "9999");
        maxValues.put("course_name", "zzzzzz");
        maxValues.put("hours", "24");

        dbApp.createTable(tableName, "date_added", htblColNameType, minValues, maxValues);

    }
//    public void testWrongStudentsKeyInsertion() {
//        final DBApp dbApp = new DBApp();
//        dbApp.init();
//
//        String table = "students";
//        Hashtable<String, Object> row = new Hashtable();
//        row.put("id", 123);
//
//        row.put("first_name", "foo");
//        row.put("last_name", "bar");
//
//        Date dob = new Date(1995 - 1900, 4 - 1, 1);
//        row.put("dob", dob);
//        row.put("gpa", 1.1);
//
//        Assertions.assertThrows(DBAppException.class, () -> {
//                    dbApp.insertIntoTable(table, row);
//                }
//        );
//
//    }



    // this does whatever initialization you would like // or leave it empty if there is no code you want to
    // execute at application startup
    public void init() {

        // Loading configuration variable and creating metadata file.
        try {
            FileReader fr = new FileReader("src/main/resources/DBApp.config");
            Properties p = new Properties();
            p.load(fr);
            intMaxPageRows = Integer.parseInt(p.getProperty("MaximumRowsCountInTablePage"));
            MaximumEntriesInOctreeNode = Integer.parseInt(p.getProperty("MaximumEntriesInOctreeNode"));

            File storage = new File("storage");
            File tables = new File("storage/tables");
            File pages = new File("storage/pages");
            File indices = new File("storage/indices");
            if (!storage.exists()) {
                tables.mkdirs();
                pages.mkdirs();
                indices.mkdirs();
            }

            File meta = new File("storage/metadata.csv");
            if (!meta.exists()) meta.createNewFile();

        } catch (Exception e) {
            e.printStackTrace();
        }

        File folder = new File("storage/indices");
        File[] files = folder.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    String name = file.getName().substring(0, file.getName().length() - 4);
                    vectorLoadedIndices.add(loadIndex(name));
                }
            }
        }

    }


    // following method creates one table only
    // strClusteringKeyColumn is the name of the column that will be the primary
    // key and the clustering column as well. The data type of that column will
    // be passed in htblColNameType
    // htblColNameValue will have the column name as key and the data
    // type as value
    // htblColNameMin and htblColNameMax for passing minimum and maximum values
    // for data in the column. Key is the name of the column
    public void createTable(String strTableName, String strClusteringKeyColumn, Hashtable<String, String> htblColNameType, Hashtable<String, String> htblColNameMin, Hashtable<String, String> htblColNameMax) throws DBAppException {

        validateCreateTable(strTableName, htblColNameType, htblColNameMin, htblColNameMax);

        //Metadata file
        try {
            PrintWriter out = new PrintWriter(new FileWriter("storage/metadata.csv", true));
            Enumeration<String> e = htblColNameType.keys();

            while (e.hasMoreElements()) {
                String key = e.nextElement();
                String bool = key.equals(strClusteringKeyColumn) ? "True" : "False";
                String s = strTableName + "," + key + "," + htblColNameType.get(key) + "," + bool + "," + "null,null," + htblColNameMin.get(key) + "," + htblColNameMax.get(key) + "\n";
                out.append(s);
            }

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Table object
        Table tableNewTable = new Table(strTableName);
        saveTable(tableNewTable);

    }

    // following method creates an octree
    // depending on the count of column names passed.
    // If three column names are passed, create an octree.
    // If only one or two column names is passed, throw an Exception.
    public void createIndex(String strTableName, String[] strarrColName) throws DBAppException {
        if (strarrColName.length < 3 || strarrColName.length>3) throw new DBAppException("3 Columns required for Octree");

        for(Octree oct : getTableIndices(strTableName)){
            for(String s : strarrColName) {
                if(oct.vectorColumnNames.contains(s))throw new DBAppException("Column already included in an index !");
            }
        }
        for(String s: strarrColName) if(!getHtblColNameType(strTableName).containsKey(s))throw new DBAppException("Column does not exist !");

        if(strarrColName[0].equals(strarrColName[1]) || strarrColName[0].equals(strarrColName[2]) || strarrColName[1].equals(strarrColName[2]))throw new DBAppException("Can't trick me and use the same index twice !");

        Hashtable<String, String> htblColNameType = getHtblColNameType(strTableName);
        Hashtable<String, String> htblColNameMin = getHtblColNameMin(strTableName);
        Hashtable<String, String> htblColNameMax = getHtblColNameMax(strTableName);

        Object minX, maxX, minY, maxY, minZ, maxZ;
        minX = convertObject(htblColNameMin.get(strarrColName[0]), htblColNameType.get(strarrColName[0]));
        maxX = convertObject(htblColNameMax.get(strarrColName[0]), htblColNameType.get(strarrColName[0]));
        minY = convertObject(htblColNameMin.get(strarrColName[1]), htblColNameType.get(strarrColName[1]));
        maxY = convertObject(htblColNameMax.get(strarrColName[1]), htblColNameType.get(strarrColName[1]));
        minZ = convertObject(htblColNameMin.get(strarrColName[2]), htblColNameType.get(strarrColName[2]));
        maxZ = convertObject(htblColNameMax.get(strarrColName[2]), htblColNameType.get(strarrColName[2]));

        Octree oct = new Octree(minX, maxX, minY, maxY, minZ, maxZ, MaximumEntriesInOctreeNode, strarrColName);


        Table tableLoadedTable = loadTable(strTableName);

        String strClusteringKeyColumn = getClusteringKey(strTableName);

        for (String strPageReference : tableLoadedTable.vectorPageReferences) {
            Page pageLoadedPage = loadPage(strPageReference);
            for (Hashtable<String, Object> htblTuple : pageLoadedPage.vectorTuples) {
                oct.add(htblTuple.get(strarrColName[0]), htblTuple.get(strarrColName[1]), htblTuple.get(strarrColName[2]), strTableName + pageLoadedPage.intPageId, htblTuple.get(strClusteringKeyColumn));
            }
        }

        String strIndexName = strTableName + "_" + strarrColName[0] + "_" + strarrColName[1] + "_" + strarrColName[2];
        oct.strIndexName = strIndexName;

        try {
            File newMeta = new File("storage/metadata1.csv");
            newMeta.createNewFile();
            PrintWriter out = new PrintWriter(new FileWriter("storage/metadata1.csv", true));

            String csvFileName = "storage/metadata.csv";
            String line;
            BufferedReader stream = null;

            try {
                stream = new BufferedReader(new FileReader(csvFileName));
                while ((line = stream.readLine()) != null) {
                    String[] split = line.split(",");
                    if (split[0].equals(strTableName) && (split[1].equals(strarrColName[0]) || split[1].equals(strarrColName[1]) || split[1].equals(strarrColName[2]))) {
                        split[4] = strIndexName;
                        split[5] = "Octree";
                    }
                    String strTemp = "";
                    for (int i = 0; i < split.length; i++) {
                        strTemp += split[i] + ",";
                    }
                    out.append(strTemp.substring(0, strTemp.length() - 1) + "\n");
                }
            } finally {
                if (stream != null)
                    stream.close();
            }


            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File oldMeta = new File("storage/metadata.csv");
        oldMeta.delete();
        File newMeta = new File("storage/metadata1.csv");
        newMeta.renameTo(new File("storage/metadata.csv"));

        vectorLoadedIndices.add(oct);
        saveIndex(oct);


    }

    // following method inserts one row only.
    // htblColNameValue must include a value for the primary key
    public void insertIntoTable(String strTableName, Hashtable<String, Object> htblColNameValue) throws DBAppException {

        validateData(strTableName, htblColNameValue, 0);

        String strClusteringKeyColumn = getClusteringKey(strTableName);
        if (binarySearchTable(strTableName, htblColNameValue.get(strClusteringKeyColumn)) != null)
            throw new DBAppException("Primary key constraint violation!");

        Enumeration<String> e = getHtblColNameType(strTableName).keys();
        while (e.hasMoreElements()) {
            String strCurKey = e.nextElement();
            if (htblColNameValue.get(strCurKey) == null) htblColNameValue.put(strCurKey, new DBAppNull());
        }

        Table tableLoadedTable = loadTable(strTableName);
        if (tableLoadedTable.vectorPageReferences.size() == 0) {
            Page pageNewPage = new Page(strTableName, tableLoadedTable.intNewPageId);
            pageNewPage.vectorTuples.add(htblColNameValue);
            savePage(pageNewPage);

            tableLoadedTable.vectorPageReferences.add(strTableName + tableLoadedTable.intNewPageId);
            tableLoadedTable.intNewPageId++;
            saveTable(tableLoadedTable);
        } else {
            Vector<String> vectorPageReferences = tableLoadedTable.vectorPageReferences;
            boolean done = false;
            for (int i = 0; i < vectorPageReferences.size(); i++) {
                Page pageLoadedPage = loadPage(vectorPageReferences.get(i));
                int intIndex = binarySearchPage(strTableName, vectorPageReferences.get(i), htblColNameValue.get(strClusteringKeyColumn));
                if (intIndex < intMaxPageRows) {
                    insertInPage(htblColNameValue, pageLoadedPage, intIndex);
                    tableLoadedTable = loadTable(strTableName);
                    done = true;
                    savePage(pageLoadedPage);
                    break;
                }
            }
            if (!done) {
                Page pageLoadedPage = loadPage(vectorPageReferences.get(vectorPageReferences.size() - 1));
                if (pageLoadedPage.vectorTuples.size() < intMaxPageRows) {
                    pageLoadedPage.vectorTuples.add(htblColNameValue);
                    savePage(pageLoadedPage);
                } else {
                    Page pageNewPage = new Page(strTableName, tableLoadedTable.intNewPageId);
                    pageNewPage.vectorTuples.add(htblColNameValue);
                    savePage(pageNewPage);

                    tableLoadedTable.vectorPageReferences.add(strTableName + tableLoadedTable.intNewPageId);
                    tableLoadedTable.intNewPageId++;
                }
            }
            saveTable(tableLoadedTable);
        }

        Pair pairPageReference = binarySearchTable(strTableName, htblColNameValue.get(strClusteringKeyColumn));

        syncIndicesAfterInsert(strTableName,htblColNameValue,strTableName+pairPageReference.x);


    }

    // following method updates one row only
    // htblColNameValue holds the key and new value
    // htblColNameValue will not include clustering key as column name
    // strClusteringKeyValue is the value to look for to find the row to update.
    public void updateTable(String strTableName, String strClusteringKeyValue, Hashtable<String, Object> htblColNameValue) throws DBAppException {

        validateData(strTableName, htblColNameValue, 1);

        String strColNameToBeChanged;
        Object objNewValue;

        String strClusteringKey = getClusteringKey(strTableName);
        String strClusteringKeyType = getHtblColNameType(strTableName).get(strClusteringKey);
        Object objClusteringKeyValue = null;
        if (strClusteringKeyType.equals("java.lang.Integer"))
            objClusteringKeyValue = Integer.parseInt(strClusteringKeyValue);
        else if (strClusteringKeyType.equals("java.lang.Double"))
            objClusteringKeyValue = Double.parseDouble(strClusteringKeyValue);
        else if (strClusteringKeyType.equals("java.util.Date")) objClusteringKeyValue = new Date(strClusteringKeyValue);
        else objClusteringKeyValue = strClusteringKeyValue;

        Hashtable<String, Object> htblTuple = new Hashtable<>();
        Vector<String> vectorColumns = new Vector<>();
        vectorColumns.add(strClusteringKey);

        //Index Found
        if (getBestFitIndex(strTableName, vectorColumns) != null) {
            Octree octIndex = getBestFitIndex(strTableName, vectorColumns);

            Hashtable<String, Object> htblColNameValueOct = new Hashtable<>();
            htblColNameValueOct.put(strClusteringKey, objClusteringKeyValue);
            Vector<Entry> vectorEntries = octIndex.search(htblColNameValueOct, new String[]{"=", "=", "="});
            if (vectorEntries.size() == 0) return;

            String strPageReference = vectorEntries.get(0).references.get(0);
            int id = binarySearchPage(strTableName, strPageReference, objClusteringKeyValue);
            Page pageLoadedPage = loadPage(strPageReference);
            htblTuple = pageLoadedPage.vectorTuples.get(id);


            syncIndicesAfterUpdate(strTableName,htblTuple,htblColNameValue,strPageReference);

            //Modify Tuple
            Enumeration<String> e = htblColNameValue.keys();
            while (e.hasMoreElements()) {
                strColNameToBeChanged = e.nextElement();
                objNewValue = htblColNameValue.get(strColNameToBeChanged);
                htblTuple.replace(strColNameToBeChanged, objNewValue);
            }
            savePage(pageLoadedPage);

            return;
        }


        // No Index Found
        Pair pair = binarySearchTable(strTableName, objClusteringKeyValue);
        if (pair == null) return;

        Page pageLoadedPage = loadPage(strTableName + pair.x);
        htblTuple = pageLoadedPage.vectorTuples.get(pair.y);

        //Update indices
        syncIndicesAfterUpdate(strTableName,htblTuple,htblColNameValue,strTableName+pair.x);

        //Update tuple
        Enumeration<String> e = htblColNameValue.keys();
        while (e.hasMoreElements()) {
            strColNameToBeChanged = e.nextElement();
            objNewValue = htblColNameValue.get(strColNameToBeChanged);
            htblTuple.replace(strColNameToBeChanged, objNewValue);
        }
        savePage(pageLoadedPage);


    }

    // following method could be used to delete one or more rows.
    // htblColNameValue holds the key and value. This will be used in search
    // to identify which rows/tuples to delete.
    // htblColNameValue entries are ANDED together
    public void deleteFromTable(String strTableName, Hashtable<String, Object> htblColNameValue) throws DBAppException {

        validateData(strTableName, htblColNameValue, 2);

        String strClusteringKey = getClusteringKey(strTableName);


        Vector<String> vectorColumns = new Vector<>();
        Enumeration<String> e = htblColNameValue.keys();
        while (e.hasMoreElements()) {
            vectorColumns.add(e.nextElement());
        }
        if (getBestFitIndex(strTableName, vectorColumns) != null) {
            Vector<String> vectorPathsToBeDeleted = new Vector<>();
            Octree octIndex = getBestFitIndex(strTableName, vectorColumns);
            Vector<Entry> vectorEntries = octIndex.search(htblColNameValue, new String[]{"=", "=", "="});
            for (Entry e1 : vectorEntries) {

                int intRefSize = e1.references.size();
                for (int i = 0; i < intRefSize; i++) {
                    String strPageReference = e1.references.get(i);
                    Object objClusteringValue = e1.clusteringValues.get(i);

                    Page pageLoadedPage = loadPage(e1.references.get(i));
                    int intIndex = binarySearchPage(strTableName, strPageReference, objClusteringValue);
                    Hashtable<String, Object> htblTupleCandidate = pageLoadedPage.vectorTuples.get(intIndex);

                    boolean boolValidTuple = true;
                    Enumeration<String> k = htblColNameValue.keys();
                    while (k.hasMoreElements()) {
                        String strColName = k.nextElement();
                        if (!(htblColNameValue.get(strColName).equals(htblTupleCandidate.get(strColName)))) {
                            boolValidTuple = false;
                            break;
                        }
                    }

                    if (!boolValidTuple) continue;
                    pageLoadedPage.vectorTuples.remove(intIndex);

                    if (pageLoadedPage.vectorTuples.size() == 0) {
                        Table tableLoadedTable = loadTable(strTableName);
                        tableLoadedTable.vectorPageReferences.remove(strPageReference);
                        saveTable(tableLoadedTable);

                        String filename = "storage/pages/" + strTableName + pageLoadedPage.intPageId + ".ser"; // The file to be deleted
                        vectorPathsToBeDeleted.add(filename);
                    }
                    savePage(pageLoadedPage);
                    syncIndicesAfterDelete(strTableName,htblTupleCandidate);
                    i--;
                    intRefSize--;

                }


            }
            for (String s : vectorPathsToBeDeleted) {
                Path path = Paths.get(s);
                try {
                    Files.delete(path);
                } catch (IOException ee) {
                    ee.printStackTrace();
                }
            }
            return;
        }


        if (htblColNameValue.containsKey(strClusteringKey)) {
            Table tableLoadedTable = loadTable(strTableName);
            Pair pair = binarySearchTable(strTableName, htblColNameValue.get(strClusteringKey));
            if (pair == null) return;

            Page pageLoadedPage = loadPage(strTableName + pair.x);

            Hashtable<String, Object> htblTuple = pageLoadedPage.vectorTuples.get(pair.y);
            Enumeration<String> e3 = htblColNameValue.keys();
            while (e3.hasMoreElements()) {
                String strCurKey = e3.nextElement();
                if (!htblColNameValue.get(strCurKey).equals(htblTuple.get(strCurKey))) return;
            }

            syncIndicesAfterDelete(strTableName,htblTuple);

            if (pageLoadedPage.vectorTuples.size() == 1) {
                tableLoadedTable.vectorPageReferences.remove(strTableName + pageLoadedPage.intPageId);
                saveTable(tableLoadedTable);
                File f = new File("storage/pages/" + strTableName + pageLoadedPage.intPageId + ".ser");
                f.delete();
            } else {
                pageLoadedPage.vectorTuples.remove(pair.y);
                savePage(pageLoadedPage);
            }
        } else {
            Vector<String> toBeRemoved = new Vector<String>();
            Table tableLoadedTable = loadTable(strTableName);
            for (String s : tableLoadedTable.vectorPageReferences) {
                Page pageLoadedPage = loadPage(s);
                int j = pageLoadedPage.vectorTuples.size();
                for (int i = 0; i < j; i++) {
                    Hashtable<String, Object> htblTuple = pageLoadedPage.vectorTuples.get(i);
                    Enumeration<String> e4 = htblColNameValue.keys();
                    boolean boolSatisfies = true;
                    while (e4.hasMoreElements()) {
                        String strCurKey = e4.nextElement();
                        if (!htblColNameValue.get(strCurKey).equals(htblTuple.get(strCurKey))) boolSatisfies = false;
                    }
                    if (boolSatisfies) {
                        if (pageLoadedPage.vectorTuples.size() == 1) {
                            toBeRemoved.add(s);
                            File f = new File("storage/pages/" + strTableName + pageLoadedPage.intPageId + ".ser");
                            f.delete();
                        } else {
                            pageLoadedPage.vectorTuples.remove(i);
                            i--;
                            j--;
                            savePage(pageLoadedPage);
                        }
                        syncIndicesAfterDelete(strTableName,htblTuple);
                    }
                }

            }
            for (int i = 0; i < toBeRemoved.size(); i++)
                tableLoadedTable.vectorPageReferences.remove(toBeRemoved.get(i));
            saveTable(tableLoadedTable);
        }

    }

    public Iterator selectFromTable(SQLTerm[] arrSQLTerms, String[] strarrOperators) throws DBAppException {
        Vector<Hashtable<String, Object>> vectorResultSet = new Vector<>();
        if (arrSQLTerms.length == 0) throw new DBAppException("Array is empty !");

        boolean boolUseIndex = strarrOperators.length == 2;
        for (int i = 0; i < strarrOperators.length; i++)
            if (!strarrOperators[i].equals("AND")) {
                boolUseIndex = false;
                break;
            }

        String strTableName = arrSQLTerms[0]._strTableName;

        Vector<String> vectorColumnNames = new Vector<>();
        String[] strarrTermOperators = new String[arrSQLTerms.length];
        Hashtable<String, Object> htblColNameValue = new Hashtable<>();

        for (int i = 0; i < arrSQLTerms.length; i++) {
            vectorColumnNames.add(arrSQLTerms[i]._strColumnName);
            strarrTermOperators[i] = arrSQLTerms[i]._strOperator;
            htblColNameValue.put(arrSQLTerms[i]._strColumnName, arrSQLTerms[i]._objValue);
        }

        Octree oct = getExactIndex(strTableName, vectorColumnNames);

        if (boolUseIndex && oct != null) {
            Vector<Entry> vectorEntries = oct.search(htblColNameValue, strarrTermOperators);
            for (Entry e : vectorEntries) {
                for (int j = 0; j < e.references.size(); j++) {
                    String strReference = e.references.get(j);
                    Object objClusteringValue = e.clusteringValues.get(j);
                    Page pageLoadedPage = loadPage(strReference);
                    int intIndex = binarySearchPage(strTableName, strReference, objClusteringValue);
                    vectorResultSet.add(pageLoadedPage.vectorTuples.get(intIndex));
                }
            }
        } else {
            Vector<Vector<Hashtable<String, Object>>> vectorTermResultSets = new Vector<>();

            for (int i = 0; i < arrSQLTerms.length; i++) {
                vectorTermResultSets.add(linearSearch(strTableName, arrSQLTerms[i]._strColumnName, arrSQLTerms[i]._objValue, arrSQLTerms[i]._strOperator));
            }

            vectorResultSet = vectorTermResultSets.get(0);
            vectorTermResultSets.remove(0);

            for (int i = 0; i < strarrOperators.length; i++) {
                String strOperator = strarrOperators[i];
                Vector<Hashtable<String, Object>> vectorSecond = vectorTermResultSets.get(i);
                switch (strOperator) {
                    case "AND":
                        Vector<Object> toBeRemoved = new Vector<>();
                        for (Hashtable<String, Object> htblTuple : vectorResultSet) {
                            if (!vectorSecond.contains(htblTuple)) {
                                toBeRemoved.add(htblTuple);
                            }
                        }
                        for (Object o : toBeRemoved) vectorResultSet.remove(o);
                        break;
                    case "OR":
                        Vector<Hashtable<String, Object>> toBeAdded = new Vector<>();
                        for (Hashtable<String, Object> htblTuple : vectorSecond) {
                            if (!vectorResultSet.contains(htblTuple)) {
                                toBeAdded.add(htblTuple);
                            }
                        }
                        for (Hashtable<String, Object> o : toBeAdded) vectorResultSet.add(o);
                        break;
                    case "XOR":
                        Vector<Object> toBeRemoved1 = new Vector<>();
                        Vector<Hashtable<String, Object>> toBeAdded1 = new Vector<>();
                        for (Hashtable<String, Object> htblTuple : vectorSecond) {
                            if (!vectorResultSet.contains(htblTuple)) {
                                toBeAdded1.add(htblTuple);
                            } else {
                                toBeRemoved1.add(htblTuple);
                            }
                        }
                        for (Object o : toBeRemoved1) vectorResultSet.remove(o);
                        for (Hashtable<String, Object> o : toBeAdded1) vectorResultSet.add(o);
                        break;
                }
            }
        }
        return vectorResultSet.iterator();
    }

    // below method returns Iterator with result set if passed // strbufSQL is a select, otherwise returns null.
    public Iterator parseSQL(StringBuffer strbufSQL) throws DBAppException {

        CharStream cs = fromString(strbufSQL.toString());
        godfatherSqlLexer lexer = new godfatherSqlLexer(cs);
        CommonTokenStream token = new CommonTokenStream(lexer);
        godfatherSqlParser parser = new godfatherSqlParser(token);
        ParseTree tree = parser.pocket();

//        if(tree.)

        MyVisitor visitor = new MyVisitor(this);
        try {
            visitor.visit(tree);
        }
        catch(Exception e){
            throw new DBAppException("Invalid/Unsupported SQL Statement");
        }

        if (visitor.select) {
            return selectFromTable(visitor.arrSQLTerms, visitor.strarrOperators);
        } else if (visitor.delete) {
            deleteFromTable(visitor.strTableName, visitor.htblColNameValue);
            return null;
        } else if (visitor.createIndex) {
            String[] strarrColName = new String[visitor.vectorColNames.size()];
            for (int i = 0; i < strarrColName.length; i++) strarrColName[i] = visitor.vectorColNames.get(i);
            createIndex(visitor.strTableName, strarrColName);
        } else if (visitor.insert) {
            if (visitor.vectorColNames.size() != visitor.vectorColValues.size())
                throw new DBAppException("Invalid SQL Statement!");

            Hashtable<String, Object> htblColNameValue = new Hashtable<>();
            Vector<String> vectorColNames = visitor.vectorColNames;
            Vector<String> vectorColValues = visitor.vectorColValues;

            for (int i = 0; i < vectorColNames.size(); i++) {
                String strColName = vectorColNames.get(i);
                String strObj = vectorColValues.get(i);
                String strObjType = getColumnType(visitor.strTableName, strColName);
                Object objValue = convertObject(strObj, strObjType);

                htblColNameValue.put(strColName, objValue);
            }
            insertIntoTable(visitor.strTableName, htblColNameValue);
        } else if (visitor.createTable) {
            createTable(visitor.strTableName, visitor.strClusteringKeyColumn, visitor.htblColNameType, visitor.htblColNameMin, visitor.htblColNameMax);
        } else if (visitor.update) {
            if (getColumnType(visitor.strTableName, getClusteringKey(visitor.strTableName)).equals("java.lang.String"))
                if(visitor.strClusteringKeyValue.startsWith("\""))visitor.strClusteringKeyValue = visitor.strClusteringKeyValue.substring(1, visitor.strClusteringKeyValue.length() - 1);
            updateTable(visitor.strTableName, visitor.strClusteringKeyValue, visitor.htblColNameValue);
        } else {
            throw new DBAppException("Invalid Or Unsupported SQL Statement!");
        }
        return null;

    }

    private Vector<Octree> getTableIndices(String strTableName) {
        Vector<Octree> vectorResult = new Vector<>();
        for (int i = 0; i < vectorLoadedIndices.size(); i++) {

            Octree oct = vectorLoadedIndices.get(i);
            if (oct.strIndexName.startsWith(strTableName)) {
                vectorResult.add(oct);
            }

        }
        return vectorResult;
    }

    private Octree getExactIndex(String strTableName, Vector<String> vectorWantedColumns) {
        Vector<Octree> vectorCandidates = new Vector<>();

        for (int i = 0; i < vectorLoadedIndices.size(); i++) {
            Octree oct = vectorLoadedIndices.get(i);

            if (oct.strIndexName.startsWith(strTableName)) {
                int c = 0;
                for (int j = 0; j < vectorWantedColumns.size(); j++) {
                    if (oct.vectorColumnNames.contains(vectorWantedColumns.get(j))) c++;
                }
                if (c == 3) return oct;
            }
        }

        return null;
    }

    private Vector<Hashtable<String, Object>> linearSearch(String strTableName, String strColName, Object objValue, String strOperator) {
        Vector<Hashtable<String, Object>> vectorResultSet = new Vector<>();

        Table tableLoadedTable = loadTable(strTableName);
        for (String strPageReference : tableLoadedTable.vectorPageReferences) {
            Page pageLoadedPage = loadPage(strPageReference);
            for (Hashtable<String, Object> htblTuple : pageLoadedPage.vectorTuples) {
                Object objTupleValue = htblTuple.get(strColName);
                boolean conditionOne = true;
                switch (strOperator) {
                    case "=":
                        conditionOne = objTupleValue.equals(objValue);
                        break;
                    case "<":
                        conditionOne = lessThan(objTupleValue, objValue);
                        break;
                    case "<=":
                        conditionOne = lessThan(objTupleValue, objValue) || objTupleValue.equals(objValue);
                        break;
                    case ">":
                        conditionOne = (!lessThan(objTupleValue, objValue)) && (!objTupleValue.equals(objValue));
                        break;
                    case ">=":
                        conditionOne = !lessThan(objTupleValue, objValue);
                        break;
                    case "!=":
                        conditionOne = !objTupleValue.equals(objValue);
                        break;
                }
                if (conditionOne) vectorResultSet.add(htblTuple);
            }
        }
        return vectorResultSet;
    }

    private static boolean lessThan(Object one, Object two) {
        if (one instanceof Integer && two instanceof Integer) {
            return (int) one < (int) two;
        } else if (one instanceof Double && two instanceof Double) {
            return (double) one < (double) two;
        } else if (one instanceof String && two instanceof String) {
            if (((String) one).length() != ((String) two).length())
                return ((String) one).length() < ((String) two).length();
            else return ((String) one).compareTo((String) two) < 0;
        } else return ((Date) one).before((Date) two);

    }

    private static void savePage(Page page) {
        try {
            FileOutputStream fileOut = new FileOutputStream("storage/pages/" + page.strTableName + page.intPageId + ".ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(page);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void saveTable(Table table) {
        try {
            FileOutputStream fileOut = new FileOutputStream("storage/tables/" + table.strTableName + ".ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(table);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void saveIndex(Octree oct) {
        try {
            FileOutputStream fileOut = new FileOutputStream("storage/indices/" + oct.strIndexName + ".ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(oct);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static Table loadTable(String strTableName) {
        try {
            FileInputStream fileIn = new FileInputStream("storage/tables/" + strTableName + ".ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Table t = (Table) in.readObject();
            in.close();
            fileIn.close();
            return t;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Page loadPage(String strPageName) {
        try {
            FileInputStream fileIn = new FileInputStream("storage/pages/" + strPageName + ".ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Page p = (Page) in.readObject();
            in.close();
            fileIn.close();
            return p;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Octree loadIndex(String strIndexName) {
        try {
            FileInputStream fileIn = new FileInputStream("storage/indices/" + strIndexName + ".ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Octree oct = (Octree) in.readObject();
            in.close();
            fileIn.close();
            return oct;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void insertInPage(Hashtable<String, Object> htblColNameValue, Page page, int intIndex) {

        String strTableName = page.strTableName;
        String strClusteringKey = getClusteringKey(strTableName);

        Table tableLoadedTable = loadTable(page.strTableName);
        int intPageIndex = tableLoadedTable.vectorPageReferences.indexOf(page.strTableName + page.intPageId);

        if (page.vectorTuples.size() < intMaxPageRows) {
            page.vectorTuples.insertElementAt(htblColNameValue, intIndex);
            savePage(page);
        } else {

            Hashtable<String, Object> htblTupleShifted = page.vectorTuples.get(page.vectorTuples.size() - 1);
            page.vectorTuples.remove(page.vectorTuples.size() - 1);
            page.vectorTuples.insertElementAt(htblColNameValue, intIndex);
            savePage(page);

            boolean done = false;
            for (int i = intPageIndex + 1; i < tableLoadedTable.vectorPageReferences.size(); i++) {
                Page pageCurPage = loadPage(tableLoadedTable.vectorPageReferences.get(i));

                if (pageCurPage.vectorTuples.size() < intMaxPageRows) {
                    pageCurPage.vectorTuples.insertElementAt(htblTupleShifted, 0);
                    for (Octree oct : vectorLoadedIndices)
                        oct.updateReference(htblTupleShifted, htblTupleShifted.get(strClusteringKey), strTableName + pageCurPage.intPageId);
                    done = true;
                    savePage(pageCurPage);
                    break;
                } else {
                    Hashtable<String, Object> htblTupleShiftedNext = pageCurPage.vectorTuples.get(pageCurPage.vectorTuples.size() - 1);
                    pageCurPage.vectorTuples.remove(pageCurPage.vectorTuples.size() - 1);
                    pageCurPage.vectorTuples.insertElementAt(htblTupleShifted, 0);
                    for (Octree oct : vectorLoadedIndices)
                        oct.updateReference(htblTupleShifted, htblTupleShifted.get(strClusteringKey), strTableName + pageCurPage.intPageId);
                    htblTupleShifted = htblTupleShiftedNext;
                    savePage(pageCurPage);
                }

            }

            if (!done) {
                Page pageNewPage = new Page(tableLoadedTable.strTableName, tableLoadedTable.intNewPageId);
                pageNewPage.vectorTuples.add(htblTupleShifted);
                for (Octree oct : vectorLoadedIndices)
                    oct.updateReference(htblTupleShifted, htblTupleShifted.get(strClusteringKey), strTableName + pageNewPage.intPageId);
                savePage(pageNewPage);

                tableLoadedTable.vectorPageReferences.add(tableLoadedTable.strTableName + tableLoadedTable.intNewPageId);
                tableLoadedTable.intNewPageId++;
                saveTable(tableLoadedTable);
            }

        }
        saveTable(tableLoadedTable);

    }

    public static void printTable(String strTableName) {
        Table tableLoadedTable = loadTable(strTableName);
        for (int i = 0; i < tableLoadedTable.vectorPageReferences.size(); i++) {
            System.out.println("Page " + i);
            Page pageLoadedPage = loadPage(tableLoadedTable.vectorPageReferences.get(i));
            for (Hashtable<String, Object> htbl : pageLoadedPage.vectorTuples) {
                System.out.println(htbl);
            }
            System.out.println("-------------------------");
        }
    }

    // Returns vector containing htblColNameType, htblColNameMin, htblColNameMax and the Clustering Key in that order.
    private static Vector<Hashtable<String, String>> readCSV(String strTableName) throws IOException {

        String csvFileName = "storage/metadata.csv";
        String line;
        BufferedReader stream = null;
        Vector<Hashtable<String, String>> vectorCSVData = new Vector<>();
        vectorCSVData.add(new Hashtable<>());
        vectorCSVData.add(new Hashtable<>());
        vectorCSVData.add(new Hashtable<>());
        vectorCSVData.add(new Hashtable<>());

        try {
            stream = new BufferedReader(new FileReader(csvFileName));
            while ((line = stream.readLine()) != null) {
                String[] split = line.split(",");
                if (!split[0].equals(strTableName)) continue;
                vectorCSVData.get(0).put(split[1], split[2]);
                vectorCSVData.get(1).put(split[1], split[6]);
                vectorCSVData.get(2).put(split[1], split[7]);
                if (split[3].equals("True")) vectorCSVData.get(3).put("cluster", split[1]);
            }
        } finally {
            if (stream != null)
                stream.close();
        }

        return vectorCSVData;

    }

    private static Octree getBestFitIndex(String strTableName, Vector<String> vectorWantedColumns) {
        Vector<Octree> vectorCandidates = new Vector<>();

        for (int i = 0; i < vectorLoadedIndices.size(); i++) {
            Octree oct = vectorLoadedIndices.get(i);

            if (oct.strIndexName.startsWith(strTableName)) {
                int c = 0;
                for (int j = 0; j < vectorWantedColumns.size(); j++) {
                    if (oct.vectorColumnNames.contains(vectorWantedColumns.get(j))) c++;
                }
                if (c == 3) vectorCandidates.insertElementAt(oct, 0);
                else if (c > 0) vectorCandidates.add(oct);
                else if (vectorWantedColumns.size() == 0) vectorCandidates.add(oct);
            }
        }

        if (vectorCandidates.size() == 0) return null;
        else return vectorCandidates.get(0);
    }

    private static void validateCreateTable(String strTableName, Hashtable<String, String> htblColNameType, Hashtable<String, String> htblColNameMin, Hashtable<String, String> htblColNameMax) throws DBAppException {

        Vector<Hashtable<String, String>> vectorCSVData = null;
        try {
            vectorCSVData = readCSV(strTableName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (vectorCSVData.get(0).size() != 0) {
            throw new DBAppException("Table name already exists.");
        }

        if (!(htblColNameMax.size() == htblColNameMin.size() && htblColNameMin.size() == htblColNameType.size()))
            throw new DBAppException("Inconsistent Parameters !");

        Enumeration<String> e = htblColNameType.keys();
        while (e.hasMoreElements()) {
            String strCurKey = e.nextElement();
            if (!(htblColNameType.get(strCurKey).equals("java.lang.Integer") || htblColNameType.get(strCurKey).equals("java.lang.String") || htblColNameType.get(strCurKey).equals("java.lang.Double") || htblColNameType.get(strCurKey).equals("java.util.Date")))
                throw new DBAppException("Unsupported Types !");
            if (htblColNameMax.containsKey(strCurKey) && htblColNameMin.containsKey(strCurKey)) continue;
            else throw new DBAppException("Inconsistent Parameters!");
        }

    }

    private static void validateData(String strTableName, Hashtable<String, Object> htblColNameValue, int option) throws DBAppException {

        Vector<Hashtable<String, String>> vectorCSVData = null;
        try {
            vectorCSVData = readCSV(strTableName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (option == 0) {
            if (vectorCSVData.get(0).size() == 0) throw new DBAppException("Can't find table!");
            if (!htblColNameValue.containsKey(vectorCSVData.get(3).get("cluster")))
                throw new DBAppException("Must have a value for the primary key!");
        }
        if (vectorCSVData.get(0).size() == 0) throw new DBAppException("Can't find table!");
        Enumeration<String> e = htblColNameValue.keys();
        while (e.hasMoreElements()) {
            String strColName = e.nextElement();
            Object objValue = htblColNameValue.get(strColName);
            String strCorrectDataType = vectorCSVData.get(0).get(strColName);
            if (strCorrectDataType == null) throw new DBAppException("Invalid Column Name");
            if (objValue.getClass().getName().equals("Null")) continue;
            if (!objValue.getClass().getName().equals(strCorrectDataType))
                throw new DBAppException("Incompatible Data Types");
            if (option != 2) {
                if (objValue instanceof Integer) {
                    Integer intMin = Integer.parseInt(vectorCSVData.get(1).get(strColName));
                    Integer intMax = Integer.parseInt(vectorCSVData.get(2).get(strColName));
                    Integer intVal = (Integer) objValue;
                    if (!(intVal.compareTo(intMax) <= 0 && intVal.compareTo(intMin) >= 0))
                        throw new DBAppException("Value out of bounds!");
                } else if (objValue instanceof Double) {
                    Double doubleMin = Double.parseDouble(vectorCSVData.get(1).get(strColName));
                    Double doubleMax = Double.parseDouble(vectorCSVData.get(2).get(strColName));
                    Double doubleVal = (Double) objValue;
                    if (!(doubleVal.compareTo(doubleMax) <= 0 && doubleVal.compareTo(doubleMin) >= 0))
                        throw new DBAppException("Value out of bounds!");
                } else if (objValue instanceof Date) {
//                    System.out.println(vectorCSVData.get(1).get(strColName));
                    Date dateMin = new Date(vectorCSVData.get(1).get(strColName));
                    Date dateMax = new Date(vectorCSVData.get(2).get(strColName));
                    Date dateVal = (Date) objValue;
                    if (!(dateVal.compareTo(dateMax) <= 0 && dateVal.compareTo(dateMin) >= 0))
                        throw new DBAppException("Value out of bounds!");
                } else {
                    String strMin = vectorCSVData.get(1).get(strColName);
                    String strMax = vectorCSVData.get(2).get(strColName);
                    String strVal = (String) objValue;
                    if (lessThan(strVal, strMin) || lessThan(strMax, strVal))
                        throw new DBAppException("Value out of bounds!");
                }
            }

        }
    }


    private static Pair binarySearchTable(String strTableName, Object objClusteringValue) {
        Table tableLoadedTable = loadTable(strTableName);

        Vector<Hashtable<String, String>> vectorCSVData = null;
        try {
            vectorCSVData = readCSV(strTableName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String strClusteringKey = vectorCSVData.get(3).get("cluster");

        for (String s : tableLoadedTable.vectorPageReferences) {
            Page pageLoadedPage = loadPage(s);
            Vector<Hashtable<String, Object>> vectorTuples = pageLoadedPage.vectorTuples;
            int i = 0;
            int j = vectorTuples.size() - 1;

            while (i <= j) {
                int intMid = (i + j) / 2;
                if (vectorTuples.get(intMid).get(strClusteringKey).equals(objClusteringValue)) {
                    return new Pair(pageLoadedPage.intPageId, intMid);
                } else if (objClusteringValue instanceof Integer && ((Integer) objClusteringValue).compareTo((Integer) (vectorTuples.get(intMid).get(strClusteringKey))) > 0) {
                    i = intMid + 1;
                } else if (objClusteringValue instanceof Double && ((Double) objClusteringValue).compareTo((Double) (vectorTuples.get(intMid).get(strClusteringKey))) > 0) {
                    i = intMid + 1;
                } else if (objClusteringValue instanceof String && ((String) objClusteringValue).compareTo((String) (vectorTuples.get(intMid).get(strClusteringKey))) > 0) {
                    i = intMid + 1;
                } else if (objClusteringValue instanceof Date && ((Date) objClusteringValue).compareTo((Date) (vectorTuples.get(intMid).get(strClusteringKey))) > 0) {
                    i = intMid + 1;
                } else
                    j = intMid - 1;
            }
        }

        return null;
    }

    private static int binarySearchPage(String strTableName, String strPageReference, Object objClusteringValue) {
        Page pageLoadedPage = loadPage(strPageReference);

        Vector<Hashtable<String, String>> vectorCSVData = null;
        try {
            vectorCSVData = readCSV(strTableName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String strClusteringKey = vectorCSVData.get(3).get("cluster");

        Vector<Hashtable<String, Object>> vectorTuples = pageLoadedPage.vectorTuples;

        int i = 0;
        int j = vectorTuples.size() - 1;

        while (i <= j) {
            int intMid = (i + j) / 2;
            if (vectorTuples.get(intMid).equals(objClusteringValue)) return intMid;
            if (objClusteringValue instanceof Integer && ((Integer) objClusteringValue).compareTo((Integer) (vectorTuples.get(intMid).get(strClusteringKey))) > 0) {
                i = intMid + 1;
            } else if (objClusteringValue instanceof Double && ((Double) objClusteringValue).compareTo((Double) (vectorTuples.get(intMid).get(strClusteringKey))) > 0) {
                i = intMid + 1;
            } else if (objClusteringValue instanceof String && ((String) objClusteringValue).compareTo((String) (vectorTuples.get(intMid).get(strClusteringKey))) > 0) {
                i = intMid + 1;
            } else if (objClusteringValue instanceof Date && ((Date) objClusteringValue).compareTo((Date) (vectorTuples.get(intMid).get(strClusteringKey))) > 0) {
                i = intMid + 1;
            } else
                j = intMid - 1;
        }

        return i;

    }

    private static String getClusteringKey(String strTableName) {
        Vector<Hashtable<String, String>> vectorCSVData = null;
        try {
            vectorCSVData = readCSV(strTableName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return vectorCSVData.get(3).get("cluster");
    }

    private static Hashtable<String, String> getHtblColNameType(String strTableName) {
        Vector<Hashtable<String, String>> vectorCSVData = null;
        try {
            vectorCSVData = readCSV(strTableName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return vectorCSVData.get(0);
    }

    private static Hashtable<String, String> getHtblColNameMin(String strTableName) {
        Vector<Hashtable<String, String>> vectorCSVData = null;
        try {
            vectorCSVData = readCSV(strTableName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return vectorCSVData.get(1);
    }

    private static Hashtable<String, String> getHtblColNameMax(String strTableName) {
        Vector<Hashtable<String, String>> vectorCSVData = null;
        try {
            vectorCSVData = readCSV(strTableName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return vectorCSVData.get(2);
    }

    public static String getColumnType(String strTableName, String strColName) {
        try {
            return readCSV(strTableName).get(0).get(strColName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static Object convertObject(String strObject, String strType) {
        if (strType.equals("java.lang.Integer")) return Integer.parseInt(strObject);
        else if (strType.equals("java.lang.Double")) return Double.parseDouble(strObject);
        else if (strType.equals("java.util.Date")) return new Date(strObject);
        else {
            if (strObject.charAt(0) == ('"')) return strObject.substring(1, strObject.length() - 1);
            return strObject;
        }
    }

    private void syncIndicesAfterDelete(String strTableName, Hashtable<String,Object> htblTuple){
        String strClusteringKey = getClusteringKey(strTableName);

        for (Octree oct : getTableIndices(strTableName)) {
            oct.deleteTuple(htblTuple, htblTuple.get(strClusteringKey));
            saveIndex(oct);
        }

    }

    private void syncIndicesAfterUpdate(String strTableName, Hashtable<String,Object> htblOldTuple, Hashtable<String,Object> htblNewVals,String strPageReference){
        String strClusteringKey = getClusteringKey(strTableName);

        Object objClusteringKeyValue = htblOldTuple.get(strClusteringKey);
        for (Octree oct : getTableIndices(strTableName)) {
            oct.updateTuple(htblOldTuple, htblNewVals, objClusteringKeyValue, strPageReference);
            saveIndex(oct);
        }
    }

    private void syncIndicesAfterInsert(String strTableName,Hashtable<String,Object> htblTuple,String strPageReference){
        String strClusteringKeyColumn = getClusteringKey(strTableName);

        for (Octree octIndex : getTableIndices(strTableName)) {
            octIndex.add(htblTuple.get(octIndex.vectorColumnNames.get(0)), htblTuple.get(octIndex.vectorColumnNames.get(1)), htblTuple.get(octIndex.vectorColumnNames.get(2)), strPageReference, htblTuple.get(strClusteringKeyColumn));
            saveIndex(octIndex);
        }
    }




    private static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }
}
