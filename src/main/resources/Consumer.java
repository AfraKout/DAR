import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.*;
public class Consumer{
    public static void main(String[] args) {
        try {
            // Établissement de la connexion avec le courtier ActiveMQ
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616"); //broker url hetha
            Connection connection = connectionFactory.createConnection();
            connection.start();
            // Création de la session
            Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createTopic("myTopic.topic");
            //taw bch nsn3ou a message consumer
            MessageConsumer consumer = session.createConsumer(destination);
            //bch nasn3ou listener ychouf(ysm3) kn fma msg wla le
            consumer.setMessageListener(new MessageListener() {
                @Override
                //ki ydetecti msg ylanci hethy
                public void onMessage(Message message) {
                    if (message instanceof TextMessage)
                        TextMessage textMessage = (TextMessage) message;
                    System.Out.println("Message reçu : " +textMessage.getText());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
});