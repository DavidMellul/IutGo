package Links;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Utils.Util;

public class CustomLink extends Link implements Serializable {
	private static final long serialVersionUID = -2804961861766509495L;
	
	private List<String> cLink = new ArrayList<String>();

    public CustomLink() {

    }

    public boolean existCustomLink(String s) {
        if (cLink.contains(s)) {
            return true;
        }
        else {
            return false;
        }
    }

    public List<String> getCustomLink() {
        return this.cLink;
    }
}
