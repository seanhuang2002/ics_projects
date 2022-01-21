package adress.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/*
 * Pour permettre de sauvegarder les informations
 * des membres dans un fichier XML
 */
@XmlRootElement(name = "members")
public class MemberListWrapper 
{
	 private List<Member> members;

	    @XmlElement(name = "member")
	    public List<Member> getMembers() 
	    {
	        return members;
	    }

	    public void setMembers(List<Member> members) 
	    {
	        this.members = members;
	    }
}
