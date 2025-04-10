package protocol;

public class ControlPacketTypes {

    int MQTT_HEADER_LEN = 2;
    int MQTT_ACK_LEN = 4;

    /*
     * Stub bytes, useful for generic replies, these represent the first byte in
     * the fixed header
     */
    final int CONNACK_BYTE =   0x20;
    final int PUBLISH_BYTE =   0x30;
    final int PUBACK_BYTE =    0x40;
    final int PUBREC_BYTE =    0x50;
    final int PUBREL_BYTE =    0x60;
    final int PUBCOMP_BYTE =   0x70;
    final int SUBACK_BYTE =    0x90;
    final int UNSUBACK_BYTE =  0xB0;
    final int PINGRESP_BYTE =  0xD0;


}
