package protocol;

public class AckPackets {

    private MqttAck mqttPuback;
    private MqttAck mqttPubrec;
    private MqttAck mqttPubrel;
    private MqttAck mqttPubcomp;
    private MqttAck mqttUnSuback;
    private MqttAck mqttPingresp;
    private MqttAck mqttDisconnect;
    private MqttAck mqttPingreq;

    public MqttAck getMqttPuback() {
        return mqttPuback;
    }

    public void setMqttPuback(MqttAck mqttPuback) {
        this.mqttPuback = mqttPuback;
    }

    public MqttAck getMqttPubrec() {
        return mqttPubrec;
    }

    public void setMqttPubrec(MqttAck mqttPubrec) {
        this.mqttPubrec = mqttPubrec;
    }

    public MqttAck getMqttPubrel() {
        return mqttPubrel;
    }

    public void setMqttPubrel(MqttAck mqttPubrel) {
        this.mqttPubrel = mqttPubrel;
    }

    public MqttAck getMqttPubcomp() {
        return mqttPubcomp;
    }

    public void setMqttPubcomp(MqttAck mqttPubcomp) {
        this.mqttPubcomp = mqttPubcomp;
    }

    public MqttAck getMqttUnSuback() {
        return mqttUnSuback;
    }

    public void setMqttUnSuback(MqttAck mqttUnSuback) {
        this.mqttUnSuback = mqttUnSuback;
    }

    public MqttAck getMqttPingresp() {
        return mqttPingresp;
    }

    public void setMqttPingresp(MqttAck mqttPingresp) {
        this.mqttPingresp = mqttPingresp;
    }

    public MqttAck getMqttDisconnect() {
        return mqttDisconnect;
    }

    public void setMqttDisconnect(MqttAck mqttDisconnect) {
        this.mqttDisconnect = mqttDisconnect;
    }

    public MqttAck getMqttPingreq() {
        return mqttPingreq;
    }

    public void setMqttPingreq(MqttAck mqttPingreq) {
        this.mqttPingreq = mqttPingreq;
    }
}
