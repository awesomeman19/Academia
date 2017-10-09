package in.ac.gndec.academicportal;

import android.net.Uri;

public class Util {

    public static final int Dbversion=1;
    public static final String Db="Academic";
    public static final String table1="Students";
    public static final String table2="Teachers";

    public static final String name="Name";
    public static final String id="Mobile";
    public static final String password="Password";
    public static final String eclass="Class";

    public static final String query1="Create Table Students(\n" +
            "Mobile int primary key,\n" +
            "Name text,\n" +
            "Password text,\n" +
            "Class text\n" +
            ")";

    public static final String query2="Create Table Teachers(\n" +
            "Mobile int primary key,\n" +
            "Name text,\n" +
            "Password text\n" +
            ")";

    public static final  Uri u1=Uri.parse("content://in.ac.gndec.mr/"+table1);
    public static final  Uri u2=Uri.parse("content://in.ac.gndec.mr/"+table2);



}
