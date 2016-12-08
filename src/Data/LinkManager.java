package Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import Links.CustomLink;
import Links.Link;
import Member.Member;

public class LinkManager implements Serializable{
	private static final long serialVersionUID = 3024903980256506458L;
	
	private HashMap<String, String> relationToClass;
    private static final LinkManager lm = new LinkManager();

    public static LinkManager getInstance(){
        return lm;
    }
    
    private LinkManager() {
        for(int i = 0; i < pLink.size(); i++){
            relationToClass.put(pLink.get(i), "ParentLink");
        }

        for(int i = 0; i < oLink.size(); i++){
            relationToClass.put(oLink.get(i), "OtherLink");
        }
        Iterator<String> iterator = cLink.iterator();
        while(iterator.hasNext()){
            relationToClass.put(iterator.next(), "CustomLink");
        }
    }

    private List<String> pLink = new ArrayList<String>(Arrays.asList("brother", "sister", "mother", "father", "cousin", "uncle", "aunt", "grandfather", "grandmother", "nephew", "niece", "daughter",
            "son", "married"));
    private List<String> oLink = new ArrayList<String>(Arrays.asList("friend", "mate", "classmate", "boyfriend", "girlfriend", "lover"));
    private List<String> cLink = new CustomLink().getCustomLink();

    
    public void createLink(Member source, Member target, String type) {
    	Link l1 = new Link(source,target,type);
    	Link l2 = new Link(target,source,type);
    	
    	if(!source.getLinks().contains(l1) && !target.getLinks().contains(l2)) {
    		source.getLinks().add(l1);
    		target.getLinks().add(l2);
    	}
    }

    public void addRelationnalCustomLink(String s) {
        if (!relationToClass.containsKey(s)) {
            this.oLink.add(s);
        }
    }

    public List<String> getParentLink(){
        return pLink;
    }

    public List<String> getOtherLink(){
        return this.oLink;
    }

}
