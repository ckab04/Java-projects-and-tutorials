package protocol;

public class MqttAck {
    private MqttHeader header;
    private int pktId;

    public MqttHeader getHeader() {
        return header;
    }
    public void setHeader(MqttHeader header) {
        this.header = header;
    }
    public int getPktId() {
        return pktId;
    }
}
