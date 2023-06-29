This is a basic DBMS that uses SQL and supports the following operations : Create Table, Insert, Delete, Update, Select and Index Creation.

Usage example:


       DBApp db = new DBApp();
       db.init();
       
       db.parseSQL(new StringBuffer("create table Bonjour ( id INT check (id>=1 and id<=1000),name varchar check (name>=a and name<=zzzzz),gpa DOUBLE check (gpa>=0.7 and gpa<=4.0),dob DATE check (dob>=1990/01/01 and dob<=2023/05/16), PRIMARY KEY(id))"));

        db.parseSQL(new StringBuffer("create index indexName on Bonjour (name,gpa,id)"));

        for(int i=100;i<=199;i++) {
            double gpa = Math.random()*3 +1;
            db.parseSQL(new StringBuffer("insert into Bonjour (id,name,gpa,dob) values ("+i+",mada,"+gpa+",2003/05/18)"));
        }

        db.parseSQL(new StringBuffer("delete from Bonjour where dob=2003/05/18"));

        db.parseSQL(new StringBuffer("update Bonjour set (gpa=1.11) where id=1"));

        Iterator i = db.parseSQL(new StringBuffer("select * from Bonjour where gpa>=2.0 XOR id<=150 and id=151"));
        while(i.hasNext())System.out.println(i.next());

        System.out.println(vectorLoadedIndices.get(0));
        printTable("Bonjour");
