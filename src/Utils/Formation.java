package Utils;

import java.io.Serializable;
import java.util.ArrayList;

import Member.Member;

public class Formation implements Serializable{
	
	private static final long serialVersionUID = 4410636572584937846L;
	
	private ArrayList<Member> m_listMembers;
    private String m_formationName;

    public Formation() { this.m_listMembers = new ArrayList<Member>(); this.m_formationName = "undefined";}

    public Formation(ArrayList<Member> listMembers, String formationName) {
        this.m_listMembers = listMembers;
        this.m_formationName = formationName;
    }

  
    public ArrayList<Member> getListMembers() {
        return m_listMembers;
    }

  
    public void setm_listMembers(ArrayList<Member> listMembers) {
        this.m_listMembers = listMembers;
    }

 
    public void addMember(Member Member) {
        this.m_listMembers.add(Member);
    }

  
    public void delMember(Member Member) {
        this.m_listMembers.remove(Member);
    }

  
    public void addMembersMulti(ArrayList<Member> Members) {
        this.m_listMembers.addAll(Members);
    }

    public String getFormationName() {
        return m_formationName;
    }

  
    public void setFormationName(String formationName) {
        this.m_formationName = formationName;
    }

}
