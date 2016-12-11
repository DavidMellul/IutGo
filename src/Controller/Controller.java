package Controller;


import java.util.ArrayList;

import Data.LinkManager;
import Data.SerialManager;
import Member.Member;
import Ui.Application;
import Ui.Form;
import Utils.Address;
import Utils.Formation;
import Utils.Mood;

public class Controller {
	// ----------------------------------------- Modèle --------------------------------------
	private Member m_currentMember;
	private ArrayList<Member> m_members;
	
	// ---------------------------------------- Vues -----------------------------------------
	private Form m_startScreen;
	private Application m_appScreen;
	
	// ---------------------------------------- Singleton -----------------------------------
	private static Controller m_controller = new Controller();
	
	private Controller() {
		this.m_members = SerialManager.getAllMembers();
		this.m_startScreen = new Form();
	}
	public static Controller getInstance() { return m_controller; }
	
	// --------------------------------------- Accesseurs -----------------------------------
	public ArrayList<Member> getMembers() { return this.m_members; }
	
	public void setCurrentMember(Member m) { this.m_currentMember = m; }
	public Member getCurrentMember() { return this.m_currentMember; }
	
	// -------------------------------------- Méthode --------------------------------------
	public void start() {
		this.m_startScreen.setVisible(true);
	}
	
	public void registerMember(String login, String pass, String lastname, String firstname) {
		Member m = new Member();
		m.setFirstname(firstname);
		m.setLastname(lastname);
		m.setLogin(login);
		m.setPassword(pass);
		SerialManager.save(m, m.getId()+".dat");
		this.m_members.add(m);
	}
	
	public boolean canLogMember(String login, String pass) {
		Member memberTest = null;
		for(Member m : this.m_members) {
			if(m.getLogin().equals(login) && m.getPassword().equals(pass)) {
				memberTest = m;
				break;
			}
		}
		if(memberTest != null) {
			this.m_currentMember = memberTest;
			this.m_currentMember.recordPosition();
			this.m_startScreen.dispose();
			this.m_appScreen = new Application();
			this.m_appScreen.setVisible(true);
		}
		return memberTest != null;
	}
	
	public boolean canAddRelation(String firstname, String lastname, String kindOfRelation) {
		Member relationToAdd = null;
		String fnCompared = firstname.toUpperCase();
		String lnCompared = lastname.toUpperCase();
		for(Member m : this.m_members) {
			String fnToCompare = m.getFirstname().toUpperCase(); 
			String lnToCompare = m.getLastname().toUpperCase(); 
			if(fnToCompare.equals(fnCompared) && lnToCompare.equals(lnCompared) && m != this.m_currentMember) {
				relationToAdd = m;
				LinkManager lm = LinkManager.getInstance();
				lm.createLink(this.m_currentMember, m, kindOfRelation);
				break;
			}
		}
		return relationToAdd != null;
	}
	
	public String giveBackPassword(String firstname, String lastname) {
		String passToGive = new String();
		for(Member m : this.m_members) {
			if(m.getFirstname().toUpperCase().equals(firstname.toUpperCase()))
					if(m.getLastname().toUpperCase().equals(lastname.toUpperCase()))
					{ passToGive = m.getPassword(); break; }
		}
		return passToGive;
	}
	
	public void fillInformationsForMember(String nick, String formation, Mood m, String add) {
		this.m_currentMember.setNickname(nick);
		this.m_currentMember.setFormation(new Formation(formation));
		this.m_currentMember.setMood(m);
		this.m_currentMember.setAddress(new Address(add));
	}
	
	public void serializeAllBeforeClose() {
		for(Member m : this.m_members) {
			SerialManager.save(m, m.getId()+".dat");
		}
	}
}
