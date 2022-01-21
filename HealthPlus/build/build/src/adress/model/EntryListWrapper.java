package adress.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import adress.view.EntryTableData;

@XmlRootElement(name = "entries")
public class EntryListWrapper{

	private List<EntryTableData> entries;
	
    @XmlElement(name = "entry")
    public List<EntryTableData> getEntries() {
    	return entries;
    }

    public void setEntries(List<EntryTableData> data) {
        this.entries = data;
    }
}
