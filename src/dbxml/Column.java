package dbxml;

import com.sun.xml.internal.txw2.annotation.XmlElement;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"name", "type", "size", "def", "nullable"})
@XmlElement
public class Column extends Table {


    String name;
    String type;
    int size;
    String def;
    boolean nullable;


    public String getName() {
        return name;
    }

    @XmlAttribute
    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    @XmlAttribute
    public void setType(String type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    @XmlAttribute
    public void setSize(int size) {
        this.size = size;
    }

    public String getDef() {
        return def;
    }

    @XmlAttribute
    public void setDef(String def) {
        this.def = def;
    }

    public boolean isNullable() {
        return nullable;
    }

    @XmlAttribute
    public void setNullable(boolean nullable) {
        this.nullable = nullable;
    }


}
