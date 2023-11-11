package exercise;

import java.util.stream.Collectors;
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

//    Эталонное решение от учителя: (вместо getTagAttributes)
    public String stringifyAttributes() {
        return tagAttributes.keySet().stream()
                .map(key -> {
                    String value = tagAttributes.get(key);
                    return String.format(" %s=\"%s\"", key, value);
                })
                .collect(Collectors.joining(""));
    }



//
//    @Override
//    public String toString() {
//        return super.toString();
//    }
}
// END
