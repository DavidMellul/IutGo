package Links;

import java.io.Serializable;
import java.util.List;

import Utils.Util;

public class CustomLink extends Link implements Serializable {
    private List<String> cLink = Util.getProhibitedWords();

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
