package protocol;

public enum PacketTypes {

    /* Message types */
    CONNECT(1),
    CONNACK(2),
    PUBLISH     (3),
    PUBACK      (4),
    PUBREC      (5),
    PUBREL      (6),
    PUBCOMP     (7),
    SUBSCRIBE   (8),
    SUBACK      (9),
    UNSUBSCRIBE (10),
    UNSUBACK    (11),
    PINGREQ     (12),
    PINGRESP    (13),
    DISCONNECT  (14);

    private int type;

    PacketTypes(int type){
        this.type =  type;
        }


}
