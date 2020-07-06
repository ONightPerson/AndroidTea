package com.liubz.androidtea.cherish.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * author: created by liubaozhu on 2020/7/4
 * email: liubaozhu@baidu.com
 */
public class DBTableCreator {

    public static void main(String[] args) {

        DBTable dbTable = Member.class.getAnnotation(DBTable.class);
        if (dbTable == null) {
            System.out.println("No DBTable annotation in class " + Member.class.getCanonicalName());
            return;
        }

        String tableName = dbTable.name();
        if (tableName.length() < 1) {
            tableName = Member.class.getName().toUpperCase();
        }

        List<String> columnDefs = new ArrayList<>();
        Field[] fields = Member.class.getDeclaredFields();
        for (Field f : fields) {
            System.out.println(f.getName());
            String columnName;
            Annotation[] anns = f.getAnnotations();
            System.out.println("anns length: " + anns.length);
            if (anns.length < 1) {
                continue;
            }
            if (anns[0] instanceof SQLInt) {
                SQLInt sInt = (SQLInt) anns[0];
                if (sInt.name().length() < 1) {
                    columnName = f.getName().toUpperCase();
                } else {
                    columnName = sInt.name();
                }
                columnDefs.add(columnName + " INT" + getConstraints(sInt.constraints()));
            } else if (anns[0] instanceof SQLText) {
                SQLText sStr = (SQLText) anns[0];
                if (sStr.name().length() < 1) {
                    columnName = f.getName().toUpperCase();
                } else {
                    columnName = sStr.name();
                }
                columnDefs.add(columnName + " TEXT" + getConstraints(sStr.constraints()));
            } else if (anns[0] instanceof SQLReal) {
                SQLReal sReal = (SQLReal) anns[0];
                if (sReal.name().length() < 1) {
                    columnName = f.getName().toUpperCase();
                } else {
                    columnName = sReal.name();
                }
                columnDefs.add(columnName + " REAL" + getConstraints(sReal.constraints()));
            } else if (anns[0] instanceof SQLBlob) {
                System.out.println("SQLBlob");
                SQLBlob sBlob = (SQLBlob) anns[0];
                if (sBlob.name().length() < 1) {
                    columnName = f.getName().toUpperCase();
                } else {
                    columnName = sBlob.name();
                }
                columnDefs.add(columnName + " BLOB" + getConstraints(sBlob.constraints()));
            }
        }

        StringBuilder sql = new StringBuilder();
        sql.append("CREATE TABLE IF NOT EXISTS ");
        sql.append(tableName + "(");
        for (String columnDef : columnDefs) {
            sql.append("\n    " + columnDef + ",");
        }
        // 去掉末尾逗号
        String tableCreate = sql.substring(0, sql.length() - 1) + ");";
        System.out.println("Table creation for " + Member.class.getName() + "\n" + tableCreate);

    }

    private static String getConstraints(Constraints con) {
        StringBuilder conBuilder = new StringBuilder();
        if (!con.allowNull()) {
            conBuilder.append(" NOT NULL");
        }
        if (con.primaryKey()) {
            conBuilder.append(" PRIMARY KEY");
        }
        if (con.unique()) {
            conBuilder.append(" UNIQUE");
        }
        return conBuilder.toString();
    }
}
