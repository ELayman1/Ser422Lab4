package edu.asupoly.ser422.restexample.services.msging;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
   This simple producer pushes a single text message to a Queue. The Queue
   is command-line argument 0 and the text message is command-line argument 1.
   Run the corresponding QConsumer to consume the message.
 */
public class QProducer {

	String newMsg = "";

	public QProducer(String msg){
		newMsg = msg;
	}

	public void thread(Runnable runnable, boolean daemon) {
		Thread brokerThread = new Thread(runnable);
		brokerThread.setDaemon(daemon);
		brokerThread.start();
	}

	public void sendMessage(){
		try{
			thread(new MsgProducer(),false);
			System.out.println("Message Sent");
		} catch (Exception e){
			e.printStackTrace();
		} catch (Throwable tw){
			tw.printStackTrace();
		}
	}

	public class MsgProducer implements Runnable {
		public void run() {
			try {
				// Create a ConnectionFactory
				ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");

				// Create a Connection
				Connection connection = connectionFactory.createConnection();
				connection.start();

				// Create a Session
				Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

				// Create the destination (Topic or Queue)
				Destination destination = session.createQueue("lab4log");

				// Create a MessageProducer from the Session to the Topic or Queue
				MessageProducer producer = session.createProducer(destination);
				producer.setDeliveryMode(DeliveryMode.PERSISTENT);

				// Create a messages
				TextMessage msg = session.createTextMessage(newMsg);

				// Tell the producer to send the message
				System.out.println("\nSent message:\n" + msg.getText() + "to queue lab4log.\n");
				producer.send(msg);

				// Clean up
				session.close();
				connection.close();
			}
			catch (Exception e) {
				System.out.println("Caught: " + e);
				e.printStackTrace();
			}
		}
	}
}
