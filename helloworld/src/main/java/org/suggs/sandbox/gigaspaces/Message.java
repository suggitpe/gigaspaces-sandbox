package org.suggs.sandbox.gigaspaces;

import com.gigaspaces.annotation.pojo.SpaceRouting;

/**
 * User: suggitpe
 * Date: 22/06/12
 * Time: 07:50
 */
public class Message {

    private Integer id;
    private String info;

    public Message() {
    }

    public Message(Integer aId, String aInfo) {
        id = aId;
        info = aInfo;
    }

    @SpaceRouting
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        if (id != null ? !id.equals(message.id) : message.id != null) return false;
        if (info != null ? !info.equals(message.info) : message.info != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (info != null ? info.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", info='" + info + '\'' +
                '}';
    }
}
