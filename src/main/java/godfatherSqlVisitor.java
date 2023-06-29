// Generated from /Users/mshereef/Desktop/Uni/Sem6/Databases 2/database-engine/src/main/java/godfatherSql.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link godfatherSqlParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface godfatherSqlVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link godfatherSqlParser#pocket}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPocket(godfatherSqlParser.PocketContext ctx);
	/**
	 * Visit a parse tree produced by {@link godfatherSqlParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(godfatherSqlParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link godfatherSqlParser#createIndex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateIndex(godfatherSqlParser.CreateIndexContext ctx);
	/**
	 * Visit a parse tree produced by {@link godfatherSqlParser#createTable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTable(godfatherSqlParser.CreateTableContext ctx);
	/**
	 * Visit a parse tree produced by {@link godfatherSqlParser#insert}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsert(godfatherSqlParser.InsertContext ctx);
	/**
	 * Visit a parse tree produced by {@link godfatherSqlParser#delete}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDelete(godfatherSqlParser.DeleteContext ctx);
	/**
	 * Visit a parse tree produced by {@link godfatherSqlParser#select}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelect(godfatherSqlParser.SelectContext ctx);
	/**
	 * Visit a parse tree produced by {@link godfatherSqlParser#update}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdate(godfatherSqlParser.UpdateContext ctx);
	/**
	 * Visit a parse tree produced by {@link godfatherSqlParser#columnNames}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnNames(godfatherSqlParser.ColumnNamesContext ctx);
	/**
	 * Visit a parse tree produced by {@link godfatherSqlParser#columnValues}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnValues(godfatherSqlParser.ColumnValuesContext ctx);
	/**
	 * Visit a parse tree produced by {@link godfatherSqlParser#columnDefinitions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnDefinitions(godfatherSqlParser.ColumnDefinitionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link godfatherSqlParser#columnName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnName(godfatherSqlParser.ColumnNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link godfatherSqlParser#columnValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnValue(godfatherSqlParser.ColumnValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link godfatherSqlParser#columnDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnDefinition(godfatherSqlParser.ColumnDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link godfatherSqlParser#updateValueList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateValueList(godfatherSqlParser.UpdateValueListContext ctx);
	/**
	 * Visit a parse tree produced by {@link godfatherSqlParser#updateValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateValue(godfatherSqlParser.UpdateValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link godfatherSqlParser#columnType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnType(godfatherSqlParser.ColumnTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link godfatherSqlParser#booleanExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanExpression(godfatherSqlParser.BooleanExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link godfatherSqlParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator(godfatherSqlParser.OperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link godfatherSqlParser#compare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompare(godfatherSqlParser.CompareContext ctx);
	/**
	 * Visit a parse tree produced by {@link godfatherSqlParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(godfatherSqlParser.ConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link godfatherSqlParser#indexName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexName(godfatherSqlParser.IndexNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link godfatherSqlParser#tableName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableName(godfatherSqlParser.TableNameContext ctx);
}