package dbxml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;


@XmlRootElement(name="tableModel")
public class TableModel {


    @XmlElement(name="Schema")
    public List<Schema> schemas = new ArrayList<>();

    public TableModel() {
    }

}
