package com.android.liubz.androidtea.java.annotation;

/**
 * author: created by liubaozhu on 2020/7/4
 * email: liubaozhu@baidu.com
 */
@DBTable(name = "Member")
public class Member {

    @SQLText(name = "first_name")
    private String firstName;
    @SQLText(name = "last_name", constraints = @Constraints(allowNull = false))
    private String lastName;
    @SQLInt
    private int age;
    @SQLText(constraints = @Constraints(primaryKey = true))
    private String handle;
    @SQLReal
    private float weight;
    @SQLBlob
    private int portrait;

    private static int memberCount;

    public String getHandle() {
        return handle;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

}
