package exercise;

// BEGIN
public class LabelTag implements TagInterface {
    private String tag;
    private TagInterface wrappee;

    public LabelTag(String tag, TagInterface wrappee) {
        this.tag = tag;
        this.wrappee = wrappee;
    }

    @Override
    public String render() {
        return String.format("<label>" + tag + wrappee.render() + "</label>");
    }
}
// END
