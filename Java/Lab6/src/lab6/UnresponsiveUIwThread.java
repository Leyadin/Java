//Jason Rutledge
//Lab 6
//Purpose: Implement multithread processing

package lab6;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UnresponsiveUIwThread extends JFrame {
	private static final long serialVersionUID = 1L;
	// Start or stop counter flag
	private static boolean stop = false;
	private static JTextField tfCount;
	private static int count = 1;

	public UnresponsiveUIwThread() {
		Container cp = this.getContentPane();
		cp.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		cp.add(new JLabel("Counter"));
		tfCount = new JTextField(count + " ", 10);
		tfCount.setEditable(false);
		cp.add(tfCount);
		JButton btnStart = new JButton("Start Counting");
		cp.add(btnStart);
		btnStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				Thread t = new Thread(new CountingTask());
				t.start();
			}
		});
		
		JButton btnStop = new JButton("Stop Counting");
		cp.add(btnStop);
		btnStop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				// Signal that we need to stop
				stop = true;
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Counter");
		setSize(300, 120);
		setVisible(true);
		
	}
	
	public static class CountingTask implements Runnable {
		@Override
		public void run() {
			stop = false;
			for (int i = 0; i < 100000; i++) {
				// Check if STOP button has been pushed
				// which changes the stop flag state to true
				if (stop)
					break;
				tfCount.setText(count + " ");
				++count;
				//Release processing to other threads
				try {
					if (i % 100 == 0)
						Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// Run GUI codes in Event-Dispatching thread for thread safety
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// Let the constructor do the job
				new UnresponsiveUIwThread();
			}
		});
	}
}