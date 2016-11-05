package internet.of.drinks.servo;

import com.tinkerforge.BrickServo;
import com.tinkerforge.IPConnection;
import com.tinkerforge.NotConnectedException;
import com.tinkerforge.TimeoutException;
import internet.of.drinks.IpConnection;

/**
 * Created by Martin on 05.11.2016.
 */
public class ServoDriver {
    public static final String SERVO_BRICKLET_UID = "5VEMoA";
    private final BrickServo brickServo;

    public ServoDriver(String brickUid) {
        IPConnection connection = IpConnection.INSTANCE.getConnection();
        brickServo = new BrickServo(brickUid, connection);
        initServo();
    }

    private void initServo() {
        try {
            brickServo.enable((byte) 0);
        } catch (TimeoutException | NotConnectedException e) {
            e.printStackTrace();
        }
    }

    public void setServoPosition(int position) {
        try {
            brickServo.setPosition((byte) 0, (short) position);
        } catch (TimeoutException | NotConnectedException e) {
            e.printStackTrace();
        }
    }

    public void setServoPosition(double bac) {

        //capping extreme values to fit the scale
        if(bac < 0D) {
            bac = 0D;
        } else if(bac > 1.5D) {
            bac = 1.5D;
        }
        int servoPosition = (int) (12000 * bac - 9000);
        setServoPosition(servoPosition);
    }

    public static void main(String[] args) throws InterruptedException {
        ServoDriver servoDriver = new ServoDriver(SERVO_BRICKLET_UID);
        /*for(int i = -9000; i<= 9000; i += 100) {
            servoDriver.setServoPosition(i);
            Thread.currentThread().sleep(50);
        }*/

        servoDriver.setServoPosition(-9000);

    }
}
