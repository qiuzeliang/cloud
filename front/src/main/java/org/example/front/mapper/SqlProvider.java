package org.example.front.mapper;

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.expr.SQLBinaryOpExpr;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlSelectQueryBlock;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlASTVisitorAdapter;
import org.apache.ibatis.builder.annotation.ProviderContext;

import java.util.Map;

public class SqlProvider extends MySqlASTVisitorAdapter {

    public static String insert(Object params, ProviderContext context) {
       return "insert into";
    }

    public static String provideSql(Object params, ProviderContext context) {
        DynamicSql dynamicSql = context.getMapperMethod().getAnnotation(DynamicSql.class);
        SQLStatement sqlStatement = SQLUtils.parseSingleMysqlStatement(dynamicSql.value());
        SqlProvider visitor = new SqlProvider();
        sqlStatement.accept(visitor);
        System.out.println(sqlStatement.toLowerCaseString());
        return sqlStatement.toLowerCaseString();
    }

    @Override
    public boolean visit(MySqlSelectQueryBlock x) {
        SQLBinaryOpExpr expr = (SQLBinaryOpExpr) x.getWhere();
        x.removeCondition(expr.getRight());
        return super.visit(x);
    }
}
