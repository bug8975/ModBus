import com.serotonin.modbus4j.exception.ModbusTransportException;
import entity.User;
import dao.UserDao1;
import dao.UserDaoImpl1;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Administrator on 2017/1/4.
 */
@Controller
public class TestModBusConnect{
  @Autowired
    private Dao dao;
    private ModBusMasterWrapperTest modBusMasterWrapperTest=new ModBusMasterWrapperTest("127.0.0.1",502,2);

    public ModBusMasterWrapperTest getModBusMasterWrapperTest() {
        return modBusMasterWrapperTest;
    }

    public void setModBusMasterWrapperTest(ModBusMasterWrapperTest modBusMasterWrapperTest) {
        this.modBusMasterWrapperTest = modBusMasterWrapperTest;
    }



    public String getHost() {
        return modBusMasterWrapperTest.getHostIp();
    }

    public int getPort() {
        return modBusMasterWrapperTest.getHostPort();
    }

    public int getSlaveId() {
        return modBusMasterWrapperTest.getSlaveId();
    }

    public boolean connect() {
        return modBusMasterWrapperTest.connect();
    }

    public void disconnect() {
        modBusMasterWrapperTest.disconnect();
    }

    public boolean isConnected() {
        return modBusMasterWrapperTest.isConnected();
    }


    public Integer[] readHoldingRegisterValues(int startOffset, int numberOfRegisters) {
        short[] values = new short[numberOfRegisters];
        try {
            values = modBusMasterWrapperTest.readHoldingRegisterValues(startOffset, numberOfRegisters);
        } catch (ModbusTransportException m) {
            m.printStackTrace();

        }
        Integer[] newValues = new Integer[numberOfRegisters];
        for (int i = 0; i < values.length; i++) {
            newValues[i] = Short.valueOf(values[i]).intValue();
        }
        return newValues;
    }
    public void writeRegisterValues(int startOffset, short[] values) {
        try {
            modBusMasterWrapperTest.writeRegisterValues(startOffset, values);
        } catch (ModbusTransportException m) {

            m.printStackTrace();
        }
    }
    @Test
    public void TestReadvalues()
    {
        TestModBusConnect testModBusConnect=new TestModBusConnect();
        testModBusConnect.connect();
       Integer[] values= testModBusConnect.readHoldingRegisterValues(0,5);
        for(int i=0;i<=4;i++)
        {
            System.out.println("values is"+values[i]);
        }

    }
    @Test
    public void writeValues()
    {
        TestModBusConnect testModBusConnect=new TestModBusConnect();
        testModBusConnect.connect();
                short[] zhi={5,4,3,2,1};
        testModBusConnect.writeRegisterValues(0,zhi);

    }
    @Test
    public void askMove()
    {
        RestTemplate restTemplate = new RestTemplate();
     String result=   restTemplate.getForObject("http://127.0.0.1:8080/" + "askMove?i=1", String.class);
        if(result.equals("1")){

            System.out.println("success");;

        }else{
            System.out.println("error----------");
        }
    }
    @Test
    public void saveDatabase()
    {

        TestModBusConnect testModBusConnect=new TestModBusConnect();
        testModBusConnect.connect();
        int value=testModBusConnect.getPort();
        UserDao1 userdao=new UserDaoImpl1();


    }

}
