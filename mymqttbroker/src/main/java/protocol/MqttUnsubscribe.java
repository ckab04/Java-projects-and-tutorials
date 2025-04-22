package protocol;

public class MqttUnsubscribe {
    private MqttHeader header;
    private int pktId;
    private int tuplesLen;

    static class Tuples{
        private int topicLength;
        private String topic;
    };

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

    public int getTuplesLen() {
        return tuplesLen;
    }

    public void setTuplesLen(int tuplesLen) {
        this.tuplesLen = tuplesLen;
    }
}
