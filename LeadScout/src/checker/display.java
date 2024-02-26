/**
 * 
 */
package checker;
import javax.swing.JFileChooser;
//import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JOptionPane;

/**
 * @author Will Logan
 * @version 1.0
 */
public class display {
	public static void main(String [] args) {
		JOptionPane.showMessageDialog(null, "Choose newsletter file");
		FileNameExtensionFilter csvFilter = new FileNameExtensionFilter("CSV Files", "csv");
//		JFrame frame = new JFrame("Choose Newsletter file");
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JFileChooser newsOrEvents = new JFileChooser();
		newsOrEvents.setFileFilter(csvFilter);
//		frame.add(newsOrEvents);
		int validOption = newsOrEvents.showOpenDialog(null);
		String pathNewsletter = "";
		if(validOption == JFileChooser.APPROVE_OPTION) {
			pathNewsletter = newsOrEvents.getSelectedFile().getAbsolutePath();
		}
		else {
			System.exit(0);
		}
		
//		frame.pack();
//		frame.setVisible(false);
		
//		frame.setTitle("Choose events file");
		JOptionPane.showMessageDialog(null, "Choose events file");
		validOption = newsOrEvents.showOpenDialog(null);
		String pathEvents = "";
		if(validOption == JFileChooser.APPROVE_OPTION) {
			pathEvents = newsOrEvents.getSelectedFile().getAbsolutePath();
		}
		else {
			System.exit(0);
		}
		
		String fileName = JOptionPane.showInputDialog(null, "Enter a File Name");
		if(!pathNewsletter.isBlank() && !pathEvents.isBlank() && fileName != null) {
			Checker check = new Checker(pathNewsletter, pathEvents, fileName + ".csv");
			try {
				check.emailSearch();
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
			JOptionPane.showMessageDialog(null, fileName + ".csv has been created");
		}
		else {
			System.exit(0);
		}
		
	}
}
