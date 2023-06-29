public class SQLTerm {
    String _strTableName;
    String _strColumnName;
    String _strOperator;
    Object _objValue;

    public String toString(){
       return _strTableName+": "+_strColumnName+_strOperator+_objValue.toString();
    }
}
