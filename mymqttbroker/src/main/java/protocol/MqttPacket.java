package protocol;

public class MqttPacket {
    private MqttHeader header;
    private MqttConnect connect;
    private MqttPublish publish;
    private MqttSubscribe subscribe;
    private MqttUnsubscribe unsubscribe;
    private MqttSuback suback;
    private MqttConnack connack;
    private MqttAck ack;
}
