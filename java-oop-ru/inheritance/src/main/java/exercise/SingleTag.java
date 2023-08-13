package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {

    SingleTag(String tagName, Map<String, String> tagAttributes) {
        super(tagName, tagAttributes);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("<");

        result.append(getTagName());

        Map<String, String> attributes = getTagAttributes();

        for (String key: attributes.keySet()) {
            result.append(" ");
            result.append(key);
            result.append("=\"");
            result.append(attributes.get(key));
            result.append("\"");
        }

        result.append(">");

        return result.toString();
    }
}
// END
