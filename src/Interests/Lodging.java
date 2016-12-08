package Interests;

import java.io.Serializable;

public class Lodging implements Serializable{
	private static final long serialVersionUID = 4874444450197107783L;
	public float m_nightCost;
	public String m_name;

	public Lodging(float cost, String name) {
		this.m_nightCost = cost;
		this.m_name = name;
	}

	public float getNightCost() {
		return this.m_nightCost;
	}

	public void setNightCost(float cost) {
		this.m_nightCost = cost;
	}

	public void setName(String name) {
		this.m_name = name;
	}

	public String getName() {
		return this.m_name;
	}

	public String toString() {
		return "Lodging " + this.m_name + " : " + this.m_nightCost + " euros/night.";
	}
}
