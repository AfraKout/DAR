import com.sun.corba.se.pept.broker.Broker;
import org.apache.activemq.broker.BrokerService;
public class ActiveMQBroker {
    public static void main(String[] args) {
        try {
            BrokerService brokerService = new BrokerService();
            brokerService.addConnector("tcp://0.0.0.0:61616");
            Brokerservice.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}