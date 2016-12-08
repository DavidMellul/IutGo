package Links;

import java.io.Serializable;

import Member.Member;

public class Link implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = -5513867918008487455L;
	private Member m_member1;
	private Member m_member2;
	private String m_type;

	public Link() {
		this.m_member1 = null;
		this.m_member2 = null;
		this.m_type = "undefined";
	}

	public Link(Member m1, Member m2, String t) {
		this.m_member1 = m1;
		this.m_member2 = m2;
		this.m_type = t;

	}

	public Member getMember2() {
		return this.m_member2;
	}

	public Member getMember1() {
		return this.m_member1;
	}

	public String getType() {
		return this.m_type;
	}

	@Override
	public String toString() {
		return this.m_member1 + " is " + this.m_type + " of " + this.m_member2;
	}
}
