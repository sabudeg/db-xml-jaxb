package dbxml;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

@XmlRootElement
public class Schema {


    String schameName;


    public Schema(String schameName) {
        this.schameName = schameName;
    }

    public String getSchameName() {
        return schameName;
    }
    @XmlAttribute
    public void setSchameName(String schameName) {
        this.schameName = schameName;
    }



    ArrayList<Table> tableList = new ArrayList();

    public ArrayList getTableList() {
        return tableList;
    }


    @XmlElement(name = "table", type = Table.class)
    public void setTableList(ArrayList tableList) {
        this.tableList = tableList;
    }

    public Schema(){
    }

}
