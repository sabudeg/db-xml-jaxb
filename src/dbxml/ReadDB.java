package dbxml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.sql.*;
import java.util.ArrayList;


public class ReadDB {

    static final String DB_URL = "jdbc:mysql://localhost:3306/okul";
    static final String USER = "root";
    static final String PASS = "";

    TableModel tm = new TableModel();   //rootelement
    static ReadDB testObj = new ReadDB();
    Schema schemaObj = new Schema("OKUL"); //db name



    void accesDB() {
        Connection conn = null;
        Statement stmt;
        Statement stmt2;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            System.out.println("Creating statement...");
            stmt = conn.createStatement();


            String query = "SHOW TABLES IN OKUL";
            ResultSet rs = stmt.executeQuery(query);


            while (rs.next()) {
                String tn = rs.getString("Tables_in_okul");
                Table tab = new Table(tn);
                schemaObj.tableList.add(tab);
            }

           for (Table tab : schemaObj.tableList) {
//               System.out.println(tab.getTableName());

                stmt2 = conn.createStatement();
                String query2 = "SHOW FIELDS from " + tab.getTableName() + "";        //retrieve coloumn attr
                ResultSet rs2 = stmt2.executeQuery(query2);

                while (rs2.next()) {
                    String field = rs2.getString("field");
                    String type = rs2.getString("Type");
                    String key = rs2.getString("key");
                    String def = rs2.getString("default");
                    String nullable = rs2.getString("null");


//                    System.out.println(field+type+def+nullable);

                    Column kolon = new Column();
                    kolon.setName(field);
                    kolon.setType(type.replaceAll("[^A-Za-z]", ""));
                    int size = Integer.parseInt(type.replaceAll("[^0-9.]", ""));
                    kolon.setSize(size);
                    kolon.setDef(def);
                    kolon.setNullable(Boolean.parseBoolean(nullable));

                    tab.columns.add(kolon);
                }

           }

            generate();

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try

    }

    public static void main(String[] args) {
        testObj.accesDB();
//        testObj.generate();

    }


    void generate() {

        tm.schemas.add(schemaObj);
        schemaObj.setTableList(schemaObj.tableList);


        try {

            File file = new File("./file.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(TableModel.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(tm, file);
            jaxbMarshaller.marshal(tm, System.out);

        } catch (JAXBException je) {

            je.printStackTrace();
        }
    }


}//end JDBCExample

