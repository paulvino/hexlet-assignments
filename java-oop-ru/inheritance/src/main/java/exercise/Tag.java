package exercise;

//import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public class Tag {
    String tagName;
    Map<String, String> tagAttributes;

    Tag(String tagName, Map<String, String> tagAttributes) {
        this.tagName = tagName;
        this.tagAttributes = tagAttributes;
    }

    public String getTagName() {
        return tagName;
    }

    public Map<String, String> getTagAttributes() {
        return tagAttributes;
    }
//
//    @Override
//    public String toString() {
//        return super.toString();
//    }
}
// END
