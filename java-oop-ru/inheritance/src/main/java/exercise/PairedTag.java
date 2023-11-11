package exercise;

import java.util.Map;
import java.util.List;
//import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    String tagBody;
    List<Tag> tagsList;

    PairedTag(String tagName, Map<String, String> tagAttributes, String tagBody, List<Tag> tagsList) {
        super(tagName, tagAttributes);
        this.tagBody = tagBody;
        this.tagsList = tagsList;
    }

    @Override
    public String toString() {
        Tag single = new SingleTag(getTagName(), getTagAttributes());
        String singleString = single.toString();

        StringBuilder result = new StringBuilder(singleString);

        result.append(tagBody);

        for (Tag tags : tagsList) {
            String tagsString = tags.toString();
            result.append(tagsString);
        }

        result.append("</");
        result.append(getTagName());
        result.append(">");

        return result.toString();
    }

//    Эталонное решение учителя:
//    public String toString() {
//        String attributes = stringifyAttributes();
//        String name = getName();
//        String value = children.stream()
//                .map(Object::toString)
//                .collect(Collectors.joining(""));
//
//        return String.format("<%s%s>%s%s</%s>", name, attributes, body, value, name);
//    }
}
// END
