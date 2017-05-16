package kealab.domain;

import java.util.List;

/**
 * Created by xthewiz on 5/16/2017 AD.
 */
public class DummyModel {

    private long id;
    private List<String> messages;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }
}
