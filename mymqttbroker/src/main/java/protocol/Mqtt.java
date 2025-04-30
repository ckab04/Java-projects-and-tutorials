package protocol;

public interface Mqtt {
    int mqttEncodeLength(String value, int type);
    long mqttDecodeLength(String value, int type);
    int unpackMqttPacket(String value, MqttPacket packet);
    String packMqttPacket(MqttPacket packet, int type);
}
