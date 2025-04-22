package protocol;

public class MqttSubscribe {

    private MqttHeader header;
    private int pktId;
    private int tuplesLen;

    static class Tuples{
        private int topicLength;
        private String topic;
        private int qos;
    }

}
