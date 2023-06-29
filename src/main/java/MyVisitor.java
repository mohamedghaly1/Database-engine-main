import org.antlr.v4.runtime.tree.ParseTree;

import java.util.Hashtable;
import java.util.Vector;

public class MyVisitor extends godfatherSqlBaseVisitor{

    DBApp db = null;

    boolean createTable;
    boolean insert;
    boolean update;
    boolean delete;
    boolean select;
    boolean createIndex;

    String strTableName;

    Vector<SQLTerm> vectorSQLTerms;
    Vector<String> vectorOperators;
    SQLTerm [] arrSQLTerms;
    String [] strarrOperators;

    Hashtable<String,Object> htblColNameValue;

    Vector<String> vectorColNames;
    Vector<String> vectorColValues;

    Hashtable<String,String> htblColNameMax;
    Hashtable<String,String> htblColNameMin;
    Hashtable<String,String> htblColNameType;
    String strClusteringKeyColumn;
    String strClusteringKeyValue;


    public MyVisitor(DBApp db){
        super();
        this.db = db;
        htblColNameValue = new Hashtable<>();
        vectorColNames = new Vector<>();
        vectorColValues = new Vector<>();
        htblColNameMin = new Hashtable<>();
        htblColNameType = new Hashtable<>();
        htblColNameMax = new Hashtable<>();
    }

    public Object visitUpdate(godfatherSqlParser.UpdateContext ctx) {
        update=true;
        strTableName = ctx.tableName().IDENTIFIER().getText();
        strClusteringKeyValue = ctx.constant().getText();
        return visitChildren(ctx);
    }

    public Object visitCreateTable(godfatherSqlParser.CreateTableContext ctx) {
        createTable=true;
        strTableName = ctx.tableName().IDENTIFIER().getText();
        return visitChildren(ctx);
    }

    public Object visitInsert(godfatherSqlParser.InsertContext ctx){
        insert=true;

        strTableName = ctx.tableName().IDENTIFIER().getText();
        return visitChildren(ctx);
    }

    public Object visitCreateIndex(godfatherSqlParser.CreateIndexContext ctx) {
        createIndex=true;

        strTableName = ctx.tableName().IDENTIFIER().getText();

        return visitChildren(ctx);
    }

    public Object visitSelect(godfatherSqlParser.SelectContext ctx) {
        select=true;
        vectorSQLTerms = new Vector<>();
        vectorOperators = new Vector<>();

        strTableName = ctx.tableName().IDENTIFIER().getText();
        extractBooleanExpressionSelect(ctx.booleanExpression());

        arrSQLTerms = new SQLTerm[vectorSQLTerms.size()];
        strarrOperators = new String[vectorOperators.size()];

        for(int i=0;i<arrSQLTerms.length;i++)arrSQLTerms[i]=vectorSQLTerms.get(i);
        for(int i=0;i<strarrOperators.length;i++)strarrOperators[i]=vectorOperators.get(i);

        return visitChildren(ctx);
    }

    public Object visitDelete(godfatherSqlParser.DeleteContext ctx) {
        delete=true;
        htblColNameValue = new Hashtable<>();

        strTableName = ctx.tableName().IDENTIFIER().getText();
        extractBooleanExpressionDelete(ctx.booleanExpression());


        return visitChildren(ctx);
    }

    public Object visitColumnDefinition(godfatherSqlParser.ColumnDefinitionContext ctx) {
        if(ctx.PRIMARY()!=null){
            strClusteringKeyColumn = ctx.columnName(0).IDENTIFIER().getText();
        }
        else{
            String colName = ctx.columnName(0).IDENTIFIER().getText();
            String colMin = ctx.constant(0).getText();
            String colMax = ctx.constant(1).getText();
            String colType = ctx.columnType().getText();

            String actualType=null;
            if(colType.toLowerCase().equals("int"))actualType="java.lang.Integer";
            if(colType.toLowerCase().equals("double"))actualType="java.lang.Double";
            if(colType.toLowerCase().equals("date"))actualType="java.util.Date";
            if(colType.toLowerCase().equals("varchar"))actualType="java.lang.String";

            if(actualType.equals("java.lang.String")&&colMin.startsWith("\"")){
                colMin = colMin.substring(1,colMin.length()-1);
                colMax = colMax.substring(1,colMax.length()-1);
            }

            htblColNameMax.put(colName,colMax);
            htblColNameMin.put(colName,colMin);
            htblColNameType.put(colName,actualType);
        }
        return visitChildren(ctx);
    }

    public Object visitColumnName(godfatherSqlParser.ColumnNameContext ctx){
        vectorColNames.add(ctx.IDENTIFIER().getText());
        return visitChildren(ctx);
    }

    public Object visitColumnValue(godfatherSqlParser.ColumnValueContext ctx){
        vectorColValues.add(ctx.constant().getText());
        return visitChildren(ctx);
    }

    public Object visitUpdateValue(godfatherSqlParser.UpdateValueContext ctx) {
        String strColName = ctx.columnName().IDENTIFIER().getText();
        String strObj = ctx.constant().getText();
        Object objValue = db.convertObject(strObj,DBApp.getColumnType(strTableName,strColName));
        htblColNameValue.put(strColName,objValue);
        return visitChildren(ctx);
    }






    public void extractBooleanExpressionSelect(godfatherSqlParser.BooleanExpressionContext ctx){
        if(ctx==null)return;

        if(ctx.IDENTIFIER()!=null){
            SQLTerm term = new SQLTerm();
            term._strTableName=strTableName;
            term._strColumnName=ctx.IDENTIFIER().getText();
            term._strOperator = ctx.compare().getText();
            term._objValue = db.convertObject(ctx.constant().getText(),db.getColumnType(strTableName,term._strColumnName));
            vectorSQLTerms.add(term);
        }
        else{
            extractBooleanExpressionSelect(ctx.left);
            vectorOperators.add(ctx.operator().getText().toUpperCase());
            extractBooleanExpressionSelect(ctx.right);
        }

    }

    public void extractBooleanExpressionDelete(godfatherSqlParser.BooleanExpressionContext ctx){

        if(ctx.IDENTIFIER()!=null){
            String strColName=ctx.IDENTIFIER().getText();
            Object objValue = db.convertObject(ctx.constant().getText(),db.getColumnType(strTableName,strColName));
            htblColNameValue.put(strColName,objValue);
        }
        else{
            extractBooleanExpressionDelete(ctx.left);
            extractBooleanExpressionDelete(ctx.right);
        }

    }



}
