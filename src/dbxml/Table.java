package dbxml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Table {

String tableName;


    List<Column> columns = new ArrayList<>();

    public Table(String tableName) {
        this.tableName = tableName;
    }

    public String getTableName() {
        return tableName;
    }
    @XmlAttribute
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }


    public List<Column> getColumns() {
        return columns;
    }

    @XmlElement
    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

    public Table() {

    }



}
