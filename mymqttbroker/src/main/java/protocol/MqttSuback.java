package protocol;

public class MqttSuback {

    private MqttHeader header;
    private int pktId;
    private int rcslen;
    private String rcs;

    public MqttHeader getHeader() {
        return header;
    }

    public void setHeader(MqttHeader header) {
        this.header = header;
    }

    public int getPktId() {
        return pktId;
    }

    public void setPktId(int pktId) {
        this.pktId = pktId;
    }

    public int getRcslen() {
        return rcslen;
    }

    public void setRcslen(int rcslen) {
        this.rcslen = rcslen;
    }

    public String getRcs() {
        return rcs;
    }

    public void setRcs(String rcs) {
        this.rcs = rcs;
    }
}
